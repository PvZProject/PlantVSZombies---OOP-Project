package game;

import java.util.Random;

/**
 * THIS IS A CLASS TO CONTROL ALL LEVELS
 */

public class Level {
    
    protected Random random;
    protected boolean roundOneIsDone = false, roundTwoIsDone = false;
    protected long startTime;
    protected int counter = 0;
    public GameState state;
    protected int i = 1, j = 2, k = 3;
    protected boolean FirstSound = true, FirstSoundH = true;
    public boolean levelIsDone = false, gameOver = false;

    public Level (GameState state) {
	
		random = new Random();
		startTime = System.currentTimeMillis();
		this.state = state;
		state.planetsInTheBar[6] = new PlantInPlantBar(7, 7);
	
    }
    
    // FUNCTION TO CHECK WHETHER THE GAME IS OVER OR NOT !!
    public void update () {
    	
		for (int l = 0; l < 5; l++) {
			
		    if (state.rows[l].gameOver) this.gameOver = true;
		    
		}

    }
    
}
