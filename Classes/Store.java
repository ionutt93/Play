package Classes;

import java.awt.*;

public class Store {
	private int shopWidth = 8;
	private Rectangle[] button = new Rectangle[shopWidth];
	private Rectangle buttonHealth;
	private Rectangle buttonCoins;
	private int buttonSize = 32;
	private int iconSize = 20;
	private int cellSpace = 2;
	private int awayFromRoom = 10;
	private int x;
	private int y;
	
	
	public Store() {
		define();
	}
	
	public void define() {
		for(int i = 0; i < button.length; i++) {
			x = (Screen.myWidth / 2) - ((shopWidth * (buttonSize + cellSpace)) / 2) + (buttonSize + cellSpace) * i;
			y = Screen.room.block[Screen.room.worldHeight - 1][0].y + Screen.room.blockSize + awayFromRoom;
			button[i] = new Rectangle(x, y, buttonSize, buttonSize);
		}
		
		buttonHealth = new Rectangle(Screen.room.block[0][0].x + iconSize, button[0].y, iconSize, iconSize);
		buttonCoins = new Rectangle(Screen.room.block[0][0].x + iconSize, buttonHealth.y + iconSize + 5, iconSize, iconSize);
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < button.length; i++) {
			if(button[i].contains(Screen.mse)) {
				g.setColor(new Color(0, 0, 0, 150));
				g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
			}
			
			g.drawImage(Screen.shopTexture, button[i].x, button[i].y, button[i].width, button[i].height, null);
		}
		
		g.drawImage(Screen.heartTexture, buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height, null);
		g.drawImage(Screen.coinTexture, buttonCoins.x, buttonCoins.y, buttonCoins.width, buttonCoins.height, null);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(Color.white);
		g.drawString("" + Screen.health, buttonHealth.x + buttonHealth.width + 10, buttonHealth.y + 13);
		g.drawString("" + Screen.coins, buttonCoins.x + buttonCoins.width + 10, buttonCoins.y + 13);
	}
}
