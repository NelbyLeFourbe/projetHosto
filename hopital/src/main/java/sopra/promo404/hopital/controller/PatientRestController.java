package sopra.promo404.hopital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepositoryPatient;

@Controller
@RequestMapping("/patient")
public class PatientRestController {

	@Autowired
	private IRepositoryPatient patientRepo;
	
	
	@GetMapping(value = { "", "/list" })
	public String list(Model model) {
		List<Patient> patients = patientRepo.findAllPatient();

		model.addAttribute("patients", patients);

		return "patient/patients";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("monPatient", new Patient());
		
		return "patient/patientForm";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<Patient> patient = patientRepo.findById(id);

		if (patient.isPresent()) {
			model.addAttribute("monPatient", patient.get());
		} else {
			model.addAttribute("monPatient", new Patient());
		}
		
		

		return "patient/patientForm";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("monPatient") Patient patient) {
		
		
		
		patientRepo.save(patient);

		return "redirect:list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		patientRepo.deleteById(id);

		return "forward:../list";
	}

}


