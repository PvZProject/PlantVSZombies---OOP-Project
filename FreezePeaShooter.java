import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class FreezePeaShooter extends Plants {
	
	public Timer shootTimer;
	
	public FreezePeaShooter(GamePanel parent, int x, int y) {
	
	super(parent,x,y);
	
	shootTimer = new Timer(1500,(ActionEvent e)-> {
		if(gp.laneZombies.get(y).size() > 0 ) {
			gp.lanePea.get(y).add(new FreezePea(gp,y,103 + this.x * 100));
			
		}
	});
	shootTimer.start();
		
	}
	public void stop() {
	shootTimer.stop();
	

}
}