import javax.swing.*;

public class SunFlower extends Plants {
	
	Timer SunProduceTimer;
	
	public SunFlower(GamePanel parent, int x, int y) {
		super(parent, x, y);
		SunProduceTimer = new Timer(20000,(ActionEvent e)->{
			Sun sta = new Sun(gp, 60 + x*100, 110 + y*120, 130 + y*120);
			gp.activeSuns.add(sta);
			gp.add(sta, new Integer(1));
		});
		SunProduceTimer.start();
	}
	
	

}
