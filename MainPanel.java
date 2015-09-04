import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel {

	private static MainPanel instance;

	private MainPanel() {
		setPreferredSize(new Dimension(800, 550));
		setBackground(Color.decode(ColorManager.getMainPanelBackground()));
	}

	public static MainPanel get() {
		if (instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}


}