import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Button extends JLabel {

	public void addBorder() {
		Border colorLine = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode(ColorManager.getSaveButtonBorder()));
		Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border compound = BorderFactory.createCompoundBorder(colorLine, blank);
		setBorder(compound);
	}

}