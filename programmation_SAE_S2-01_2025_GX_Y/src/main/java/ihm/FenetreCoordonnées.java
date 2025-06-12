package ihm;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class FenetreCoordonnées extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdress1;
	private JTextField textFieldAdresse2;
	private JTextField textFieldCP;
	private JTextField textFieldVille;
	private JTextField textFieldTel;
	private JTextField textFieldMail;
	private JRadioButton rdbtnPayementCarteCredit;
	private JRadioButton rdbtnPayementPaypal;
	private JRadioButton rdbtnPayementCheque;
	private JRadioButton rdbtnNewsletterOui;
	private JRadioButton rdbtnNewsletterNon;

	
	public FenetreCoordonnées() {
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		setModal(true);;
		setTitle("O'Tomates - Panier");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Scroll panel
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//panel princiapl
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(panelPrincipal);
		
		//Titre de la page
		JLabel lblTitlePanel = new JLabel("Vos Coordonnées");
		panelPrincipal.add(lblTitlePanel, BorderLayout.NORTH);
		lblTitlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 25));
		lblTitlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitlePanel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		

		
		//Panel principal
		JPanel mainPanel = new JPanel();
		panelPrincipal.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(new LineBorder(Color.lightGray, 2));

		//NOM
		JPanel panelNom = new JPanel();
		panelNom.setOpaque(false);
		mainPanel.add(panelNom);
		panelNom.setLayout(new GridLayout(0, 1, 0, 0));
		panelNom.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelNom.add(lblNom);
		
		textFieldNom = new JTextField();
		panelNom.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		
		//PRENOM
		JPanel panelPrenom = new JPanel();
		panelPrenom.setOpaque(false);
		mainPanel.add(panelPrenom);
		panelPrenom.setLayout(new GridLayout(0, 1, 0, 0));
		panelPrenom.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblPrenom = new JLabel("Prénom : ");
		lblPrenom.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelPrenom.add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		panelPrenom.add(textFieldPrenom);
		
		
		//ADRESSE 1
		JPanel panelAdresse1 = new JPanel();
		panelAdresse1.setOpaque(false);
		mainPanel.add(panelAdresse1);
		panelAdresse1.setLayout(new GridLayout(0, 1, 0, 0));
		panelAdresse1.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblAdresse1 = new JLabel("Adresse 1 : ");
		lblAdresse1.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelAdresse1.add(lblAdresse1);
		
		textFieldAdress1 = new JTextField();
		textFieldAdress1.setColumns(10);
		panelAdresse1.add(textFieldAdress1);
		
		
		//ADRESSE2
		JPanel panelAdresse2 = new JPanel();
		panelAdresse2.setOpaque(false);
		mainPanel.add(panelAdresse2);
		panelAdresse2.setLayout(new GridLayout(0, 1, 0, 0));
		panelAdresse2.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblAdresse2 = new JLabel("Adresse 2 : ");
		lblAdresse2.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelAdresse2.add(lblAdresse2);
		
		textFieldAdresse2 = new JTextField();
		textFieldAdresse2.setColumns(10);
		panelAdresse2.add(textFieldAdresse2);
		
		
		//CODE POSTAL
		JPanel panelCP = new JPanel();
		panelCP.setOpaque(false);
		mainPanel.add(panelCP);
		panelCP.setLayout(new GridLayout(0, 1, 0, 0));
		panelCP.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblCP = new JLabel("Code postal : ");
		lblCP.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelCP.add(lblCP);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		panelCP.add(textFieldCP);
		
		
		//VILLE
		JPanel panelVille = new JPanel();
		panelVille.setOpaque(false);
		mainPanel.add(panelVille);
		panelVille.setLayout(new GridLayout(0, 1, 0, 0));
		panelVille.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelVille.add(lblVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		panelVille.add(textFieldVille);
		
		
		//TELEPHONE
		JPanel panelTel = new JPanel();
		panelTel.setOpaque(false);
		mainPanel.add(panelTel);
		panelTel.setLayout(new GridLayout(0, 1, 0, 0));
		panelTel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblTel = new JLabel("Téléphone : ");
		lblTel.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelTel.add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		panelTel.add(textFieldTel);
		
		
		//MAIL
		JPanel panelMail = new JPanel();
		panelMail.setOpaque(false);
		mainPanel.add(panelMail);
		panelMail.setLayout(new GridLayout(0, 1, 0, 0));
		panelMail.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblMail = new JLabel("Mail : ");
		lblMail.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelMail.add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		panelMail.add(textFieldMail);
		
		
		//PAYEMENT
		JPanel panelPayement = new JPanel();
		Border borderPayement = BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 1), 
				"Moyen de Paiement", 0, 0, new Font("Ebrima", Font.BOLD, 15));
		panelPayement.setBorder(borderPayement);
		panelPayement.setOpaque(false);
		mainPanel.add(panelPayement);
		
		
		rdbtnPayementCarteCredit = new JRadioButton("Carte de Crédit");
		rdbtnPayementCarteCredit.setFont(new Font("Ebrima", Font.BOLD, 15));
		rdbtnPayementCarteCredit.setOpaque(false);
		rdbtnPayementCarteCredit.setSelected(true);
		panelPayement.add(rdbtnPayementCarteCredit);
		
		rdbtnPayementPaypal = new JRadioButton("Paypal");
		rdbtnPayementPaypal.setFont(new Font("Ebrima", Font.BOLD, 15));
		rdbtnPayementPaypal.setOpaque(false);
		panelPayement.add(rdbtnPayementPaypal);
		
		rdbtnPayementCheque = new JRadioButton("Chèque");
		rdbtnPayementCheque.setFont(new Font("Ebrima", Font.BOLD, 15));
		rdbtnPayementCheque.setOpaque(false);
		panelPayement.add(rdbtnPayementCheque);
		
		ButtonGroup buttonGroupPayement = new ButtonGroup();
		buttonGroupPayement.add(rdbtnPayementCarteCredit);
		buttonGroupPayement.add(rdbtnPayementPaypal);
		buttonGroupPayement.add(rdbtnPayementCheque);
		
		
		//NEWSLETTER
		JPanel panelNewsletter = new JPanel();
		Border borderNewsletter = BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 1), 
				"Abonnement à notre Newsletter", 0, 0, new Font("Ebrima", Font.BOLD, 15));
		panelNewsletter.setBorder(borderNewsletter);
		panelNewsletter.setOpaque(false);
		mainPanel.add(panelNewsletter);
		
		rdbtnNewsletterOui = new JRadioButton("Oui");
		rdbtnNewsletterOui.setFont(new Font("Ebrima", Font.BOLD, 15));
		rdbtnNewsletterOui.setOpaque(false);
		rdbtnNewsletterOui.setSelected(true);
		panelNewsletter.add(rdbtnNewsletterOui);
		
		rdbtnNewsletterNon = new JRadioButton("Non");
		rdbtnNewsletterNon.setFont(new Font("Ebrima", Font.BOLD, 15));
		rdbtnNewsletterNon.setOpaque(false);
		panelNewsletter.add(rdbtnNewsletterNon);
		
		ButtonGroup buttonGroupNewsletter = new ButtonGroup();
		buttonGroupNewsletter.add(rdbtnNewsletterOui);
		buttonGroupNewsletter.add(rdbtnNewsletterNon);
		
		
		//Panel du bas avec les boutons
		JPanel panelBouton = new JPanel();
		panelPrincipal.add(panelBouton, BorderLayout.SOUTH);
		
		JButton btnValider = new JButton("New button");
		panelBouton.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		panelBouton.add(btnAnnuler);
	}

}
