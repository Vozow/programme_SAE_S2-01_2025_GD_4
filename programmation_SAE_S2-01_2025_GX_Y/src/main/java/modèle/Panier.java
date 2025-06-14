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
	
	public boolean isEmpty() {
		return this.listePanier.size() == 0;
	}
	
	public int getNbDeUnTypeDeTomate(Tomate tomate) {
		int nombreDeTomateDuType = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate) nombreDeTomateDuType++;
		}
		return nombreDeTomateDuType;
	}
	
	
	public List<Tomate> getTomatesPresentes(Tomates tomates){
		List<Tomate> tomatesPresentes = new ArrayList<Tomate>();
		for(Tomate tomate : tomates.getTomates()) {
			if(this.listePanier.contains(tomate)) tomatesPresentes.add(tomate);
		}
		return tomatesPresentes;
	}
	
	
	public void removeTomate(Tomate tomate, int nb) throws IllegalArgumentException {
		if(this.getNbDeUnTypeDeTomate(tomate) - nb < 0) throw new IllegalArgumentException("Nombre de tomate a supprimer supérieur au nombre de tomate présent.");
		if(nb < 0) throw new IllegalArgumentException("Nombre de tomate a supprimer négatif.");
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate && nb > 0) {
				this.listePanier.remove(i);
				nb--;
				i--;
			}
		}
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
		int total = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
			if(this.listePanier.get(i) == tomate) {
				total++;
			}
		}
		return total * tomate.getPrixTTC();
	}
	
	
	public float getPrixTotal() {
		float total = 0;
		for(int i = 0; i < this.listePanier.size(); i++) {
				total += this.listePanier.get(i).getPrixTTC();
		}
		return total;
	}


	public void vider() {
		for(int i = this.listePanier.size() - 1; i >= 0; i--) {
			this.listePanier.remove(0);
		}
	}
	
	
}
