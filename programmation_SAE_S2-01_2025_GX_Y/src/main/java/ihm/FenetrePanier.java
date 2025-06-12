package ihm;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modèle.Couleur;
import modèle.Tomate;
import modèle.Tomates;
import modèle.TypeTomate;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class FenetrePanier extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePanier frame = new FenetrePanier();
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
	public FenetrePanier() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Votre Panier");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "Produit", "Prix Unitaire", "Quantit\u00E9", "Prix Total"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		getContentPane().add(table, BorderLayout.SOUTH);
	}
		
}