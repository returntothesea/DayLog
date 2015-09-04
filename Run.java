import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Run {
	public static void main ( String[] args) {

		JFrame frame = new JFrame("Day Log");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Set up the frame
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(LogPanel.get(), BorderLayout.WEST);


		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 700));
		panel.add(MainPanel.get());
		panel.add(BotPanel.get());
		frame.add(panel);


		//frame.add(MainPanel.get(), BorderLayout.CENTER);
		//frame.add(BotPanel.get(), BorderLayout.SOUTH);


		Controller con = Controller.get();		// Controller sets up the panels
		con.setup();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);




	}
}