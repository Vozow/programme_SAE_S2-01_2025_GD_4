package ihm;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modèle.Tomates;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreConseil extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FenetreConseil() {
		//Parametre principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setModal(true);
		setTitle("O'Tomates - Conseil");
		setIconImage(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png").getImage());
		
		//Panel principal
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Label de titre
		JLabel lblTitle = new JLabel("Conseils de culture");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitle.setFont(new Font("Ebrima", Font.BOLD, 25));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		//Panel contenant les conseils
		JPanel panelConseilDate = new JPanel();
		panelConseilDate.setLayout(new BorderLayout(0,0));
		panelConseilDate.setBackground(Color.white);
		panelConseilDate.setBorder(new LineBorder(Color.lightGray, 2));
		contentPane.add(panelConseilDate);
		
		//TextArea possedant les conseils de culture
		JTextArea textAreaConseils = new JTextArea();
		textAreaConseils.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 16));
		textAreaConseils.setOpaque(false);
		textAreaConseils.setEditable(false);
		textAreaConseils.setText(Tomates.CONSEILS_DE_CULTURE_TITRE);
		textAreaConseils.setLineWrap(true);
		textAreaConseils.setWrapStyleWord(true);
		textAreaConseils.setOpaque(false);
		textAreaConseils.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelConseilDate.add(textAreaConseils, BorderLayout.NORTH);
		
		//Scroll pane pour le deuxieme textarea
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelConseilDate.add(scrollPane, BorderLayout.CENTER);
		
		//TextArea decrivant les conseils de culture
		JTextArea textAreaDescriptions = new JTextArea();
		textAreaDescriptions.setEditable(false);
		textAreaDescriptions.setFont(new Font("Ebrima", Font.PLAIN, 14));
		textAreaDescriptions.setText(Tomates.CONSEILS_DE_CULTURE);
		textAreaDescriptions.setLineWrap(true);
		textAreaDescriptions.setWrapStyleWord(true);
		textAreaDescriptions.setBackground(Color.white);
		textAreaDescriptions.setOpaque(true);
		textAreaDescriptions.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(textAreaDescriptions);
		
		//Panel du bas pour le bouton
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		//Bouton ok
		JButton btnOk = new JButton("Ok");
		//Quand le bouton ok est appuyé
		btnOkAppuyé(btnOk);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnOk);
		
	}

	//Fonction appelé lorsque le bouton Ok est appuyé
	private void btnOkAppuyé(JButton btnOk) {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreConseil.this.dispose();
			}
		});
	}

}
