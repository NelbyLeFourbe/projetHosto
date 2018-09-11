package sopra.promo404.hopital.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.formation.model.Eleve;
import sopra.promo404.formation.model.Views;
import sopra.promo404.formation.repository.IRepositoryPersonne;
import sopra.promo404.hopital.repository.IRepositorySecretaire;

@RestController
@RequestMapping("/secretaire")
public class SecretaireRestController {

    @Autowired
    private IRepositorySecretaire seccretaireRepo;

    @GetMapping("")
    @ResponseBody
    @JsonView(Views.ViewEleve.class)
    public List<Eleve> list() {
        return personneRepo.findAllEleve();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @JsonView(Views.ViewEleveWithOrdinateur.class)
    public Eleve detail(@PathVariable Long id) {
        return personneRepo.findEleveByIdWithOrdinateur(id);
    }

    @PostMapping("")
    @ResponseBody
    @JsonView(Views.ViewEleve.class)
    public Eleve add(@RequestBody Eleve eleve) {
        personneRepo.save(eleve);

        return eleve;
    }

    @PutMapping("/{id}")
    @ResponseBody
    @JsonView(Views.ViewEleve.class)
    public Eleve edit(@RequestBody Eleve eleve, @PathVariable Long id) {
        personneRepo.save(eleve);

        return (Eleve) personneRepo.findById(id).get();
    }

    @PatchMapping("/{id}")
    @ResponseBody
    @JsonView(Views.ViewEleve.class)
    public Eleve partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
        Eleve eleve = (Eleve) personneRepo.findById(id).get();

        for (String key : fields.keySet()) { // id=67 version=1 nom="HTML"
            Object value = fields.get(key);

            Field field = ReflectionUtils.findField(Eleve.class, key);

            if (field.getType().equals(Long.class)) {
                value = Long.valueOf(value.toString());
            }

            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, eleve, value);
        }

        personneRepo.save(eleve);

        eleve = (Eleve) personneRepo.findById(id).get();

        return eleve;
    }

    @DeleteMapping("/{id}")
    @JsonView(Views.ViewEleve.class)
    public void delete(@PathVariable Long id) {
        personneRepo.deleteById(id);
    }
}