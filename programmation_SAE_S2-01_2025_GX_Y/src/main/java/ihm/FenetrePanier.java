package ihm;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modèle.OutilsBaseDonneesTomates;
import modèle.Tomate;
import modèle.Tomates;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetrePanier extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private Tomates tomates;
	private Tomate tomateSelectionnée;
	private JPanel contentPane;
	private JTable tablePanier;
	private DefaultTableModel modeleTable;
	private JLabel lblNbTomateSelectionné;
	private DecimalFormat df = new DecimalFormat("0.00");
	private JLabel lblNomTomateSelectionné;
	private JLabel lblTotal;
	private JLabel lblSousTotal;
	

	//Préparation de la fenetre
	public FenetrePanier(Tomates tomates) {
		this.tomates = tomates;
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		setModal(true);
		setTitle("O'Tomates - Panier");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Scroll pane pour le tableau
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//Titre de la page
		JLabel lblTitlePanel = new JLabel("Votre Panier");
		contentPane.add(lblTitlePanel, BorderLayout.NORTH);
		lblTitlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 25));
		lblTitlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitlePanel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		
		//Tableau du panier
		this.tablePanier = new JTable();
		cliqueSouris();
		appuisClavier();
		this.tablePanier.setBorder(new LineBorder(Color.lightGray, 2));
		scrollPane.setViewportView(this.tablePanier);
		this.tablePanier.setOpaque(true);
		this.tablePanier.setBackground(Color.white);
		this.tablePanier.setDefaultEditor(Object.class, null);

		
		//Panel du dessous
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		contentPane.add(southPanel, BorderLayout.SOUTH);

		//Panel Principal en dessous du tableau
		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(new LineBorder(Color.lightGray, 2));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		southPanel.add(mainPanel, BorderLayout.SOUTH);
		
		//Panel de gestion du panier 
		JPanel gestionPanel = new JPanel();
		gestionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gestionPanel.setOpaque(false);
		mainPanel.add(gestionPanel);
		gestionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Bouton retirer
		JButton btnRetirer = new JButton();
		btnRetirerAppuyé(btnRetirer);
		btnRetirer.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\minus_resize3.png"));
		gestionPanel.add(btnRetirer);
		
		//Label nombre de tomate dans le panier
		this.lblNbTomateSelectionné = new JLabel("-");
		this.lblNbTomateSelectionné.setFont(new Font("Ebrima", Font.BOLD, 15));
		gestionPanel.add(this.lblNbTomateSelectionné);
		
		//Bouton ajouter
		JButton btnAjouter = new JButton();
		btnAjouterAppuyé(btnAjouter);
		btnAjouter.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\more_resize3.png"));
		gestionPanel.add(btnAjouter);
		
		
		//Label nombre de tomate dans le panier
		this.lblNomTomateSelectionné = new JLabel("Aucune ligne selectionnée");
		this.lblNomTomateSelectionné.setFont(new Font("Ebrima", Font.ITALIC, 14));
		this.lblNomTomateSelectionné.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.lblNomTomateSelectionné.setBorder(new EmptyBorder(0, 0, 10, 0));
		mainPanel.add(this.lblNomTomateSelectionné);
		
		//Bouton retirer
		JButton btnSupprimer = new JButton("Supprimer cette tomate");
		btnSupprimerAppuyé(btnSupprimer);
		btnSupprimer.setBackground(new Color(241, 148, 138));
		btnSupprimer.setOpaque(true);
		btnSupprimer.setFont(new Font("Ebrima", Font.BOLD, 15));
		btnSupprimer.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSupprimer.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\delete_resize2.png"));
		mainPanel.add(btnSupprimer);
		
		//Label du prix total
		this.lblTotal = new JLabel("Total : " + df.format(FenetrePrincipal.panier.getPrixTotal() + 5.5f) + "€");
		lblTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTotal.setBorder(new EmptyBorder(20, 10, 0, 10));
		lblTotal.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\coin_resize2.png"));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Ebrima", Font.BOLD, 20));
		mainPanel.add(lblTotal);
		
		//Panel d'information de calcul du prix
		JPanel prixPanel = new JPanel();
		prixPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		prixPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		prixPanel.setOpaque(false);
		mainPanel.add(prixPanel);
		
		//Création du label prix
		this.lblSousTotal = new JLabel("Sous-Total : " + df.format(FenetrePrincipal.panier.getPrixTotal()) + "€");
		lblSousTotal.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\buy_resize2.png"));
		lblSousTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSousTotal.setFont(new Font("Ebrima", Font.ITALIC, 14));
		lblSousTotal.setBorder(new EmptyBorder(0, 10, 10, 10));
		prixPanel.add(lblSousTotal);
		
		//Création du label contenant le nombre de graine
		JLabel lblFraisLivrarison = new JLabel("Frais de livraison : 5,50€");
		lblFraisLivrarison.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\truck_resize2.png"));
		lblFraisLivrarison.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraisLivrarison.setFont(new Font("Ebrima", Font.ITALIC, 14));
		lblFraisLivrarison.setBorder(new EmptyBorder(0, 10, 10, 10));
		prixPanel.add(lblFraisLivrarison);				
				

		//Panel d'information de calcul du prix
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPanel.setOpaque(false);
		southPanel.add(buttonPanel);
		
		//Bouton valider le panier
		JButton btnValider = new JButton("Valider le panier");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetrePanier.this.dispose();
				FenetrePanier.this.actualiserTableauPanier();
				FenetrePanier.this.actualiserTotal();
				FenetreCoordonnées fenCoord = new FenetreCoordonnées(FenetrePanier.this.tomates);
				fenCoord.setVisible(true);
			}
		});
		btnValider.setBackground(SystemColor.activeCaption);
		btnValider.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel.add(btnValider);
		
		//Bouton vider le panier
		JButton btnVider = new JButton("Vider le panier");
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Tomate tomate : FenetrePrincipal.panier.getTomatesPresentes(tomates)) {
					tomate.setStock(tomate.getStock() + FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomate));
				}
				FenetrePrincipal.panier.vider();
				FenetrePanier.this.tomateSelectionnée = null;
				FenetrePanier.this.lblNbTomateSelectionné.setText("-");
				FenetrePanier.this.lblNomTomateSelectionné.setText("Aucune ligne selectionnée"); 
				FenetrePanier.this.actualiserTableauPanier();
				FenetrePanier.this.actualiserTotal();
				FenetrePanier.this.dispose();
			}
		});
		btnVider.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnVider.setBackground(SystemColor.activeCaption);
		buttonPanel.add(btnVider);

		//Bouton annuler/continuer les achats
		JButton btnAnnuler = new JButton("Continuer les achats");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetrePanier.this.dispose();
			}
		});
		btnAnnuler.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnAnnuler.setBackground(SystemColor.activeCaption);
		buttonPanel.add(btnAnnuler);

		//Actualise le tableau panier
		this.actualiserTableauPanier();
		//Actualise le Prix sous-total et total
		this.actualiserTotal();
	}


	private void btnSupprimerAppuyé(JButton btnSupprimer) {
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FenetrePanier.this.tomateSelectionnée != null) {
					FenetrePanier.this.tomateSelectionnée.setStock(FenetrePanier.this.tomateSelectionnée.getStock() + 
							FenetrePrincipal.panier.getNbDeUnTypeDeTomate(FenetrePanier.this.tomateSelectionnée));
					FenetrePrincipal.panier.deleteTomate(tomateSelectionnée);
					FenetrePanier.this.actualiserTableauPanier();
					FenetrePanier.this.actualiserTotal();
					FenetrePanier.this.tomateSelectionnée = null;
					FenetrePanier.this.lblNbTomateSelectionné.setText("-");
					FenetrePanier.this.lblNomTomateSelectionné.setText("Aucune ligne selectionnée"); 
					OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(FenetrePanier.this.tomates, "./src/main/resources/data/tomates.json");
					if(FenetrePrincipal.panier.isEmpty()) FenetrePanier.this.dispose();
				}
			}
		});
	}


	private void btnRetirerAppuyé(JButton btnRetirer) {
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FenetrePanier.this.tomateSelectionnée != null) {
					FenetrePanier.this.tomateSelectionnée.setStock(FenetrePanier.this.tomateSelectionnée.getStock() + 1);
					if(FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomateSelectionnée) != 1) { 
						FenetrePrincipal.panier.removeTomate(tomateSelectionnée, 1);
						FenetrePanier.this.lblNbTomateSelectionné.setText(String.valueOf(FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomateSelectionnée)));
						FenetrePanier.this.actualiserTableauPanier();
						FenetrePanier.this.actualiserTotal();						
					}
					else {
						FenetrePrincipal.panier.deleteTomate(tomateSelectionnée);
						FenetrePanier.this.actualiserTableauPanier();
						FenetrePanier.this.tomateSelectionnée = null;
						FenetrePanier.this.lblNbTomateSelectionné.setText("-");
						FenetrePanier.this.lblNomTomateSelectionné.setText("Aucune ligne selectionnée"); 
						FenetrePanier.this.actualiserTotal();
						OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(FenetrePanier.this.tomates, "./src/main/resources/data/tomates.json");
						if(FenetrePrincipal.panier.isEmpty()) FenetrePanier.this.dispose();
					}
				}
			}
		});
	}

	//Lorsque le bouton Ajouter est appuyé
	private void btnAjouterAppuyé(JButton btnAjouter) {
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FenetrePanier.this.tomateSelectionnée != null) {
					if(FenetrePanier.this.tomateSelectionnée.getStock() != 0) {
						FenetrePanier.this.tomateSelectionnée.setStock(FenetrePanier.this.tomateSelectionnée.getStock() - 1);
						FenetrePrincipal.panier.addTomate(tomateSelectionnée, 1);
						FenetrePanier.this.lblNbTomateSelectionné.setText(String.valueOf(FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomateSelectionnée)));
						FenetrePanier.this.actualiserTableauPanier();
						FenetrePanier.this.actualiserTotal();	
						OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(FenetrePanier.this.tomates, "./src/main/resources/data/tomates.json");
					}
				}
			}
		});
	}

	//Actualise le total et soustotal du panier
	private void actualiserTotal() {
		this.lblTotal.setText("Total : " + df.format(FenetrePrincipal.panier.getPrixTotal() + 5.5f) + "€");
		this.lblSousTotal.setText("Sous-Total : " + df.format(FenetrePrincipal.panier.getPrixTotal()) + "€");
	}


	//Si un l'appuis d'une touche a été effectué
	private void appuisClavier() {
		tablePanier.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				FenetrePanier.this.verifierValeurTableau();
			}
		});
	}
	
	
	//Si un clique souris a été effectué
	private void cliqueSouris() {
		tablePanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetrePanier.this.verifierValeurTableau();
			}
		});
	}


	//Vérifie la tomate selectionné dans le tableau
	private void verifierValeurTableau() {
		String nomTomateSelectionné = (String) this.tablePanier.getValueAt(this.tablePanier.getSelectedRow(), 0);
		if(this.tomateSelectionnée == null) {
			for(Tomate tomate : FenetrePrincipal.panier.getTomatesPresentes(this.tomates)) {
				if(tomate.getDésignation() == nomTomateSelectionné) {
					this.tomateSelectionnée = tomate;
					this.lblNbTomateSelectionné.setText(String.valueOf(FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomate)));
					this.lblNomTomateSelectionné.setText("(" + this.tomateSelectionnée.getDésignation() + ")"); 
				}
			}
		}
		else if(this.tomateSelectionnée.getDésignation() != nomTomateSelectionné) {
			for(Tomate tomate : FenetrePrincipal.panier.getTomatesPresentes(this.tomates)) {
				if(tomate.getDésignation() == nomTomateSelectionné) {
					this.tomateSelectionnée = tomate;
					this.lblNbTomateSelectionné.setText(String.valueOf(FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomate)));
					this.lblNomTomateSelectionné.setText("(" + this.tomateSelectionnée.getDésignation() + ")"); 
				}
			}
		}
	}
	
	
	private void actualiserTableauPanier() {
		this.modeleTable = new DefaultTableModel();
		this.modeleTable.setColumnIdentifiers(new String[] {
					"Produit", "Prix Unitaire", "Quantité", "Prix Total"});
		for(Tomate tomate : FenetrePrincipal.panier.getTomatesPresentes(this.tomates)) {
			this.modeleTable.addRow(new Object[] {
					tomate.getDésignation(),
					df.format(tomate.getPrixTTC()) + "€",
					FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomate),
					df.format(FenetrePrincipal.panier.getPrixDeUnTypeDeTomate(tomate)) + "€"
			});
		}
		this.tablePanier.setModel(modeleTable);	
		this.tablePanier.getColumnModel().getColumn(0).setMinWidth(200);
	}
		
}