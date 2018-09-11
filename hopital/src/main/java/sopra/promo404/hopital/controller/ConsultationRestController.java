package sopra.promo404.hopital.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.model.Consultation;
import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepositoryConsultation;
import sopra.promo404.hopital.repository.IRepositoryPatient;

@Controller
@RequestMapping("/patient")
public class ConsultationRestController {

	@Autowired
	private IRepositoryConsultation consultationRepo;
	
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewConsultation.class)
	public List<Consultation> list() {
		return consultationRepo.findAllConsultation();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewPatientWithConsultations.class)
	public Patient detail(@PathVariable Long id) {
		return consultationRepo.findByIdWithSalles(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewConsultation.class)
	public Consultation add(@RequestBody Consultation consultation) {
		consultationRepo.save(consultation);

		return consultation;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewConsultation.class)
	public Consultation edit(@RequestBody Consultation consultation, @PathVariable Long id) {
		consultationRepo.save(consultation);

		return (Consultation) consultationRepo.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewConsultation.class)
	public void delete(@PathVariable Long id) {
		consultationRepo.deleteById(id);
	}
}
