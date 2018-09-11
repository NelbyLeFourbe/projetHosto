package sopra.promo404.hopital.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import sopra.promo404.hopital.model.Salle;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepositorySalle;

@RestController
@RequestMapping("/salle")
public class SalleRestController {
	@Autowired
	private IRepositorySalle salleRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public List<Salle> list() {
		return salleRepo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Salle> detail(@PathVariable Long id) {
		return salleRepo.findById(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public Salle add(@RequestBody Salle salle) {
		salleRepo.save(salle);

		return salle;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public Salle edit(@RequestBody Salle salle, @PathVariable Long id) {
		salleRepo.save(salle);

		return (Salle) salleRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSalle.class)
	public void delete(@PathVariable Long id) {
		salleRepo.deleteById(id);
	}
}
