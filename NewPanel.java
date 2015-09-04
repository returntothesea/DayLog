import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class NewPanel extends JPanel {
	private static NewPanel instance;

	private NewPanel() {

		Dimension dim = new Dimension(200, 80);
		setPreferredSize(dim);
		JTextField text = new JTextField("", 15);
		SubmitButton submit = new SubmitButton(text);
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		add(new JLabel("Create a new button"));
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