import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveButton extends Button {
	public SaveButton() {
		setOpaque(true);
		setForeground(Color.decode(ColorManager.getSaveButtonText()));
		setRestingColor();
		setText("SAVE");
		addBorder();
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			setRestingColor();
		}
		public void mouseEntered(MouseEvent e) {
			setHighlighted();
		}
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			Controller.get().save();
		}

	}

	private void setRestingColor() {
		setBackground(Color.decode(ColorManager.getSaveButtonBackground()));
		revalidate();
		repaint();
	}

	private void setHighlighted() {
		setBackground(Color.decode(ColorManager.getHighlighted()));
		revalidate();
		repaint();
	}

}