import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveButton extends Button {
	public SaveButton() {
		setBackground(Color.decode(ColorManager.getSaveButtonBackground()));
		setOpaque(true);
		setForeground(Color.decode(ColorManager.getSaveButtonText()));
		setText("SAVE");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			Controller.get().save();
		}

	}

}