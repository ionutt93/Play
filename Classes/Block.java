package Classes;

import java.awt.*;

public class Block extends Rectangle {
	public static int groundID;
	public static int airID;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		this.groundID = groundID;
		this.airID = airID;
	}
	
	public void draw(Graphics g) {
		g.drawImage(Screen.groundTexture[groundID], x, y, width, height, null);
		
		if(airID != Value.air) {
			g.drawImage(Screen.airTexture[airID], x, y, width, height, null);
		}
	}
}
