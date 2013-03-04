package Classes;

import java.awt.*;

public class Room {
	public static int worldWidth = 15; 
	public static int worldHeight = 10;
	public static int blockSize = 32;
	public static Block[][] block;
	
	public Room() {
		define();
	}
	
	public void define() {
		block = new Block[worldHeight][worldWidth];
		
		for(int y = 0; y < block.length; y++) {
			for(int x = 0; x < block[0].length; x++) {
				block[y][x] = new Block(x * blockSize, y * blockSize, blockSize, blockSize, Value.groundGrass, Value.air);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int y = 0; y < block.length; y++) {
			for(int x = 0; x < block[0].length; x++) {
				block[y][x].draw(g);
			}
		}
		
		for(int y = 0; y < block.length; y++) {
			for(int x = 0; x < block[0].length; x++) {
				block[y][x].fight(g);
			}
		}
	}
	
	public void physic() {
		
	}
}
