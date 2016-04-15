import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SubmitButton extends Button {
	JTextField text;
	public SubmitButton(JTextField t) {
		addBorder();
		text = t;
		setText("SUBMIT");
		setForeground(Color.decode(ColorManager.getSaveButtonText()));
		setBackground(Color.decode(ColorManager.getHighlighted()));
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			setRestingColor();
		}
		public void mouseEntered(MouseEvent e) {
			setHighlighted();
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			if (text.getText().equals("")) {
				System.out.println("Empty field");
			} else {
				Controller.get().addButton(text.getText());
				text.setText("");
			}
		}
	}

	private void setRestingColor() {
		setOpaque(false);
		revalidate();
		repaint();
	}

	private void setHighlighted() {
		setOpaque(true);
		revalidate();
		repaint();
	}

}