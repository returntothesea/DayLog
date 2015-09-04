import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveButton extends Button {
	private static RemoveButton button;
	private Boolean off = true;
	public RemoveButton() {
		setForeground(Color.decode(ColorManager.getRemoveButtonText()));
		button = this;
		setBackground(Color.decode(ColorManager.getRemoveButtonBackground()));
		setText("Remove a button");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			if (off) {
				colorFlip();

				Controller.get().toggleEditing();
				off = false;

			} else {
				colorFlip();

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