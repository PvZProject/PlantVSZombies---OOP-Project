package game;

import java.util.Random;

public class Easter_Eggs {
	private Sky sky;
	private Row row;
	private GameState gamestate;
	public Plant[] planets;
	private Random random;
	public int numCheckEE = 0;
	boolean correction = false;
	
	
	public Easter_Eggs() {
		
	}

	public void checkEasterEggs() {
		while (numCheckEE <= 7) {
			
			for (int i = 0; i < row.planetLoc.length; i++) {	
				if (row.rowNum == 3 && row.planetLoc[i] == row.houseLocX[0]) numCheckEE++;
				else if (row.rowNum == 3 && row.planetLoc[i] == row.houseLocX[1]) numCheckEE++;
				else if (row.rowNum == 3 && row.planetLoc[i] == row.houseLocX[2]) numCheckEE++;
				else if (row.rowNum == 3 && row.planetLoc[i] == row.houseLocX[3]) numCheckEE++;
				else if (row.rowNum == 2 && row.planetLoc[i] == row.houseLocX[3]) numCheckEE++;
				else if (row.rowNum == 4 && row.planetLoc[i] == row.houseLocX[3]) numCheckEE++;
			}
			
			if (numCheckEE == 7) {
				correction = true;
				sky.storedSun += 200;
				break;
			} 
			
			else continue;
		}
	
	}
	
	
}

