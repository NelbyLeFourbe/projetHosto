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

import sopra.promo404.hopital.model.Specialite;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepositorySpecialite;

@RestController
@RequestMapping("/specialite")
public class SpecialiteRestController {
	@Autowired
	private IRepositorySpecialite specRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public List<Specialite> list() {
		return specRepo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSpecialiteWithConsultation.class)
	public Specialite detail(@PathVariable Long id) {
		return specRepo.findSpecialiteByIdWithConsultation(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public Specialite add(@RequestBody Specialite specialite) {
		specRepo.save(specialite);

		return specialite;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public Specialite edit(@RequestBody Specialite specialite, @PathVariable Long id) {
		specRepo.save(specialite);

		return (Specialite) specRepo.findById(id).get();
	}

	@PatchMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public Specialite partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Specialite specialite = (Specialite) specRepo.findById(id).get();

		for (String key : fields.keySet()) {
			Object value = fields.get(key);

			Field field = ReflectionUtils.findField(Specialite.class, key);

			if (field.getType().equals(Long.class)) {
				value = Long.valueOf(value.toString());
			}

			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, specialite, value);
		}

		specRepo.save(specialite);

		specialite = (Specialite) specRepo.findById(id).get();

		return specialite;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public void delete(@PathVariable Long id) {
		specRepo.deleteById(id);
	}
}
