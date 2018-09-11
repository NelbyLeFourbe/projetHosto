package sopra.promo404.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Medecin;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepositoryMedecin;

@RestController
@RequestMapping("/medecin")
public class MedecinRestController {
	@Autowired
	private IRepositoryMedecin medicRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public List<Medecin> list() {
		return medicRepo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMedecinWithSpecialite.class)
	public Medecin detail(@PathVariable Long id) {
		return medicRepo.findMedecinByIdWithSpecialite(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public Medecin add(@RequestBody Medecin medecin) {
		medicRepo.save(medecin);

		return medecin;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public Medecin edit(@RequestBody Medecin medecin, @PathVariable Long id) {
		medicRepo.save(medecin);

		return (Medecin) medicRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewMedecin.class)
	public void delete(@PathVariable Long id) {
		medicRepo.deleteById(id);
	}
}
