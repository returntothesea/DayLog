import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class BotPanel extends JPanel {

	private static BotPanel instance;

	private BotPanel() {
		setPreferredSize(new Dimension(800, 100));
	}

	public static BotPanel get() {
		if (instance == null) {
			instance = new BotPanel();
		}
		return instance;
	}


}