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

	// Visual setup
	public BoxButton(String s) {
		Font labelFont = this.getFont();
		setFont(new Font(labelFont.getName(), Font.PLAIN, 16));

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
	// Mouse interaction
	public class BListener implements MouseListener {

		// Highlight when mouse hovers over.
		public void mouseExited(MouseEvent e) {
				button.setBackground(Color.decode(ColorManager.getBoxButtonBackground()));
				button.setForeground(Color.decode(ColorManager.getBoxButtonText()));
				button.revalidate();
				button.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			if (Controller.get().isEditing()) {
				setBackground(Color.decode(ColorManager.getRemoving()));
				button.setForeground(Color.decode(ColorManager.getRemoving()));
				button.revalidate();
				button.repaint();
			} else {
				setBackground(Color.decode(ColorManager.getHighlighted()));
				button.setForeground(Color.decode(ColorManager.getBoxButtonText()));
				button.revalidate();
				button.repaint();
			}
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}

		// Check to see whether Controller is set to button-editing mode.
		// If it is, remove button on release and flip 'remove' button back to resting color.
		// If it isn't in editing mode, check to see if the current Date is the same as the
		// date file that's currently open. Make and open a new file if necessary, otherwise
		// send to the LogPanel.
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
					DateFormat timeStampFormat = new SimpleDateFormat("hh:mm a");
					String stamp = new String(timeStampFormat.format(time));
					String send = new String("[" + stamp + "] " + buttonText);
					Controller.get().addToList(send);
				}
			}
		}
	}
}