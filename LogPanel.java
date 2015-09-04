import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class LogPanel extends JPanel {

	private static LogPanel instance;
	
	private LogPanel() {
		Dimension dim = new Dimension(300, 700);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(dim);
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
	}

	public static LogPanel get() {
		if (instance == null) {
			instance = new LogPanel();
		}
		return instance;
	}


}