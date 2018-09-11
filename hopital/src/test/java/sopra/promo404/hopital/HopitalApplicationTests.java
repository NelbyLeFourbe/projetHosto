package sopra.promo404.hopital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.repository.IRepositoryPatient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HopitalApplicationTests {

	@Autowired
	private IRepositoryPatient repoPatient;

	@Test
	public void contextLoads() {
		
//		Patient creation

		Patient gerard = new Patient();
		gerard.setNom("Gerard");

		repoPatient.save(gerard);
		
		Patient gilles = new Patient();
		gilles.setNom("Gilles");

		repoPatient.save(gilles);
		
//		Secretaire creation
		
		Secretaire jeanlou = new Secretaire(); 
		
		
		
	}
}
