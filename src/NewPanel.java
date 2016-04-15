import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class NewPanel extends JPanel {
	private static NewPanel instance;

	private NewPanel() {

		setBackground(Color.decode(ColorManager.getCreatePanelBackground()));
		Dimension dim = new Dimension(200, 120);
		setPreferredSize(dim);
		JTextField text = new JTextField("", 15);
		SubmitButton submit = new SubmitButton(text);
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode(ColorManager.getCreatePanelBorder())));
		JLabel label = new JLabel("Create a new button");
		label.setForeground(Color.decode(ColorManager.getCreatePanelText()));
		add(label);
		add(text);
		add(submit);
	}

	public static NewPanel get() {
		if (instance == null) {
			instance = new NewPanel();
		}
		return instance;
	}


}