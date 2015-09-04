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
	//Controller controller = Controller.get();

	public BoxButton(String s) {
		setText(s);
		buttonText = s;
		
		//Border Compound2;
		Border blackLine = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black);
		Border blank = BorderFactory.createEmptyBorder(50, 50, 50, 50);

		Border compound = BorderFactory.createCompoundBorder(blackLine, blank);

		setBorder(compound);

		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
			DateFormat timeStampFormat = new SimpleDateFormat("hh:mm a");
			Date time = new Date();
			String stamp = new String(timeStampFormat.format(time));
			String send = new String("[" + stamp + "] " + buttonText);
			Controller.get().addToList(send);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}