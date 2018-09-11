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

import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepositoryFileAttente;

@RestController
@RequestMapping("/fileAttente")
public class FileAttenteRestController {

	@Autowired
	private IRepositoryFileAttente fileAttenteRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewFileAttente.class)
	public List<FileAttente> list() {
		return fileAttenteRepo.findAllFileAttente();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewFileAttenteWithSecretaire.class)
	public FileAttente detail(@PathVariable Long id) {
		return fileAttenteRepo.findFileAttenteByIdWithSecretaire(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewFileAttente.class)
	public FileAttente add(@RequestBody FileAttente fileAttente) {
		fileAttenteRepo.save(fileAttente);

		return fileAttente;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewFileAttente.class)
	public FileAttente edit(@RequestBody FileAttente fileAttente, @PathVariable Long id) {
		fileAttenteRepo.save(fileAttente);

		return (FileAttente) fileAttenteRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewFileAttente.class)
	public void delete(@PathVariable Long id) {
		fileAttenteRepo.deleteById(id);
	}
}