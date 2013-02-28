package Classes;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class Screen extends JPanel implements Runnable {
	private Thread thread = new Thread(this);
	private Boolean isFirst = true;
	private int myWidth, myHeight;
	public static Room room;
	public static Image[] groundTexture = new Image[100];
	public static Image[] airTexture = new Image[100];
	public static Save save;
	
	// Starts thread
	
	public Screen() {
		thread.start();
	}
	
	// Defines a new room class
	
	public void define() {
		room = new Room();
		save = new Save();
		for(int i = 0; i < groundTexture.length; i++) {
			groundTexture[i] = new ImageIcon("resources/groundTexture.jpg").getImage();
			groundTexture[i] = createImage(new FilteredImageSource(groundTexture[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
		}
		
		for(int i = 0; i < airTexture.length; i++) {
			airTexture[i] = new ImageIcon("resources/airTexture.jpg").getImage();
			airTexture[i] = createImage(new FilteredImageSource(airTexture[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
		}
		
		save.loadSave(new File("save/mission1.twdf"));
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
