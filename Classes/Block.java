package Classes;

import java.awt.*;

public class Block extends Rectangle {
	public int groundID;
	public int airID;
	public Rectangle range;
	public int rangeSize = 100;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		this.groundID = groundID;
		this.airID = airID;
		range = new Rectangle(x - rangeSize / 2, y - rangeSize / 2, width + rangeSize, height + rangeSize);
	}
	
	public void draw(Graphics g) {
		g.drawImage(Screen.groundTexture[groundID], x, y, width, height, null);
		
		if(airID != Value.air) {
			g.drawImage(Screen.airTexture[airID], x, y, width, height, null);
		}
	}
	
	public void fight(Graphics g) {
		if(Screen.isDebug) {
			if(airID == Value.airLaserTower) {
				g.drawRect(range.x, range.y, range.width, range.height);
			}
		}
	}
}
