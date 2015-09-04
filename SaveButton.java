import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveButton extends Button {
	public SaveButton() {
		setText("SAVE");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
			Controller.get().save();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}

	}

}