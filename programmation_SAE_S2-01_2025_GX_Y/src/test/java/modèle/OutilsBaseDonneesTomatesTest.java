package modèle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OutilsBaseDonneesTomatesTest {

	//Test de la base d'écriture/lecture de la base de données
	//Dans notre application, la sauvegarde se fait a l'aide
	//	de l'outils base de données au sein des fonctions des
	//	page.
	
	@Before
	public void setUp() {
		Tomates tomatesSauvegarde = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomatesSauvegarde.json");
		OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(tomatesSauvegarde, "./src/main/resources/data/tomates.json");
	}
	
	@Test
	public void testGénérationBaseDeDonnées() {
		Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		assertFalse(tomates.getTomates().isEmpty());
	}

	@Test
	public void testGénérationDeuxBaseDeDonnées() {
		Tomates tomates1 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		Tomates tomates2 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		assertTrue(tomates1.getTomates().equals(tomates2.getTomates()));
	}
	
	@Test
	public void testSauvegarderUneBaseDeDonnées() {
		Tomates tomates1 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomatesSauvegarde.json");
		Tomates tomates2 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		tomates1.getTomates().remove(0);
		OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(tomates1, "./src/main/resources/data/tomates.json");
		Tomates tomates3 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		assertFalse(tomates3.getTomates().equals(tomates2.getTomates()));
		tomates2.getTomates().remove(0);
		assertTrue(tomates3.getTomates().equals(tomates2.getTomates()));
	}
	
	@Test
	public void testViderBaseDeDonnées() {
		Tomates tomates = new Tomates();
		OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(tomates, "./src/main/resources/data/tomates.json");
		Tomates tomates1 = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
		assertTrue(tomates1.getTomates().isEmpty());
	}
	
	@After
	public void finished() {
		Tomates tomatesSauvegarde = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomatesSauvegarde.json");
		OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(tomatesSauvegarde, "./src/main/resources/data/tomates.json");
	}
	
}
