import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Controller {

	ArrayList<String> al;
	DateFormat fileNameFormat;
	String fileName;
	File file;
	Date date;
	MainPanel mainPanel;
	LogPanel logPanel;
	BotPanel botPanel;
	NewPanel newPanel;
	Boolean editing = false;

	private static Controller instance;

	private Controller() {
	}

	public static Controller get() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	public void setup() {
		date = new Date();
		fileNameFormat = new SimpleDateFormat("yyyy-MM-dd");	// Format for the date on the file name.
		fileName = new String((fileNameFormat.format(date)) + ".txt");	// Actual file name
		file = new File("logs/" + fileName);	// Path for the file.

		al = new ArrayList<String>();

		mainPanel = MainPanel.get();
		logPanel = LogPanel.get();
		botPanel = BotPanel.get();
		newPanel = NewPanel.get();

		logSetup();
		mainSetup();
		botSetup();
	}

	private void botSetup() {
		botPanel.add(new SaveButton(), BorderLayout.SOUTH);
		botPanel.add(newPanel);
	}

	private void mainSetup() {
		try {
			File f = new File("actions/actions.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			while ((s = br.readLine()) != null) {
				mainPanel.add(new BoxButton(s), BorderLayout.NORTH);	// [CODE NEEDED TO ADD BUTTONS]
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	private void logSetup() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				al.add(0, line);	// Add each line at place 0 in the ArrayList so that they're put in descending order.
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		populateLogPanel();

		
	}

	private void populateLogPanel() {
		for (int x = 0; x < al.size(); x++) {
			logPanel.add(new LogItem(al.get(x)));
		}
		logPanel.revalidate();
		logPanel.repaint();
	}

	public void removeItem(String s) {
		if (al.contains(s)) {
			al.remove(s);
		}
		logPanel.removeAll();
		populateLogPanel();
	}

	public static void ping() {
		System.out.println("pinged\n\n");
	}

	public void addToList(String s) {
		al.add(0, s);
		logPanel.removeAll();
		populateLogPanel();
	}

	public void saveLog() {
		ArrayList<String> saveList = new ArrayList<String>();
		for (int x = 0; x < al.size(); x++) {
			saveList.add(0, al.get(x));
		}
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int x = 0; x < saveList.size(); x++) {
				bw.write(saveList.get(x) + System.getProperty("line.separator"));
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Saved");
	}

	public void addButton(String s) {
		File f = new File("actions/actions.txt");
		try {
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(System.getProperty("line.separator") + s);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reload();
	}

	public void reload() {
		mainPanel.removeAll();
		mainSetup();
	}

}