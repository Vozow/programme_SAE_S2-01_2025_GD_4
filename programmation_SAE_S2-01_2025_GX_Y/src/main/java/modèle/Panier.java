package modèle;
import java.util.ArrayList;
import java.util.List;

public class Panier {

	
	private List<Tomate> listePanier;
	
	
	public Panier() {
		this.listePanier = new ArrayList<Tomate>();
	}
	
	
	public int getSize() {
		return this.listePanier.size();
	}
	
	
	public int getNbDeUnTypeDeTomate(Tomate tomate) {
		int nombreDeTomateDuType = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate) nombreDeTomateDuType++;
		}
		return nombreDeTomateDuType;
	}
	
	
	public List<Tomate> getTomatesPresentes(List<Tomate> tomates){
		List<Tomate> tomatesPresentes = new ArrayList<Tomate>();
		for(Tomate tomate : tomates) {
			if(this.listePanier.contains(tomate)) tomatesPresentes.add(tomate);
		}
		return tomatesPresentes;
	}
	
	
	public void removeTomate(Tomate tomate, int nb) throws IllegalArgumentException {
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate && nb > 0) {
				this.listePanier.remove(i);
				nb--;
				i--;
			}
		}
		if(nb > 0) throw new IllegalArgumentException("Nombre de tomate a supprimer supérieur au nombre de tomate présent.");
	}
	
	
	public void addTomate(Tomate tomate, int nb) {
		for(int i = 0; i < nb; i++) {
			this.listePanier.add(tomate);
		}
	}
	
	
	public void deleteTomate(Tomate tomate) {
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate) {
				this.listePanier.remove(i);
				i--;
			}
		}
	}
	
	
	public float getPrixDeUnTypeDeTomate(Tomate tomate) {
		float total = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate) {
				total =+ tomate.getPrixTTC();
			}
		}
		return total;
	}
	
	
	public float getPrixTotal() {
		float total = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
				total += this.listePanier.get(i).getPrixTTC();
		}
		return total;
	}
	
	
}
