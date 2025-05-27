package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FenetrePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipal frame = new FenetrePrincipal();
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
	public FenetrePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Border Layout principal
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headpanel = new JPanel();
		contentPane.add(headpanel, BorderLayout.NORTH);
		headpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("O'Tomates");
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headpanel.add(lblTitle, BorderLayout.CENTER);
		
		JButton btnPanier = new JButton("0.00 €");
		btnPanier.setIcon(null);
		headpanel.add(btnPanier, BorderLayout.EAST);
		
		//
	}

}
