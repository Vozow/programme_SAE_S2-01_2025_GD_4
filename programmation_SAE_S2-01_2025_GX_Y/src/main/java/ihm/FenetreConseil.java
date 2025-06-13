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
		
		JLabel lblTitle = new JLabel("Conseils de culture");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Icones\\tomates_resize1.png"));
		lblTitle.setFont(new Font("Ebrima", Font.BOLD, 25));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel panelConseilDate = new JPanel();
		panelConseilDate.setLayout(new BorderLayout(0,0));
		panelConseilDate.setBackground(Color.white);
		panelConseilDate.setBorder(new LineBorder(Color.lightGray, 2));
		contentPane.add(panelConseilDate);
		
		JTextArea textAreaConseils = new JTextArea();
		textAreaConseils.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 16));
		textAreaConseils.setOpaque(false);
		textAreaConseils.setEditable(false);
		textAreaConseils.setText("Conseil de culture \n\n\r" +
									"Semis : mars-avril \n\n\r" +
									"Repiquage : après les gelées \n\n\r" +
									"Récolte : juillet à septembre, voire octobre");
		textAreaConseils.setLineWrap(true);
		textAreaConseils.setWrapStyleWord(true);
		textAreaConseils.setOpaque(false);
		textAreaConseils.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelConseilDate.add(textAreaConseils, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelConseilDate.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textAreaDescriptions = new JTextArea();
		textAreaDescriptions.setEditable(false);
		textAreaDescriptions.setFont(new Font("Ebrima", Font.PLAIN, 14));
		textAreaDescriptions.setText("Semis : Démarrez vos semis en petite terrine dès mars / avril (15°/20°)dans du terreau à semis,couvrez vos graines 0.5cm,tassez doucement et maintenez humide.Repqiuez vos semis lorsqu'ils font 5 cm, dans des godets avec du terreau 1/3 de fumier ou du compost, enterrez jusqu'au première feuilles.\n\n\r"
				+ "Après les Saints de glace, plantez vos pieds de tomates dès qu'ils auront atteint 15 cm, enterrez-les jusqu'aux premières feuilles en pleine terre dans un trou avec du fumier, du compost ou quelques feuilles d'ortie si besoin, installez vos tuteurs espacés de 70cm.Arrosez abondamment les 3 premiers jours , arrêtez les 15 jours suivants puis arrosez régulièrement.\n\n\r"
				+ "Pensez à pailler ! ainsi vous garderez beaucoup plus facilement l'humidité.\"");
		textAreaDescriptions.setLineWrap(true);
		textAreaDescriptions.setWrapStyleWord(true);
		textAreaDescriptions.setBackground(Color.white);
		textAreaDescriptions.setOpaque(true);
		textAreaDescriptions.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(textAreaDescriptions);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOkAppuyé(btnOk);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnOk);
		
	}

	private void btnOkAppuyé(JButton btnOk) {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreConseil.this.dispose();
			}
		});
	}

}
