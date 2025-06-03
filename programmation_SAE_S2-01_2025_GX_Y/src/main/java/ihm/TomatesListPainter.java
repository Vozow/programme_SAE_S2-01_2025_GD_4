package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import modèle.Tomate;

public class TomatesListPainter extends JLabel implements ListCellRenderer<Object> {    
    
	private static final long serialVersionUID = 1L;
	
	//Variable provenant de la class DefaultListCellRenderer qui s'occupe
	//de gerer l'affichage par defaut d'une liste
    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;
    
    private Image image;
    
	public TomatesListPainter() {
        setBorder(SAFE_NO_FOCUS_BORDER);
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		//Création de l'affichage personnaliser de la liste
		Tomate tomate = (Tomate) value;
		this.setText(tomate.getDésignation());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(new LineBorder(new Color(50, 50, 50), 1));

		JPanel insidePanel = new JPanel();
		panel.add(insidePanel, BorderLayout.CENTER);
		insidePanel.setLayout(new BorderLayout(0, 0));
		insidePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblImage = new JLabel();
		//Recupere l'image de la tomate
		/*try {
			this.image = ImageIO.read(new File(".\\src\\main\\resources\\images\\Tomates200x200\\"+tomate.getNomImage()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.image = this.image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);*/
		//Affiche l'image
		lblImage.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Tomates200x200\\"+tomate.getNomImage()+".jpg"));
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		insidePanel.add(lblImage, BorderLayout.WEST);
		
		JPanel panelText = new JPanel();
		insidePanel.add(panelText, BorderLayout.CENTER);
		panelText.setLayout(new BorderLayout(0, 0));
		panelText.setBorder(new EmptyBorder(10, 20, 10, 10));
		panelText.setOpaque(false);


		JLabel lblName = new JLabel(tomate.getDésignation());
		lblName.setFont(new Font("Ebrima", Font.BOLD, 20));
		panelText.add(lblName, BorderLayout.NORTH);

		
		JTextArea TextAreaDesc = new JTextArea(tomate.getDescription());
		TextAreaDesc.setFont(new Font("Ebrima", Font.PLAIN, 15));
		TextAreaDesc.setBorder(new EmptyBorder(10, 20, 0, 0));
		TextAreaDesc.setLineWrap(true);
		TextAreaDesc.setWrapStyleWord(true);
		TextAreaDesc.setOpaque(false);
		panelText.add(TextAreaDesc, BorderLayout.CENTER);
		
		JLabel lblInstruction = new JLabel("Double cliquez pour acheter...");
		lblInstruction.setFont(new Font("Ebrima", Font.ITALIC, 12));
		lblInstruction.setBorder(new EmptyBorder(0, 20, 0, 0));
		panelText.add(lblInstruction, BorderLayout.SOUTH);
			
		//Code provenant de la class DefaultListCellRenderer qui s'occupe
		//de gerer l'affichage par defaut d'une liste, modifier pour la 
		//compatibilité avec notre code 
		//Gestion de la selection 
		//Gestion des couleurs lors de la selection
		if (isSelected) {
			 insidePanel.setBackground(list.getSelectionBackground());
			 insidePanel.setForeground(list.getSelectionForeground());
	        }
		 else {
			 insidePanel.setBackground(list.getBackground());
			 insidePanel.setForeground(list.getForeground());
		 }
		 //Gestion de la bordure lors de la selection
		 Border border;
		 if (cellHasFocus) {
			 if (isSelected) {
				 border = new LineBorder(new Color(70, 120, 255), 1);
			 }
			 else {
				 border = BorderFactory.createDashedBorder(Color.GRAY);
			 }
		 } 
		 else {
			 border = new EmptyBorder(2, 2, 2, 2);
		 }
		 panel.setBorder(border);
	       
		return panel;
	}

}
