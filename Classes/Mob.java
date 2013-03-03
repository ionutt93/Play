package Classes;

import java.awt.*;

public class Mob extends Rectangle {
	public int mobSize = 30;
	public int mobID = Value.mobAir;
	public Boolean inGame = false;
	public int walkFrame = 0 , walkSpeed = 40;
	public int up = 0, down = 1, right = 2, left = 3;
	public int direction = right;
	public int mobWalk = 0;
	private int xC, yC;
	private Boolean wasUp = false;
	private Boolean wasDown = false;
	private Boolean wasLeft = false;
	private Boolean wasRight = false;
	
	public Mob() {
		
	}
	
	public void spawnMob(int mobID) {
		for(int y = 0; y < Screen.room.block.length; y++) {
			if(Screen.room.block[y][0].groundID == Value.groundRoad) {
				setBounds(Screen.room.block[y][0].x, Screen.room.block[y][0].y, mobSize, mobSize);
				xC = 0;
				yC = y;
			}
		}
		this.mobID = mobID;
		inGame = true;
	}
	
	public void deleteMob() {
		inGame = false;
	}
	
	public void looseHealth() {
		Screen.health -= 1;
	}
	
	public void physics() {
		if(walkFrame >= walkSpeed) {
			if(direction == right) {
				x++;
			} else if(direction == up) {
				y--;
			} else if(direction == down) {
				y++;
			} else if(direction == left) {
				x--;
			}
			mobWalk++;
			
			if(mobWalk == Screen.room.blockSize) {
				if(direction == right) {
					wasRight = true;
					xC++;
				} else if(direction == up) {
					wasUp = true;
					yC--;
				} else if(direction == down) {
					wasDown = true;
					yC++;
				} else if(direction == left) {
					wasLeft = true;
					xC--;
				}
				if(!wasUp) {
					try {
						if(Screen.room.block[yC+1][xC].groundID == Value.groundRoad) {
							direction = down;
						}
					} catch (Exception e) {	}
				}
				if(!wasDown) {
					try {
						if(Screen.room.block[yC-1][xC].groundID == Value.groundRoad) {
							direction = up;
						}
					} catch (Exception e) {	}
				}
				if(!wasLeft) {
					try {
						if(Screen.room.block[yC][xC+1].groundID == Value.groundRoad) {
							direction = right;
						}
					} catch (Exception e) {	}
				}
				if(!wasRight) {
					try {
						if(Screen.room.block[yC][xC-1].groundID == Value.groundRoad) {
							direction = left;
						}
					} catch (Exception e) {	}
				}
				if(Screen.room.block[yC][xC].airID == Value.mobAir) {
					deleteMob();

					looseHealth();
				}
				wasUp = false;
				wasDown = false;
				wasLeft = false;
				wasRight = false;
				mobWalk = 0;
			}
			
			walkFrame = 0;
		} else {
			walkFrame++;
		}
	}
	
	public void draw(Graphics g) {
			g.drawImage(Screen.mobTexture, x, y, width, height, null);
	}
}
