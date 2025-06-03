package ihm;

import modèle.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FenetreProduit extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Tomate tomate;
	
	private JPanel contentPane;
	private JTextField textFieldNbGraine;


	public FenetreProduit(Tomate tomate) {
		this.tomate = tomate;
		
		//Parametre princiapl
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setModal(true);;
		setTitle("O'Tomates - " + tomate.getDésignation());
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Border Layout principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		//Création du panel de titre
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		//Création du titre de la tomate
		JLabel lblTitlePanel = new JLabel(tomate.getDésignation());
		lblTitlePanel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 25));
		lblTitlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblTitlePanel, BorderLayout.CENTER);
		
		
		//Création du panel d'information principal
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(new BorderLayout(0, 0));
		
		//Création de l'image de la tomate
		JLabel lblImageTomate = new JLabel();
		lblImageTomate.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Tomates200x200\\" + tomate.getNomImage() + ".jpg"));
		lblImageTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageTomate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		infoPanel.add(lblImageTomate, BorderLayout.WEST);
		
		//Création de la description
		JTextArea TextAreaDescription = new JTextArea(tomate.getDescription());
		TextAreaDescription.setEditable(false);
		TextAreaDescription.setFont(new Font("Ebrima", Font.PLAIN, 20));
		TextAreaDescription.setBorder(new EmptyBorder(10, 20, 0, 0));
		TextAreaDescription.setLineWrap(true);
		TextAreaDescription.setWrapStyleWord(true);
		TextAreaDescription.setOpaque(false);
		TextAreaDescription.setBorder(new EmptyBorder(10, 20, 0, 0));
		infoPanel.add(TextAreaDescription, BorderLayout.CENTER);
		
		//Création du panel d'achat
		JPanel buyPanel = new JPanel();
		contentPane.add(buyPanel, BorderLayout.SOUTH);
		buyPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		buyPanel.setLayout(new BorderLayout(0, 0));
		
		//Création du label stock
		JLabel lblStockTomate = new JLabel("En Stock : " + String.valueOf(tomate.getStock()));
		lblStockTomate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStockTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockTomate.setBorder(new LineBorder(Color.gray, 1));
		buyPanel.add(lblStockTomate, BorderLayout.NORTH);

		
		//Création du panel gauche contenant le stock et les suggestion
		JPanel leftPanel = new JPanel();
		buyPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		//Création de la comboBox suggerant les tomates
		JComboBox<Tomate> comboBoxTomateSuggerer = new JComboBox<Tomate>();
		comboBoxTomateSuggerer.setEnabled(false);
		leftPanel.add(comboBoxTomateSuggerer, BorderLayout.SOUTH);
		
		
		//Création du panel droit contenant la description, le nombre de graine, le prix et l'achat
		JPanel rightPanel = new JPanel();
		buyPanel.add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new GridLayout(3, 1, 0, 0));
		

		
		//Création du label contenant le nombre de graine
		JLabel lblGraine = new JLabel("Nombre de graine : " + String.valueOf(tomate.getNbGrainesParSachet()));
		lblGraine.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraine.setFont(new Font("Ebrima", Font.BOLD, 15));
		lblGraine.setBorder(new EmptyBorder(10, 10, 10, 10));
		rightPanel.add(lblGraine);
		
		//Création du label prix
		JLabel lblPrix = new JLabel("Prix Unitaire : " + tomate.getPrixTTC());
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setFont(new Font("Ebrima", Font.BOLD, 15));
		lblPrix.setBorder(new EmptyBorder(10, 10, 10, 10));
		rightPanel.add(lblPrix);
		
		
		//Création du panelPrix contenant le prix et le choix d'achat
		JPanel prixPanel = new JPanel();
		rightPanel.add(prixPanel);
		prixPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		prixPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		//Création le label prix total
		JLabel lblPrixTotal = new JLabel("Prix Total : ");
		lblPrixTotal.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblPrixTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixTotal.setFont(new Font("Ebrima", Font.PLAIN, 14));
		prixPanel.add(lblPrixTotal);
		
		//Création du champ de texte contenant le prix totale
		JTextArea TextAreaPrixTotal = new JTextArea("-.--€");
		TextAreaPrixTotal.setBorder(new EmptyBorder(10, 10, 10, 10));
		TextAreaPrixTotal.setEditable(false);
		TextAreaPrixTotal.setFont(new Font("Ebrima", Font.PLAIN, 14));
		prixPanel.add(TextAreaPrixTotal);
		
		JSpinner spinner = new JSpinner();
		prixPanel.add(spinner);
		
		//Création du panel de bas avec les boutons
		/*JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Création du bouton ajout au panier
		JButton btnNewButton = new JButton("Ajouter au panier");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(SystemColor.activeCaption);
		bottomPanel.add(btnNewButton);
		
		//Création du bouton annuler
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		bottomPanel.add(btnNewButton_1);*/
		
	}
}
