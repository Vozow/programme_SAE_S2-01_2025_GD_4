package ihm;

import java.awt.EventQueue;
import modèle.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FenetreProduit extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Tomate tomate;
	
	private JPanel contentPane;
	private JTextField textFieldNbGraine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreProduit(Tomate tomate) {
		this.tomate = tomate;
		
		//Parametre princiapl
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		
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
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 20));
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
		TextAreaDescription.setFont(new Font("Ebrima", Font.PLAIN, 15));
		TextAreaDescription.setBorder(new EmptyBorder(10, 20, 0, 0));
		TextAreaDescription.setLineWrap(true);
		TextAreaDescription.setWrapStyleWord(true);
		TextAreaDescription.setOpaque(false);
		infoPanel.add(TextAreaDescription, BorderLayout.CENTER);
		
		//Création du panel d'achat
		JPanel buyPanel = new JPanel();
		infoPanel.add(buyPanel, BorderLayout.SOUTH);
		
		//Création du panel gauche contenant le stock et les suggestion
		JPanel leftPanel = new JPanel();
		buyPanel.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		//Création du label stock
		JLabel lblStockTomate = new JLabel("En Stock : " + String.valueOf(tomate.getStock()));
		lblStockTomate.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblStockTomate, BorderLayout.CENTER);
		
		//Création de la comboBox suggerant les tomates
		JComboBox<Tomate> comboBoxTomateSuggerer = new JComboBox<Tomate>();
		comboBoxTomateSuggerer.setEnabled(false);
		leftPanel.add(comboBoxTomateSuggerer, BorderLayout.SOUTH);
		
		
		//Création du panel droit contenant la description, le nombre de graine, le prix et l'achat
		JPanel rightPanel = new JPanel();
		buyPanel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(4, 1, 0, 0));
		

		
		//Création du label contenant le nombre de graine
		JLabel lblGraine = new JLabel("Nombre de graine : " + String.valueOf(tomate.getNbGrainesParSachet()));
		lblGraine.setFont(new Font("Ebrima", Font.PLAIN, 10));
		rightPanel.add(lblGraine);
		
		//Création du label prix
		JLabel lblPrix = new JLabel("Prix Unitaire : " + tomate.getPrixTTC());
		lblPrix.setFont(new Font("Ebrima", Font.PLAIN, 10));
		rightPanel.add(lblPrix);
		
		
		//Création du panelPrix contenant le prix et le choix d'achat
		JPanel prixPanel = new JPanel();
		rightPanel.add(prixPanel);
		prixPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		//Création le label prix total
		JLabel lblPrixTotal = new JLabel("Prix Total : ");
		lblPrixTotal.setFont(new Font("Ebrima", Font.PLAIN, 10));
		prixPanel.add(lblPrixTotal);
		
		//Création du champ de texte contenant le prix totale
		JTextArea TextAreaPrixTotal = new JTextArea("-.--€");
		TextAreaPrixTotal.setEditable(false);
		TextAreaPrixTotal.setFont(new Font("Ebrima", Font.PLAIN, 10));
		prixPanel.add(TextAreaPrixTotal);
		
		//Création du panel de bas avec les boutons
		JPanel bottomPanel = new JPanel();
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
		bottomPanel.add(btnNewButton_1);
		
	}
}
