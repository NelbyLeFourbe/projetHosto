package sopra.promo404.hopital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.hopital.model.Civilite;
import sopra.promo404.hopital.model.Consultation;
import sopra.promo404.hopital.model.Convention;
import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Medecin;
import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.model.Salle;
import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.model.Specialite;
import sopra.promo404.hopital.repository.IRepositoryConsultation;
import sopra.promo404.hopital.repository.IRepositoryFileAttente;
import sopra.promo404.hopital.repository.IRepositoryMedecin;
import sopra.promo404.hopital.repository.IRepositoryPatient;
import sopra.promo404.hopital.repository.IRepositorySalle;
import sopra.promo404.hopital.repository.IRepositorySecretaire;
import sopra.promo404.hopital.repository.IRepositorySpecialite;

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
	@Autowired
    private IRepositorySpecialite specRepo;
    @Autowired
    private IRepositoryMedecin medicRepo;
    @Autowired
    private IRepositoryConsultation consultationRepo;

	@Test
	public void contextLoads() throws ParseException {
		
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
		file1.setSecretaire(dolores);
		fileAttenteRepo.save(file1);
		
		FileAttente file2 = new FileAttente();
		file2.setCapacite(30);
		file2.setVersion(1);
		file2.setSecretaire(carlotta);
		
		fileAttenteRepo.save(file2);
		
		  // Specialite creation
        Specialite ortho = new Specialite();
        ortho.setLibelle("ortho");
        ortho.setTarif(1551f);
        ortho.setVersion(0);
        specRepo.save(ortho);
        
        Specialite cardio = new Specialite();
        cardio.setLibelle("cardio");
        cardio.setTarif(2589f);
        cardio.setVersion(0);
        
        
        specRepo.save(cardio);
		
		 // Medecin creation
        Medecin jeangillou = new Medecin();
        jeangillou.setNom("De La Godasse");
        jeangillou.setPrenom("Jean-Gillou");
        jeangillou.setConventionne(Convention.s1);
        jeangillou.setCarteVitale(true);
        jeangillou.setCmu(false);
        cardio.setMedecin(jeangillou);
        jeangillou.setVersion(0);       
        medicRepo.save(jeangillou);
                
        Medecin jeanphil = new Medecin();
        jeanphil.setNom("De La Cagade");
        jeanphil.setPrenom("Jean-Phil");
        jeanphil.setConventionne(Convention.s2);
        jeanphil.setCarteVitale(false);
        jeanphil.setCmu(true);
        cardio.setMedecin(jeanphil);
        ortho.setMedecin(jeanphil);
        jeanphil.setVersion(0);
        
        medicRepo.save(jeanphil);
        
              
        		
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
		gerard.setVersion(0);
		
		repoPatient.save(gerard);
		
		Patient gilles = new Patient();
		gilles.setNom("De la Tourette");
		gilles.setPrenom("Gilles");
		gilles.setCivilite(Civilite.M);
		gilles.setNumeroSecuriteSocial("654321ZA");
		gilles.setFileAttente(file2);
		gilles.setVersion(0);
		
		repoPatient.save(gilles);
		
 // consultation creation
        
        Consultation consultation1 = new Consultation();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        consultation1.setDateVisiteArrivee(sdf.parse("12/12/1998"));
        consultation1.setDateVisiteFin(sdf.parse("13/12/1998"));
        consultation1.setVersion(0);
        
        consultation1.setPatient(gilles);
        consultationRepo.save(consultation1);
        
        Consultation consultation2 = new Consultation();
        
        consultation2.setDateVisiteArrivee(sdf.parse("16/12/1998"));
        consultation2.setDateVisiteFin(sdf.parse("18/12/1998"));
        consultation2.setVersion(0);
        
        consultation2.setPatient(gerard);
        consultationRepo.save(consultation2);
		
		

        
        
   
	}
}

