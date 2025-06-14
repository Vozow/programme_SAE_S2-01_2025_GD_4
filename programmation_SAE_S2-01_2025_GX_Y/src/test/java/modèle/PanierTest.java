package modèle;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;

public class PanierTest {

	//Test de la classe panier créer par nous
	//Le sous total de la facture se fait également ici
	//Les autres calculs de facture se font sur la page a
	//	a partir du sous-total calculé par le panier
	
    private static Tomates tomates;
    
    @BeforeClass
    public static void setUp() {
        tomates = OutilsBaseDonneesTomates.générationBaseDeTomates(
                "src/main/resources/data/tomates.json");
    }

    @Test
    public void testCréePanierVide() {
    	Panier panier = new Panier();
    	assertTrue(panier.isEmpty());
    }
    
    @Test
    public void testObtenirTailleDUnPanierDeTailleAleatoire() {
    	Panier panier = new Panier();
    	Random random = new Random();
    	int nbTomate = random.nextInt(30);
    	//Ajoute la premiere tomate existante n nombre de fois 
    	//Ou n est aleatoire entre 0 et 30
    	panier.addTomate(tomates.getTomates().get(0), nbTomate);
    	assertEquals(nbTomate, panier.getSize());
    }
    
    @Test
    public void testObtenirTailleDUnPanierVide() {
    	Panier panier = new Panier();
    	assertEquals(0, panier.getSize());
    }

    @Test
    public void testObtenirNbDeTomateDeUnTypeDeNombreAleatoire() {
    	Panier panier = new Panier();
    	Random random = new Random();
    	int nbTomate = random.nextInt(30);
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	panier.addTomate(tomate, nbTomate);
    	assertEquals(nbTomate, panier.getNbDeUnTypeDeTomate(tomate));
    }
	
    @Test
    public void testObtenirNbDeTomateDeUnTypeNonPresent() {
    	Panier panier = new Panier();
    	Random random = new Random();
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	assertEquals(0, panier.getNbDeUnTypeDeTomate(tomate));
    }
	
	@Test
	public void testObtenirUneListeDeTomatesPresentesAleatoire() {
		Panier panier = new Panier();
    	Random random = new Random();
    	int nbTomate = random.nextInt(10);
    	List<Tomate> listeTomate = new ArrayList<Tomate>();
    	for(int i = 0; i < nbTomate; i++) {
        	panier.addTomate(tomates.getTomates().get(i), 1);
        	listeTomate.add(tomates.getTomates().get(i));
    	}
    	assertTrue(listeTomate.containsAll(panier.getTomatesPresentes(tomates)));    	
	}
	
	@Test
	public void testObtenirUneListeDeTomatesPresentesVide() {
		Panier panier = new Panier();
    	assertEquals(0, panier.getTomatesPresentes(tomates).size());   
	}
	
	@Test
	public void testRetirerUnNombreDeTomatePossible() {
		Panier panier = new Panier();
    	Random random = new Random();
    	int nbTomate = random.nextInt(20) + 10;
    	int nbTomateARetiré = nbTomate - 5;
    	panier.addTomate(tomates.getTomates().get(0), nbTomate);
    	panier.removeTomate(tomates.getTomates().get(0), nbTomateARetiré);
    	assertEquals(nbTomate-nbTomateARetiré, panier.getNbDeUnTypeDeTomate(tomates.getTomates().get(0)));
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void testRetirerUnNombreDeTomateImpossible() {
		Panier panier = new Panier();
    	Random random = new Random();
    	int nbTomate = random.nextInt(30);
    	int nbTomateARetiré = nbTomate + 5;
    	panier.addTomate(tomates.getTomates().get(0), nbTomate);
    	panier.removeTomate(tomates.getTomates().get(0), nbTomateARetiré);
    	panier.removeTomate(tomates.getTomates().get(0), -1);
	}
	
	@Test
	public void testAjouterUnNombreDeTomateDeUnTypeAleatoire() {
		Panier panier = new Panier();
    	Random random = new Random();
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	int nbTomate = random.nextInt(30);
    	panier.addTomate(tomate, nbTomate);
    	assertEquals(nbTomate, panier.getNbDeUnTypeDeTomate(tomate));
	}
	
	@Test
	public void testSupprimerUnTypeDeTomate() {
		Panier panier = new Panier();
    	Random random = new Random();
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	int nbTomate = random.nextInt(30);
    	panier.addTomate(tomate, nbTomate);
    	panier.deleteTomate(tomate);
    	assertEquals(0, panier.getNbDeUnTypeDeTomate(tomate));
	}
	
	@Test
	public void testObtenirLePrixTotalDeUnTypeDeTomatePresente() {
		Panier panier = new Panier();
    	Random random = new Random();
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	int nbTomate = random.nextInt(30);
    	panier.addTomate(tomate, nbTomate);
    	assertEquals(tomate.getPrixTTC()*nbTomate, panier.getPrixDeUnTypeDeTomate(tomate), 0.01f);
	}
	
	@Test
	public void testObtenirLePrixTotalDeUnTypeDeTomateNonPresente() {
		Panier panier = new Panier();
    	Random random = new Random();
    	Tomate tomate = tomates.getTomates().get(random.nextInt(tomates.getTomates().size()-1));
    	assertEquals(0.0f, panier.getPrixDeUnTypeDeTomate(tomate), 0.01f);
	}
	
	@Test
	public void testObtenirPrixTotalDeUnPanierVide() {
		Panier panier = new Panier();
    	assertEquals(0.0f, panier.getPrixTotal(), 0.01f);
	}
	
	@Test
	public void testObtenirPrixTotalDeUnPanierNonVide() {
		Panier panier = new Panier();
    	Random random = new Random();
    	int nbTypeDeTomate = random.nextInt(10);
    	float total = 0.0f;
    	for(int i = 0; i < nbTypeDeTomate; i++) {
    		int nbTomate = random.nextInt(30);
        	panier.addTomate(tomates.getTomates().get(i), nbTomate);
        	total += tomates.getTomates().get(i).getPrixTTC() * nbTomate;
    	}
    	assertEquals(total, panier.getPrixTotal(), 0.01f);
	}
	
	@Test
	public void testViderUnPanier() {
		Panier panier = new Panier();
    	Random random = new Random();
    	int nbTypeDeTomate = random.nextInt(10);
    	for(int i = 0; i < nbTypeDeTomate; i++) {
    		int nbTomate = random.nextInt(30);
        	panier.addTomate(tomates.getTomates().get(i), nbTomate);
    	}
    	panier.vider();
    	assertEquals(0, panier.getSize());
	}
	
}
