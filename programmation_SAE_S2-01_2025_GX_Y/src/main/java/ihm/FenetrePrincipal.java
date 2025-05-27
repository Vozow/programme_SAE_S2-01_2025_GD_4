package ihm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;

import javax.swing.JList;
import modèle.*;

public class FenetrePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Tomates tomates;
	
	private JPanel contentPane;
	private DefaultListModel<Tomate> modeleList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Initialisation de la 
					Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomates.json");
					//Lancement de la fenetre
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
		
		//Création du titre
		JLabel lblTitle = new JLabel("O'Tomates");
		lblTitle.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitle.setFont(new Font("Ebrima", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headpanel.add(lblTitle, BorderLayout.CENTER);
		
		//Création du bouton Panier
		JButton btnPanier = new JButton("-.-- €");
		btnPanier.setFont(new Font("Ebrima", Font.BOLD, 15));
		btnPanier.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\buy_resize2.png"));
		headpanel.add(btnPanier, BorderLayout.EAST);
		

		
		JScrollPane ListScrollPane = new JScrollPane();
		contentPane.add(ListScrollPane, BorderLayout.CENTER);
		

		//Création du modèle de la liste listTomates
		this.modeleList = new DefaultListModel<Tomate>();
		//Création de la listTomates
		JList<Tomate> listTomates = new JList<Tomate>(this.modeleList);
		listTomates.setFont(new Font("Ebrima", Font.PLAIN, 15));
		ListScrollPane.setViewportView(listTomates);
		listTomates.setModel(this.modeleList);
		listTomates.setCellRenderer(new TomatesListPainter());
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		
		//Actualisation du bouton panier
		
		
		//Actualisation de la table tableTomates
		this.actualiserListTomates();
	}




	private void actualiserListTomates() {
		this.modeleList.setSize(0);
		for(Tomate tomate : this.tomates.getTomates()) {
			this.modeleList.add(this.modeleList.size(), tomate);
		}
	}

}
