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
		this.addMouseListener(new BListener());

	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
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

}