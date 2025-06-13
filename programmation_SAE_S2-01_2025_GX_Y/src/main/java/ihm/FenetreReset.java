package ihm;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modèle.OutilsBaseDonneesTomates;
import modèle.Tomates;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FenetreReset extends JDialog {
	
	//POUR LANCER L'APPLICATION, SE RENDRE DANS LancementApplication
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public FenetreReset() {
		
		//FENETRE POPUP AU DEMARRAGE DE L'APPLICATION POUR DEMANDER
		//SI ON VEUX REINITIALISER LA BASE DE DONNEES
		
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setModal(true);
		setTitle("O'Tomates - Panier");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Label indiquant la requete
		JLabel lblTxt = new JLabel("Voulez-vous reinitialiser la base de données ?");
		lblTxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxt.setFont(new Font("Ebrima", Font.BOLD, 12));
		lblTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblTxt);
		
		//Panel des boutons
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton);
		
		//bouton non
		JButton btnNon = new JButton("Non");
		btnNonAppuyé(btnNon);
		btnNon.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelBouton.add(btnNon);
		
		//bouton oui
		JButton btnOui = new JButton("Oui");
		btnOuiAppuyé(btnOui);
		btnOui.setFont(new Font("Ebrima", Font.BOLD, 15));
		panelBouton.add(btnOui);
		

	}

	//Lorsque le bouton Oui est appuyé
	private void btnOuiAppuyé(JButton btnOui) {
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("./src/main/resources/data/tomatesSauvegarde.json");
				OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(tomates, "./src/main/resources/data/tomates.json");
				FenetreReset.this.dispose();
			}
		});
	}

	//Lorsque le bouton Non est appuyé
	private void btnNonAppuyé(JButton btnNon) {
		btnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreReset.this.dispose();
			}
		});
	}
}
