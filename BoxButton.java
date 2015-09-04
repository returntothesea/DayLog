import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BoxButton extends JLabel {
	String buttonText;
	BoxButton button;
	public BoxButton(String s) {
		setForeground(Color.decode(ColorManager.getBoxButtonText()));
		setBackground(Color.decode(ColorManager.getBoxButtonBackground()));
		setOpaque(true);
		button = this;
		setText(s);
		buttonText = s;
		
		Border blackLine = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode(ColorManager.getBoxButtonBorder()));
		Border blank = BorderFactory.createEmptyBorder(50, 50, 50, 50);

		Border compound = BorderFactory.createCompoundBorder(blackLine, blank);

		setBorder(compound);

		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			if (Controller.get().isEditing()) {
				button.setBackground(Color.decode(ColorManager.getBoxButtonBackground()));
				button.setForeground(Color.decode(ColorManager.getBoxButtonText()));
				button.revalidate();
				button.repaint();
			}
		}
		public void mouseEntered(MouseEvent e) {
			if (Controller.get().isEditing()) {
				setBackground(Color.decode(ColorManager.getHighlighted()));
				button.setForeground(Color.decode(ColorManager.getBoxButtonText()));
				button.revalidate();
				button.repaint();
			}
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {

			if (Controller.get().isEditing()) {
				Controller.get().removeButton(buttonText);
				Controller.get().toggleEditing();
				RemoveButton.colorFlip();
			} else {
				DateFormat dayCheckFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date time = new Date();
				String check = new String(dayCheckFormat.format(time) + ".txt");
				if(check.equals(Controller.get().fileCurrentlyInUse())) {
					DateFormat timeStampFormat = new SimpleDateFormat("hh:mm a");
					String stamp = new String(timeStampFormat.format(time));
					String send = new String("[" + stamp + "] " + buttonText);
					Controller.get().addToList(send);
				} else {
					Controller.get().clearLog();
					Controller.get().logSetup();
				}
			}
		}
	}
}