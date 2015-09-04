import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveButton extends Button {
	RemoveButton button;
	private Boolean off = true;
	public RemoveButton() {
		button = this;
		setBackground(Color.RED);
		setText("Remove a button");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
			if (off) {
				button.setOpaque(true);
				button.setForeground(Color.WHITE);

				Controller.get().toggleEditing();
				System.out.println("Editing");
				off = false;

			} else {
				button.setOpaque(false);
				button.setForeground(Color.BLACK);

				Controller.get().toggleEditing();
				off = true;
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}