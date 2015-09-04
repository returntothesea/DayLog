import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class LogItem extends JLabel {
	LogItem item;
	String text;
	public LogItem(String s) {
		setBackground(Color.decode(ColorManager.getHighlighted()));
		setForeground(Color.decode(ColorManager.getLogPanelText()));
		text = s;
		setText(s);
		Border b = BorderFactory.createEmptyBorder(3, 3, 3, 0);
		setBorder(b);
		item = this;
		this.addMouseListener(new BListener());
	}

	public class BListener implements MouseListener {
		public void mouseExited(MouseEvent e) {
			item.setOpaque(false);
			item.setForeground(Color.decode(ColorManager.getLogPanelText()));;
			item.setText(text);
			item.revalidate();
			item.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			item.setOpaque(true);
			item.setForeground(Color.WHITE);
			item.setText("DELETE ITEM                                ");
			item.revalidate();
			item.repaint();
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			Controller.get().removeItem(text);
		}
	}


	
}