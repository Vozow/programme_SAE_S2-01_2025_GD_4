package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Fenetre_Coordonnées extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Coordonnées frame = new Fenetre_Coordonnées();
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
	public Fenetre_Coordonnées() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(12, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Nom_label = new JLabel("Nom :");
		panel_2.add(Nom_label);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel Prénom = new JLabel("Prénom :");
		panel_3.add(Prénom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel Adresse1 = new JLabel("Adresse 1 :");
		panel_4.add(Adresse1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_4.add(textField_2);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel Adresse2 = new JLabel("Adresse 2");
		panel_5.add(Adresse2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_5.add(textField_3);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel Code_postal = new JLabel("Code postal");
		panel_6.add(Code_postal);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_6.add(textField_4);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel i = new JLabel("Ville");
		panel_7.add(i);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_7.add(textField_5);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel Téléphone = new JLabel("Téléphone");
		panel_8.add(Téléphone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_8.add(textField_6);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JLabel Mail = new JLabel("Mail");
		panel_9.add(Mail);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_9.add(textField_7);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_10.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_10.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		panel_10.add(rdbtnNewRadioButton_2);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		panel_11.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		panel_11.add(rdbtnNewRadioButton_4);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JButton btnNewButton = new JButton("New button");
		panel_12.add(btnNewButton);
		
		JButton Annuler = new JButton("Annuler");
		panel_12.add(Annuler);
	}

}
