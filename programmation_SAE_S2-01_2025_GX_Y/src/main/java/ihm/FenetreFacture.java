package ihm;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modèle.Tomate;
import modèle.Tomates;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class FenetreFacture extends JDialog {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFacture;
	private Tomates tomates;
	private DecimalFormat df = new DecimalFormat("0.00");

	
	//Préparation de la fenetre
	public FenetreFacture(String nom, String prenom, String adresse1, String codePostal, 
			String ville, String telephone, String mail, String moyenPaiement, Tomates tomates) {
		//Quand la fenetre est fermé
		fenetreFermé();
		
		this.tomates = tomates;
		//Parametre principal
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setTitle("O'Tomates - Panier");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Panel pour le titre et la description
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		//Titre de la page
		JLabel lblTitlePanel = new JLabel("O'Tomates - Facture");
		panelTitle.add(lblTitlePanel, BorderLayout.NORTH);
		lblTitlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 25));
		lblTitlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitlePanel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		
		//Description
		JLabel lblDescription = new JLabel("Merci de votre visite !");
		lblDescription.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblDescription, BorderLayout.SOUTH);
		
		//ScrollPane pour la page qui sera imprimé
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//TOUS CE QUE CONTIENT LA FACTURE ------------------------------------------------
		panelFacture = new JPanel();
		panelFacture.setBackground(Color.white);
		scrollPane.setViewportView(panelFacture);
		panelFacture.setLayout(new BoxLayout(panelFacture, BoxLayout.PAGE_AXIS));
		
		JLabel lblTitreCommande = new JLabel("Ô'Tomates, redécouvrez le goût des tomates anciennes !");
		lblTitreCommande.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblTitreCommande.setForeground(new Color(0, 128, 0));
		lblTitreCommande.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelFacture.add(lblTitreCommande);
		
		LocalDateTime date = LocalDateTime.now();
		JLabel lblDateCommande = new JLabel("Commande du " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + " le " + date.getHour() + ":" + date.getMinute());
		lblDateCommande.setFont(new Font("Ebrima", Font.ITALIC, 14));
		lblDateCommande.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFacture.add(lblDateCommande);
		
		JLabel lblNomPrenomClient = new JLabel(prenom + " " + nom);
		lblNomPrenomClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblNomPrenomClient.setBorder(new EmptyBorder(10, 10, 0, 10));
		panelFacture.add(lblNomPrenomClient);
		
		JLabel lblAdresseClient = new JLabel("Adresse : " + adresse1 + " " + codePostal + " " + ville);
		lblAdresseClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblAdresseClient.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFacture.add(lblAdresseClient);
		
		JLabel lblTelClient = new JLabel("Téléphone : " + telephone);
		lblTelClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblTelClient.setBorder(new EmptyBorder(10, 10, 0, 10));
		panelFacture.add(lblTelClient);
		
		JLabel lblMailClient = new JLabel("Mail : " + mail);
		lblMailClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblMailClient.setBorder(new EmptyBorder(10, 10, 20, 10));
		panelFacture.add(lblMailClient);

		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelFacture.add(scrollPaneTable);
		scrollPaneTable.setMaximumSize(new Dimension(600, scrollPaneTable.getMaximumSize().height));
		scrollPaneTable.setMinimumSize(new Dimension(600, scrollPaneTable.getMinimumSize().height));
		
		//Tableau du panier
		JTable tablePanier = new JTable();
		//Modele du tableau (contenu)
		DefaultTableModel modeleTable = new DefaultTableModel();
		modeleTable.setColumnIdentifiers(new String[] {
					"Produit", "Prix Unitaire", "Quantité", "Prix Total"});
		for(Tomate tomate : FenetrePrincipal.panier.getTomatesPresentes(this.tomates)) {
			modeleTable.addRow(new Object[] {
					tomate.getDésignation(),
					df.format(tomate.getPrixTTC()) + "€",
					FenetrePrincipal.panier.getNbDeUnTypeDeTomate(tomate),
					df.format(FenetrePrincipal.panier.getPrixDeUnTypeDeTomate(tomate)) + "€"
			});
		}
		tablePanier.setModel(modeleTable);
		tablePanier.getColumnModel().getColumn(0).setMinWidth(200);
		scrollPaneTable.setViewportView(tablePanier);	
		
		JLabel lblTotalCommande = new JLabel("TOTAL TTC COMMANDE : " + df.format(FenetrePrincipal.panier.getPrixTotal()) + "€");
		lblTotalCommande.setFont(new Font("Ebrima", Font.PLAIN, 14));
		lblTotalCommande.setBorder(new EmptyBorder(30, 10, 15, 10));
		panelFacture.add(lblTotalCommande);
		
		JLabel lblFraisDePort = new JLabel("FORFAIT FRAIS DE PORT : " + df.format(5.5f) + "€");
		lblFraisDePort.setFont(new Font("Ebrima", Font.PLAIN, 14));
		lblFraisDePort.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFacture.add(lblFraisDePort);
		
		JLabel lblTotalTTC = new JLabel("PRIX TOTAL TTC : " + df.format(FenetrePrincipal.panier.getPrixTotal()+5.5f) + "€ payé par " + moyenPaiement);
		lblTotalTTC.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblTotalTTC.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFacture.add(lblTotalTTC);
		
		//FIN FACTURE -------------------------------------------------------------------
		
		//Panel qui contient les boutons du bas
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton, BorderLayout.SOUTH);
		
		//Bouton quitter qui fermera l'application
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(SystemColor.activeCaption);
		btnQuitterAppuyé(btnQuitter);
		panelBouton.add(btnQuitter);
		
		//Bouton Imprimer qui permet d'imprimer la feuille
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimerAppuyé(btnImprimer);
		btnImprimer.setBackground(SystemColor.activeCaption);
		panelBouton.add(btnImprimer);
		

	}

	//Quand la fenetre est fermé
	private void fenetreFermé() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FenetreFacture.this.dispose();
				System.exit(0);
			}
		});
	}
	
	
	//Lorsque le bouton Quitter est appuyé
	private void btnQuitterAppuyé(JButton btnQuitter) {
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreFacture.this.dispose();
				System.exit(0);
			}
		});
	}

	//Lorsque le bouton Imprimer est appuyé
	private void btnImprimerAppuyé(JButton btnImprimer) {
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob printer = PrinterJob.getPrinterJob();
				printer.setJobName("Facture O'Tomates");
				printer.setPrintable(new Printable() {
					@Override
					 public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
						    if (page > 0) {
						         return NO_SUCH_PAGE;
						    }
						    Graphics2D g2d = (Graphics2D)g;
						    g2d.translate(pf.getImageableX(), pf.getImageableY());
						    FenetreFacture.this.panelFacture.print(g2d);
						    return PAGE_EXISTS;
						  }
				});
				boolean returningResult = printer.printDialog();
				if(returningResult) {
					try {
						printer.print();
					} catch (PrinterException printerException) {
						System.out.println("Erreur Imprimante : " + printerException.getMessage());
					}
				}
			}
		});
	}
	
		
}
