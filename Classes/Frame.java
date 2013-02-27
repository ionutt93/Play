package Classes;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	private String title;
	private Dimension size;
	
	public Frame() {
		title = "Tower Defence v1";
		size = new Dimension(500, 600);
		
		setSize(size);
		setTitle(title);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	public void init() {
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
	
	
}
