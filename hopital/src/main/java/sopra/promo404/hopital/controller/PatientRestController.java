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

import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepositoryPatient;

@Controller
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
	@JsonView(Views.ViewPatientWithConsultations.class)
	public Patient detail(@PathVariable Long id) {
		return patientRepo.findPatientByIdWithConsultations(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewPatient.class)
	public Patient add(@RequestBody Patient patient) {
		patientRepo.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewPatient.class)
	public Patient edit(@RequestBody Patient patient, @PathVariable Long id) {
		patientRepo.save(patient);

		return (Patient) patientRepo.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public void delete(@PathVariable Long id) {
		patientRepo.deleteById(id);
	}
}
