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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class FenetreProduit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

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
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Ajouter au panier");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(SystemColor.activeCaption);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		panel.add(btnNewButton_1);
		
		JPanel Panneau_principal = new JPanel();
		contentPane.add(Panneau_principal, BorderLayout.CENTER);
		Panneau_principal.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel Mini_paneau_gauche = new JPanel();
		Panneau_principal.add(Mini_paneau_gauche);
		Mini_paneau_gauche.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Tomate X");
		Mini_paneau_gauche.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Tomates200x200\\ananas-2-scaled.jpg"));
		Mini_paneau_gauche.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("En Stock");
		Mini_paneau_gauche.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		Mini_paneau_gauche.add(comboBox);
		
		JPanel Mini_paneau_droite = new JPanel();
		Panneau_principal.add(Mini_paneau_droite);
		Mini_paneau_droite.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel Description = new JLabel("Description");
		Mini_paneau_droite.add(Description);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 20, 10, 10));
		Mini_paneau_droite.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 0, 194, 55);
		panel_2.add(textArea);
		
		JPanel panel_1 = new JPanel();
		Mini_paneau_droite.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel Micro_panel_prix = new JPanel();
		Mini_paneau_droite.add(Micro_panel_prix);
		Micro_panel_prix.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Prix = new JLabel("Prix :");
		Micro_panel_prix.add(Prix);
		
		textField_1 = new JTextField();
		Micro_panel_prix.add(textField_1);
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		Micro_panel_prix.add(spinner);
	}
}
