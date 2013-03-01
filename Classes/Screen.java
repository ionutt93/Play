package Classes;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class Screen extends JPanel implements Runnable {
	private Thread thread = new Thread(this);
	private Boolean isFirst = true;
	public static int myWidth, myHeight;
	public static int coins = 10, health = 25;
	public static Room room;
	
	public static Image[] groundTexture = new Image[100];
	public static Image[] airTexture = new Image[100];
	public static Image shopTexture;
	public static Image coinTexture;
	public static Image heartTexture;
	public static Image mobTexture;
	
	public static Save save;
	public static Point mse = new Point(0, 0);
	public static Store store;
	
	public static Mob[] mobs = new Mob[100];
	public int spawnTime = 2000, spawnFrame = 0; 
	
	// Starts thread
	
	public Screen(Frame frame) {
		frame.addMouseListener(new KeyHandler());
		frame.addMouseMotionListener(new KeyHandler());
		thread.start();
	}
	
	// Defines a new room class
	
	public void define() {
		room = new Room();
		save = new Save();
		store = new Store();
		
		for(int i = 0; i < groundTexture.length; i++) {
			groundTexture[i] = new ImageIcon("resources/groundTexture.jpg").getImage();
			groundTexture[i] = createImage(new FilteredImageSource(groundTexture[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
		}
		
		for(int i = 0; i < airTexture.length; i++) {
			airTexture[i] = new ImageIcon("resources/airTexture.jpg").getImage();
			airTexture[i] = createImage(new FilteredImageSource(airTexture[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
		}
		shopTexture = new ImageIcon("resources/shopTexture.png").getImage();
		coinTexture = new ImageIcon("resources/coinTexture.png").getImage();
		heartTexture = new ImageIcon("resources/heartTexture.png").getImage();
		mobTexture = new ImageIcon("resources/mobTexture.png").getImage();
		
		save.loadSave(new File("save/mission1.twdf"));
		for(int i = 0; i < mobs.length; i++) {
			mobs[i] = new Mob();
		}
	}
	
	// Updates the graphics
	
	public void paintComponent(Graphics g) {
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			isFirst = false;
		}
		g.setColor(new Color(60, 60, 60));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0, 0, 0));
		room.draw(g);
		for(int i = 0; i< mobs.length; i++) {
			if(mobs[i].inGame) {
				mobs[i].draw(g);
			}
		}
		
		store.draw(g);
	}
	
	public void mobSpawner() {
		if(spawnFrame >= spawnTime) {
			for(int i = 0; i < mobs.length; i++) {
				if(!mobs[i].inGame) {
					mobs[i].spawnMob(Value.mobGround);
					break;
				}
			}
			spawnFrame = 0;
		} else {
			spawnFrame += 1;
		}
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
				mobSpawner();
				for(int i = 0; i < mobs.length; i++) {
					if(mobs[i].inGame) {
						mobs[i].physics();
					}
				}
			}
			repaint();
			
			try {
				Thread.sleep(1);
			} catch(Exception e) {
				
			}
		}
	}
}
