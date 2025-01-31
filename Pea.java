import java.awt.Rectangle;

import javax.swing.*;

public class Pea {
	
	public int posX;
	protected Gamepanel gp;
	public int myLane;
	public Pea(GamePanel parent,int lane,int startX){
        this.gp = parent;
        this.myLane = lane;
        posX = startX;
    }

    public void advance(){
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28);
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(pRect.intersects(zRect)){
                z.health -= 150;
                boolean exit = false;
                if(z.health < 0){
                    System.out.println("THE ZOMBIE IS DIED");
                    
                    gp.laneZombies.get(myLane).remove(i);
                    GamePanel.setProgress(10);
                    exit = true;
                }
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
       
        posX += 15;
    }


	
	

}
