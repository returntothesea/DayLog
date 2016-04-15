import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveButton extends Button {
	private static RemoveButton button;
	private boolean off = true;
	public RemoveButton() {
		setForeground(Color.decode(ColorManager.getRemoveButtonText()));
		button = this;
		setBackground(Color.decode(ColorManager.getRemoveButtonBackground()));
		setText("Remove a button");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			if (off) {
				colorFlip();
			}
		}
		public void mouseEntered(MouseEvent e) {
			if (off) {
				colorFlip();
			}
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			if (off) {

				Controller.get().toggleEditing();
				off = false;

			} else {

				Controller.get().toggleEditing();
				off = true;
			}
		}
	}

	public RemoveButton get() {
		return button;
	}

	public static void colorFlip() {
		if (button.isOpaque() == true) {
			button.setOpaque(false);
			button.setForeground(Color.decode(ColorManager.getRemoveButtonText()));
			button.revalidate();
			button.repaint();
		} else {
			button.setOpaque(true);
			button.setForeground(Color.decode(ColorManager.getRemoveButtonText()));
			button.revalidate();
			button.repaint();
		}
	}
}