import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SubmitButton extends Button {
	JTextField text;
	public SubmitButton(JTextField t) {
		text = t;
		setText("SUBMIT");
		this.addMouseListener(new BListener());

	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
			if (text.getText().equals("")) {
				System.out.println("Empty field");
			} else {
				Controller.get().addButton(text.getText());
				text.setText("");
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}

}