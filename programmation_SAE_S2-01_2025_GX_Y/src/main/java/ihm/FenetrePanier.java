package ihm;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modèle.Tomates;

public class FenetrePanier extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePanier;


	public FenetrePanier(Tomates tomates) {
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
		tablePanier = new JTable();
		tablePanier.setBorder(new EmptyBorder(10, 10, 10, 10));
		tablePanier.setFont(new Font("Ebrima", Font.BOLD, 25));
		tablePanier.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Image", "Produit", "Prix Unitaire", "Quantité", "Prix Total"
			}
		));
		scrollPane.setViewportView(tablePanier);
		
		
		
		
	}
		
}