package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modèle.Tomate;
import sun.swing.DefaultLookup;

public class TomatesListPainter extends JLabel implements ListCellRenderer<Object> {    
    
	//Variable provenant de la class DefaultListCellRenderer qui s'occupe
	//de gerer l'affichage par defaut d'une liste
    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;
    
	public TomatesListPainter() {
        setBorder(getNoFocusBorder());
		setOpaque(true);
	}
	
	//Fonction provenant de la class DefaultListCellRenderer qui s'occupe
	//de gerer l'affichage par defaut d'une liste
    private Border getNoFocusBorder() {
        Border border = DefaultLookup.getBorder(this, ui, "List.cellNoFocusBorder");
        if (System.getSecurityManager() != null) {
            if (border != null) return border;
            return SAFE_NO_FOCUS_BORDER;
        } else {
            if (border != null &&
                    (noFocusBorder == null ||
                    noFocusBorder == DEFAULT_NO_FOCUS_BORDER)) {
                return border;
            }
            return noFocusBorder;
        }
    }

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
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
		 Border border = null;
		 if (cellHasFocus) {
			 if (isSelected) {
				 border = DefaultLookup.getBorder(this, ui, "List.focusSelectedCellHighlightBorder");
			 }
			 if (border == null) {
				 border = DefaultLookup.getBorder(this, ui, "List.focusCellHighlightBorder");
			 }
		 } 
		 else {
			 border = getNoFocusBorder();
		 }
		 panel.setBorder(border);
	       
		return panel;
	}

}
