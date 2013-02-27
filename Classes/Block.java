package Classes;

import java.awt.*;

public class Block extends Rectangle {
	private int groundID;
	private int airID;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		this.groundID = groundID;
		this.airID = airID;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
