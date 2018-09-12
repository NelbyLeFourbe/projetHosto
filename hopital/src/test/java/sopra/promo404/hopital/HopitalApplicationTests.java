package sopra.promo404.hopital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.hopital.model.Civilite;
import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.model.Salle;
import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.repository.IRepositoryFileAttente;
import sopra.promo404.hopital.repository.IRepositoryPatient;
import sopra.promo404.hopital.repository.IRepositorySalle;
import sopra.promo404.hopital.repository.IRepositorySecretaire;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HopitalApplicationTests {

	@Autowired
	private IRepositoryPatient repoPatient;
	@Autowired
	private IRepositorySecretaire secretaireRepo;
	@Autowired
	private IRepositoryFileAttente fileAttenteRepo;
	@Autowired
	private IRepositorySalle salleRepo;

	@Test
	public void contextLoads() {
		
//		Secretaire creation
		Secretaire carlotta = new Secretaire();
		carlotta.setNom("Flantier");
		carlotta.setPrenom("Carlotta");
		carlotta.setCivilite(Civilite.MME);
		carlotta.setEnPause(true);
		carlotta.setVersion(2);
		
	
		secretaireRepo.save(carlotta);
		
		Secretaire dolores = new Secretaire();
		dolores.setNom("Delabatte");
		dolores.setPrenom("Dolores");
		dolores.setCivilite(Civilite.MLLE);
		dolores.setEnPause(false);
		dolores.setVersion(2);
	
		secretaireRepo.save(dolores);
		
//		File Attente
		FileAttente file1 = new FileAttente();
		file1.setCapacite(20);
		file1.setVersion(1);
		
		fileAttenteRepo.save(file1);
		
		FileAttente file2 = new FileAttente();
		file2.setCapacite(30);
		file2.setVersion(1);
		
		fileAttenteRepo.save(file2);
		
		
//		Salle
		Salle salle1 = new Salle();
		salle1.setNom("Salle Sifi");
		salle1.setMedecin(jeanphil);
		salle1.setVersion(0);
		salleRepo.save(salle1);
		
		Salle salle2 = new Salle();
		salle2.setNom("Salle Timbanque");
		salle2.setMedecin(jeangillou);
		salle2.setVersion(0);
		salleRepo.save(salle2);
		
//		Patient creation
		
		Patient gerard = new Patient();
		gerard.setNom("Bouchard");
		gerard.setPrenom("Gerard");
		gerard.setCivilite(Civilite.M);
		gerard.setNumeroSecuriteSocial("123456BA");
		gerard.setFileAttente(file1);
		gerard.setConsultations(consultation1);
		gerard.setVersion(0);
		
		repoPatient.save(gerard);
		
		Patient gilles = new Patient();
		gilles.setNom("De la Tourette");
		gilles.setPrenom("Gilles");
		gilles.setCivilite(Civilite.M);
		gilles.setNumeroSecuriteSocial("654321ZA");
		gilles.setFileAttente(file2);
		gilles.setConsultations(consultation2);
		gilles.setVersion(0);
		
		repoPatient.save(gilles);
	}
}

