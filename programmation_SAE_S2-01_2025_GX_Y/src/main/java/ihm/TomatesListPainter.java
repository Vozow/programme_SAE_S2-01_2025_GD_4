package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import modèle.Tomate;

public class TomatesListPainter extends JLabel implements ListCellRenderer<Object> {

	public TomatesListPainter() {
		this.setOpaque(true);
	}
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		Tomate tomate = (Tomate) value;
		this.setText(tomate.getDésignation());
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Tomates200x200\\"+tomate.getNomImage()+".jpg"));
		panel.add(lblImage, BorderLayout.WEST);
		
		JPanel panelText = new JPanel();
		panel.add(panelText, BorderLayout.CENTER);
		panelText.setLayout(new BorderLayout(0, 0));
		
		JLabel lblName = new JLabel(tomate.getDésignation());
		lblName.setFont(new Font("Ebrima", Font.BOLD, 20));
		panelText.add(lblName, BorderLayout.NORTH);

		
		JLabel lblDesc = new JLabel(tomate.getDescription());
		lblDesc.setFont(new Font("Ebrima", Font.PLAIN, 15));
		panelText.add(lblDesc, BorderLayout.CENTER);
		
		
		return panel;
	}

}
