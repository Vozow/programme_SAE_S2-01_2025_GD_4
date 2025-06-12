package ihm;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modèle.Tomate;
import modèle.Tomates;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class FenetreFacture extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFacture;
	private Tomates tomates;
	private DecimalFormat df = new DecimalFormat("0.00");

	public FenetreFacture(String nom, String prenom, String adresse1, String codePostal, 
			String ville, String telephone, String mail, String moyenPaiement, Tomates tomates) {
		this.tomates = tomates;
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		setTitle("O'Tomates - Panier");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
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
		
		JLabel lblDescription = new JLabel("Merci de votre visite !");
		lblDescription.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblDescription, BorderLayout.SOUTH);
		
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
		lblAdresseClient.setBorder(new EmptyBorder(10, 10, 0, 10));
		panelFacture.add(lblAdresseClient);
		
		JLabel lblTelClient = new JLabel("Téléphone : " + telephone);
		lblTelClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblTelClient.setBorder(new EmptyBorder(10, 10, 0, 10));
		panelFacture.add(lblTelClient);
		
		JLabel lblMailClient = new JLabel("Mail : " + mail);
		lblMailClient.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 12));
		lblMailClient.setBorder(new EmptyBorder(10, 10, 20, 10));
		panelFacture.add(lblMailClient);
		
		//Tableau du panier
		JTable tablePanier = new JTable();
		tablePanier.setBorder(new LineBorder(Color.lightGray, 2));
		panelFacture.add(tablePanier);
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
		
		JLabel lblTotalCommande = new JLabel("TOTAL TTC COMMANDE : " + mail);
		lblMailClient.setFont(new Font("Ebrima", Font.PLAIN, 14));
		lblMailClient.setBorder(new EmptyBorder(30, 10, 15, 10));
		panelFacture.add(lblMailClient);
		
		
		//FIN FACTURE -------------------------------------------------------------------
		
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton, BorderLayout.SOUTH);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitterAppuyé(btnQuitter);
		panelBouton.add(btnQuitter);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimerAppuyé(btnImprimer);
		panelBouton.add(btnImprimer);
		

	}

	private void btnQuitterAppuyé(JButton btnQuitter) {
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreFacture.this.dispose();
				System.exit(0);
			}
		});
	}

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
