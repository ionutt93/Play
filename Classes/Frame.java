package Classes;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	private String title;
	private Dimension size;
	private Screen screen;
	
	// Creates the frame for the application
	
	public Frame() {
		title = "Tower Defence v1";
		size = new Dimension(480, 400);
		
		setSize(size);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	// Initializes the application
	
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));
		screen = new Screen();
		add(screen);
		setVisible(true);
	}
	
	// Calls the constructor
	
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
	
	
}
