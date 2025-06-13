package lancement;

import java.awt.EventQueue;

import ihm.FenetrePrincipal;
import ihm.FenetreReset;
import modèle.OutilsBaseDonneesTomates;
import modèle.Panier;
import modèle.Tomates;

public class LancementApplication {

	//CLASS PERMETTANT DE LANCER L'APPLICATION
	
	//Fonction qui démarre l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FENETRE POPUP AU DEMARRAGE DE L'APPLICATION POUR DEMANDER
					//SI ON VEUX REINITIALISER LA BASE DE DONNEES
					FenetreReset fenReset = new FenetreReset();
					fenReset.setVisible(true);
					//Initialisation de la base de donnée
					Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
					FenetrePrincipal.panier = new Panier();
					//Initialisation de la fenetre
					FenetrePrincipal fenPrincipal = new FenetrePrincipal(tomates);
					fenPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
