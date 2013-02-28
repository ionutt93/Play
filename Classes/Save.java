package Classes;

import java.io.*;
import java.util.*;

public class Save {
	public void loadSave(File loadPath) {
		try {
			Scanner scanner = new Scanner(loadPath);
			
			while(scanner.hasNext()) {
				for(int y = 0; y < Screen.room.block.length; y++) {
					for(int x = 0; x < Screen.room.block[0].length; x++) {
						Screen.room.block[y][x].groundID = scanner.nextInt();
					}
				}
				
				for(int y = 0; y < Screen.room.block.length; y++) {
					for(int x = 0; x < Screen.room.block[0].length; x++) {
						Screen.room.block[y][x].airID = scanner.nextInt();
					}
				}
			}
			scanner.close();
	
		} catch (Exception e) {
			
		}
	}
}
