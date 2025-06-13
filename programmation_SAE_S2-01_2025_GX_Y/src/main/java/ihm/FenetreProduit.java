package ihm;
import modèle.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreProduit extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel Pane;
	private JSpinner spinnerQteAchat;
	private JLabel lblPrixTotal;
	private Tomate tomate;
	private JComboBox<String> comboBoxTomateSuggerer;
	private DecimalFormat df = new DecimalFormat("0.00");

	//Préparation de la fenetre
	public FenetreProduit(Tomate tomate) {

		this.tomate = tomate; 
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		setModal(true);;
		setTitle("O'Tomates - " + tomate.getDésignation());
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		Pane = new JPanel();
		setContentPane(Pane);
		Pane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Pane.add(scrollPane, BorderLayout.CENTER);
		
		//Border Layout principal
		JPanel contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
		    public Dimension getPreferredSize() {
		    	return new Dimension(((JViewport) getParent()).getWidth(), super.getPreferredSize().height);
		    }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		//Création du titre de la tomate
		JLabel lblTitlePanel = new JLabel(tomate.getDésignation());
		lblTitlePanel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTitlePanel.setFont(new Font("Ebrima", Font.BOLD, 25));
		lblTitlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitlePanel, BorderLayout.NORTH);
		
		
		//Création du panel principal
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new LineBorder(Color.lightGray, 2));
		mainPanel.setBackground(Color.white);
		
		//Création du panel contenant l'image, le stock et les suggestion 
		JPanel infoPanel = new JPanel();
		mainPanel.add(infoPanel);
		infoPanel.setOpaque(false);
		infoPanel.setBorder(new LineBorder(new Color(100, 100, 120), 1));
		infoPanel.setLayout(new BorderLayout(0, 0));
		
		//Création de l'image de la tomate
		JLabel lblImageTomate = new JLabel();
		lblImageTomate.setVerticalAlignment(SwingConstants.CENTER);
		lblImageTomate.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Tomates200x200\\" + tomate.getNomImage() + ".jpg"));
		lblImageTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageTomate.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoPanel.add(lblImageTomate, BorderLayout.WEST);
		
		//Création de la description
		JTextArea TextAreaDescription = new JTextArea(tomate.getDescription());
		TextAreaDescription.setEditable(false);
		TextAreaDescription.setFont(new Font("Ebrima", Font.PLAIN, 20));
		TextAreaDescription.setBorder(new EmptyBorder(10, 20, 0, 0));
		TextAreaDescription.setLineWrap(true);
		TextAreaDescription.setWrapStyleWord(true);
		TextAreaDescription.setOpaque(false);
		infoPanel.add(TextAreaDescription, BorderLayout.CENTER);

		
		//Création du label stock
		JLabel lblStockTomate = new JLabel();
		lblStockTomate.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblStockTomate.setFont(new Font("Ebrima", Font.BOLD, 20));
		lblStockTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockTomate.setBorder(new EmptyBorder(20, 10, 10, 10));
		if(tomate.getStock() > 0) {
			lblStockTomate.setText("En Stock : " + String.valueOf(tomate.getStock()));
			lblStockTomate.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\stock_resize2.png"));
		}
		else {
			lblStockTomate.setText("Rupture de stock");
			lblStockTomate.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\out_of_stock_resize2.png"));
		}
		mainPanel.add(lblStockTomate);
		
		//Création de la comboBox suggerant les tomates
		this.comboBoxTomateSuggerer = new JComboBox<String>();
		this.comboBoxTomateSuggerer.addItem("Produit similaire");
		for(Tomate t : tomate.getTomatesApparentées()) {
			this.comboBoxTomateSuggerer.addItem(t.getDésignation());
		}
		this.comboBoxTomateSuggerer.setSelectedIndex(0);
		if(tomate.getStock() == 0) {
			mainPanel.add(this.comboBoxTomateSuggerer);
		}
		produitSimilaireChoisi(this.comboBoxTomateSuggerer);

			
		//Création du panelPrix contenant le prix total et le choix d'achat
		JPanel prixPanel = new JPanel();
		mainPanel.add(prixPanel);
		prixPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		prixPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		prixPanel.setOpaque(false);
		
		//Création le label prix total
		JLabel lblPrixTotal = new JLabel("Prix Total : ");
		lblPrixTotal.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\buy_resize2.png"));
		lblPrixTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixTotal.setFont(new Font("Ebrima", Font.PLAIN, 15));
		prixPanel.add(lblPrixTotal);
		
		//Création du champ de texte contenant le prix totale
		this.lblPrixTotal = new JLabel("-.--€");
		this.lblPrixTotal.setFont(new Font("Ebrima", Font.BOLD, 15));
		prixPanel.add(this.lblPrixTotal);
		
		//Création du spinner permettant de choisir la qte d'achat
		this.spinnerQteAchat = new JSpinner();
		changementValeurSpinner(this.spinnerQteAchat);
		this.spinnerQteAchat.setFont(new Font("Ebrima", Font.BOLD, 15));
		if(tomate.getStock() == 0){
			this.spinnerQteAchat.setEnabled(false);
		}
		else {
			this.spinnerQteAchat.setModel(new SpinnerNumberModel(1, 1, tomate.getStock(), 1));
		}
		prixPanel.add(this.spinnerQteAchat);
		
		//Panel contenant les information de prix unitaire et de nombre de graine
		JPanel specificationPanel = new JPanel();
		mainPanel.add(specificationPanel);
		specificationPanel.setOpaque(false);
		specificationPanel.setLayout(new FlowLayout());
		
		//Création du label prix
		JLabel lblPrix = new JLabel("Prix Unitaire : " + df.format(tomate.getPrixTTC()) + "€");
		lblPrix.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\coin_resize2.png"));
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setFont(new Font("Ebrima", Font.ITALIC, 14));
		lblPrix.setBorder(new EmptyBorder(0, 10, 10, 10));
		specificationPanel.add(lblPrix);
		
		//Création du label contenant le nombre de graine
		JLabel lblGraine = new JLabel("Nombre de graine : " + String.valueOf(tomate.getNbGrainesParSachet()));
		lblGraine.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\seed_resize2.png"));
		lblGraine.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraine.setFont(new Font("Ebrima", Font.ITALIC, 14));
		lblGraine.setBorder(new EmptyBorder(0, 10, 10, 10));
		specificationPanel.add(lblGraine);
		
		
		//Création du panel de bas avec les boutons
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout());
		
		//Création du bouton ajout au panier
		JButton btnAjout = new JButton("Ajouter au panier");
		boutonAchatAppuyé(btnAjout);
		btnAjout.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAjout.setForeground(new Color(0, 0, 0));
		btnAjout.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnAjout.setBackground(SystemColor.activeCaption);
		bottomPanel.add(btnAjout);
		
		//Création du bouton annuler
		JButton btnAnnuler = new JButton("Annuler");
		boutonAnnulerAppuyé(btnAnnuler);
		btnAnnuler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAnnuler.setBackground(SystemColor.activeCaption);
		btnAnnuler.setBorder(new EmptyBorder(10, 10, 10, 10));
		bottomPanel.add(btnAnnuler);
		
		//Appel fonction qui actualise le prix
		this.actualiserPrix();
	}


	//Des que la comboBox change de valeur
	private void produitSimilaireChoisi(JComboBox<String> comboBoxTomateSuggerer) {
		comboBoxTomateSuggerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Tomate t : tomate.getTomatesApparentées()) {
					if(t.getDésignation().equals((String) FenetreProduit.this.comboBoxTomateSuggerer.getSelectedItem())) {
						FenetreProduit fenProduit = new FenetreProduit(t);
						fenProduit.setVisible(true);
					}
				}
			}
		});
	}


	//Des que le bouton achat est Appuyé
	private void boutonAchatAppuyé(JButton btnAjout) {
		btnAjout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreProduit.this.tomate.setStock(tomate.getStock()-(int) FenetreProduit.this.spinnerQteAchat.getValue());
				FenetrePrincipal.panier.addTomate(FenetreProduit.this.tomate, (int) FenetreProduit.this.spinnerQteAchat.getValue());
				FenetreProduit.this.dispose();
			}
		});
	}

	
	//Des que le bouton annuler et actionner
	private void boutonAnnulerAppuyé(JButton btnAnnuler) {
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreProduit.this.dispose();
			}
		});
	}

	
	//Dès que la valeur du spinner change
	private void changementValeurSpinner(JSpinner spinnerQteAchat) {
		spinnerQteAchat.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				FenetreProduit.this.actualiserPrix();
			}
		});
	}

	//Actualise le prix totale
	private void actualiserPrix() {
		this.lblPrixTotal.setText(df.format((int) this.spinnerQteAchat.getValue() * tomate.getPrixTTC()) + "€");
	}

}
