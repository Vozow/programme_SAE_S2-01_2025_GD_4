package ihm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import modèle.*;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetrePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Tomates tomates;
	private JPanel contentPane;
	private DefaultListModel<Tomate> modeleList;
	
	private JButton btnPanier;
	private JComboBox<String> comboBoxFiltreType;
	private JComboBox<String> comboBoxFiltreCouleur;
	private Couleur couleurActuelle;
	private TypeTomate typeActuel;
	
	private String toutesTomates = "Toutes les Tomates (63)";
	private String toutesCouleurs = "Toutes les Couleurs";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Initialisation de la base de donnée
					Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
					//Initialisation de la fenetre
					FenetrePrincipal frame = new FenetrePrincipal(tomates);
						frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public FenetrePrincipal(Tomates tomates) {
		this.tomates = tomates;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Border Layout principal
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		//Création du panel de tête
		JPanel headpanel = new JPanel();
		contentPane.add(headpanel, BorderLayout.NORTH);		
		headpanel.setLayout(new BorderLayout(0, 0));
		headpanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		//Création du titre
		JLabel lblTitle = new JLabel("O'Tomates");
		lblTitle.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitle.setFont(new Font("Ebrima", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headpanel.add(lblTitle, BorderLayout.CENTER);
		
		
		//Création du bouton Panier
		this.btnPanier = new JButton("-.--€");
		btnPanier.setFont(new Font("Ebrima", Font.BOLD, 15));
		btnPanier.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\buy_resize2.png"));
		headpanel.add(btnPanier, BorderLayout.EAST);
	
		//ScrollPane pour la liste
		JScrollPane ListScrollPane = new JScrollPane();
		contentPane.add(ListScrollPane, BorderLayout.CENTER);
		//Création du modèle de la liste listTomates
		this.modeleList = new DefaultListModel<Tomate>();
		//Création de la listTomates
		JList<Tomate> listTomates = new JList<Tomate>(this.modeleList);
		listTomates.setFont(new Font("Ebrima", Font.PLAIN, 15));
		ListScrollPane.setViewportView(listTomates);
		//Utilisation du modèle pour importer les tomates
		listTomates.setModel(this.modeleList);
		//Utilisation d'un ListCellRenderer pour un affichage personnalisé
		listTomates.setCellRenderer(new TomatesListPainter());
		
		
		//Création du panel contenant les filtres et le bouton conseil
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		bottomPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		
		//Création du panel des filtre avec comboBox
		JPanel filterPanel = new JPanel();
		bottomPanel.add(filterPanel, BorderLayout.CENTER);
		filterPanel.setLayout(new GridLayout(0, 2, 0, 0));
		filterPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		//ComboBox pour le filtre avec type
		this.comboBoxFiltreType = new JComboBox<String>();
		for(TypeTomate type : TypeTomate.values()) {
			this.comboBoxFiltreType.addItem(type.getDénomination());
		}
		this.comboBoxFiltreType.addItem(this.toutesTomates);
		this.comboBoxFiltreType.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.comboBoxFiltreType.setSelectedItem(this.toutesTomates);
		changementTypeTomate();
		filterPanel.add(comboBoxFiltreType);

		//ComboBox pour le filtre avec couleur
		this.comboBoxFiltreCouleur = new JComboBox<String>();
		for(Couleur couleur: Couleur.values()) {
			this.comboBoxFiltreCouleur.addItem(couleur.getDénomination());
		}
		this.comboBoxFiltreCouleur.addItem(this.toutesCouleurs);
		this.comboBoxFiltreCouleur.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.comboBoxFiltreCouleur.setSelectedItem(this.toutesCouleurs);;
		changementCouleur();
		filterPanel.add(comboBoxFiltreCouleur);
		
		
		//Création du panel contenant le bouton conseil
		JPanel conseilPanel = new JPanel();
		bottomPanel.add(conseilPanel, BorderLayout.EAST);
		conseilPanel.setLayout(new BorderLayout(0, 0));
		conseilPanel.setBorder(new EmptyBorder(10, 30, 10, 30));
		
		//Création du bouton conseil
		JButton btnConseil = new JButton();
		btnConseil.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\advice_resize1.png"));
		conseilPanel.add(btnConseil, BorderLayout.EAST);
		
		//Actualisation du bouton panier
		
		
		//Actualisation de la table tableTomates
		this.actualiserListTomates();
	}



	//Fonction appeler lorsque le type de tomate choisi de la comboBox change
	private void changementTypeTomate() {
		this.comboBoxFiltreType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stocke la nouvelle valeur de comboBox en type si possible (cas impossible : "Toutes les Tomates (63)")
				if((String) FenetrePrincipal.this.comboBoxFiltreType.getSelectedItem() != FenetrePrincipal.this.toutesTomates) 
					FenetrePrincipal.this.typeActuel = TypeTomate.getTypeTomate((String) FenetrePrincipal.this.comboBoxFiltreType.getSelectedItem());
				//Appele la fonction pour actualiser la liste
				FenetrePrincipal.this.actualiserListTomates();
			}
		});
	}



	//Fonction appeler lorsque la couleur choisi de la comboBox change
	private void changementCouleur() {
		this.comboBoxFiltreCouleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stocke la nouvelle valeur de comboBox en type si possible (cas impossible : "Toutes les Couleurs")
				if((String) FenetrePrincipal.this.comboBoxFiltreCouleur.getSelectedItem() != FenetrePrincipal.this.toutesCouleurs) 
					FenetrePrincipal.this.couleurActuelle = Couleur.getCouleur((String) FenetrePrincipal.this.comboBoxFiltreCouleur.getSelectedItem());
				//Appele la fonction pour actualiser la liste
				FenetrePrincipal.this.actualiserListTomates();
			}
		});
	}
	
	
	
	//Fonction qui actualise la Liste de tomate en fonction des comboBox
	private void actualiserListTomates() {
		//Vide la liste en mettant sa taille a 0
		this.modeleList.setSize(0);
		//Rempli la liste en fonction des comboBox
		if(this.comboBoxFiltreType.getSelectedItem() == this.toutesTomates) {
			//Si touts les types et toutes les couleurs sont choisis en tant que parametres
			if(this.comboBoxFiltreCouleur.getSelectedItem() == this.toutesCouleurs)
				for(Tomate tomate : this.tomates.getTomates()) {
					this.modeleList.add(this.modeleList.size(), tomate);
				}
			//Si touts les types est choisi en tant que parametre et que la couleur est choisi
			else {
				for(Tomate tomate : this.tomates.tomatesDeCouleur(couleurActuelle)) {
					this.modeleList.add(this.modeleList.size(), tomate);
				}
			}
		}
		else {
			//Si toutes les couleurs est choisi en tant que parametre et que le type est choisi
			if(this.comboBoxFiltreCouleur.getSelectedItem() == this.toutesCouleurs) {
				for(Tomate tomate : this.tomates.tomatesDeType(typeActuel)) {
					this.modeleList.add(this.modeleList.size(), tomate);
				}
			}
			//Si le type et la couleur sont choisis
			else {
				for(Tomate tomate : this.tomates.tomatesDetypeDeCouleur(typeActuel, couleurActuelle)) {
					this.modeleList.add(this.modeleList.size(), tomate);
				}
			}
		}
		//Si la liste est vide
		if(this.modeleList.getSize() == 0) {
			//à faire (popup)
		}
	}

}
