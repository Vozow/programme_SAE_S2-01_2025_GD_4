package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;

public class FenetreProduit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreProduit frame = new FenetreProduit();
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
	public FenetreProduit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Ajouter au panier");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		panel.add(btnNewButton_1);
		
		JPanel Panneau_principal = new JPanel();
		contentPane.add(Panneau_principal, BorderLayout.CENTER);
		Panneau_principal.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel Mini_paneau_gauche = new JPanel();
		Panneau_principal.add(Mini_paneau_gauche);
		Mini_paneau_gauche.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Mini_paneau_gauche.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		Mini_paneau_gauche.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		Mini_paneau_gauche.add(lblNewLabel_4);
		
		JPanel Mini_paneau_droite = new JPanel();
		Panneau_principal.add(Mini_paneau_droite);
		Mini_paneau_droite.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel Description = new JLabel("Description");
		Mini_paneau_droite.add(Description);
		
		textField = new JTextField();
		Mini_paneau_droite.add(textField);
		textField.setColumns(10);
		
		JSplitPane Micro_panel_nb_graines = new JSplitPane();
		Mini_paneau_droite.add(Micro_panel_nb_graines);
		
		JLabel Nb_graines_text = new JLabel("Nombre de graines : ");
		Micro_panel_nb_graines.setLeftComponent(Nb_graines_text);
		
		JPanel Micro_panel_prix = new JPanel();
		Mini_paneau_droite.add(Micro_panel_prix);
		Micro_panel_prix.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel Prix = new JLabel("Prix :");
		Micro_panel_prix.add(Prix);
		
		textField_1 = new JTextField();
		Micro_panel_prix.add(textField_1);
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		Micro_panel_prix.add(spinner);
	}

}
