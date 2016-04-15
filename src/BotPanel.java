import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;

public class BotPanel extends JPanel {

	private static BotPanel instance;

	// Private constructor
	private BotPanel() {
		setPreferredSize(new Dimension(800, 150));
		setBackground(Color.decode(ColorManager.getBotPanelBackground()));
		setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.decode(ColorManager.getBotPanelBorder())));
	}

	// Accessor method to get the one instance. If the instance doesn't exist yet, make it.
	public static BotPanel get() {
		if (instance == null) {
			instance = new BotPanel();
		}
		return instance;
	}


}