package sopra.promo404.hopital.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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



import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.exception.PatientValidationException;
import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepositoryPatient;

@RestController
@RequestMapping("/patient")
public class PatientRestController {

	@Autowired
	private IRepositoryPatient patientRepo;
	
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewPatient.class)
	public List<Patient> list() {
		return patientRepo.findAllPatient();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewPatientWithConsultation.class)
	public Patient detail(@Valid @PathVariable Long id) {
		return patientRepo.findPatientByIdWithConsultations(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewPatient.class)
	public Patient add(@RequestBody Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			throw new PatientValidationException("Nom oublie");
		}
		patientRepo.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewPatient.class)
	public Patient edit(@RequestBody Patient patient, @PathVariable Long id) {
		patientRepo.save(patient);

		return  patientRepo.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public void delete(@PathVariable Long id) {
		patientRepo.deleteById(id);
	}
}
