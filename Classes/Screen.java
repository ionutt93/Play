package Classes;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements Runnable {
	private Thread thread = new Thread(this);
	
	public Screen() {
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void run() {
		while(true)	{
			repaint();
			
			try {
				thread.sleep(1);
			} catch(Exception e) {
				
			}
		}
	}
}
