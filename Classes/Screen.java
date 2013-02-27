package Classes;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements Runnable {
	private Thread thread = new Thread(this);
	private Boolean isFirst = true;
	private int myWidth, myHeight;
	private Room room;
	
	// Starts thread
	
	public Screen() {
		thread.start();
	}
	
	// Defines a new room class
	
	public void define() {
		room = new Room();
	}
	
	// Updates the graphics
	
	public void paintComponent(Graphics g) {
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			isFirst = false;
		}
		g.clearRect(0, 0, getWidth(), getHeight());
		room.draw(g);
	}
	
	public int getMyWidth() {
		return myWidth;
	}
	
	public int getMyHeight() {
		return myHeight;
	}
	
	// Runs the screen
	
	public void run() {
		while(true)	{
			if(!isFirst) {
				room.physic();
			}
			repaint();
			
			try {
				Thread.sleep(1);
			} catch(Exception e) {
				
			}
		}
	}
}
