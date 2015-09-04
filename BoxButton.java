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
		setBackground(Color.RED);
		button = this;
		setText(s);
		buttonText = s;
		
		Border blackLine = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black);
		Border blank = BorderFactory.createEmptyBorder(50, 50, 50, 50);

		Border compound = BorderFactory.createCompoundBorder(blackLine, blank);

		setBorder(compound);

		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			if (Controller.get().isEditing()) {
				button.setOpaque(false);
				button.setForeground(Color.BLACK);
				button.revalidate();
				button.repaint();
			}
		}
		public void mouseEntered(MouseEvent e) {
			if (Controller.get().isEditing()) {
				button.setOpaque(true);
				button.setForeground(Color.WHITE);
				button.revalidate();
				button.repaint();
			}
		}
		public void mouseClicked(MouseEvent e) {
			if (Controller.get().isEditing()) {
				Controller.get().removeButton(buttonText);
				Controller.get().toggleEditing();
				RemoveButton.colorFlip();
			} else {
				DateFormat timeStampFormat = new SimpleDateFormat("hh:mm a");
				Date time = new Date();
				String stamp = new String(timeStampFormat.format(time));
				String send = new String("[" + stamp + "] " + buttonText);
				Controller.get().addToList(send);
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}