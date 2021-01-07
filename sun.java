import java.awt.event.MouseEvent;

import javax.swing.*;

public class sun extends JPanel implements MouseListener {
	GamePanel gp;
	Image sunImage;
	
	int myX;
	int myY;
	int endY;
	
	int destruct = 150;
	
	public sun(GamePanel parent, int myX, int myY, int endY) {
		this.gp = parent;
		this.endY = endY;
		setSize(80,80);
		setOpaque(false);
		myX = startX;
		myY = startY;
		setLocation(myX, myY);
		sunImage = new ImageIcon(this.getClass().getResource("images/sun.png")).getImage();
        addMouseListener(this);
		
	}
	protected void paintComponent (Graphic g);
	super.paintComponent(g);
    g.drawImage(sunImage,0,0,null);
}

public void advance(){
    if(myY < endY) {
        myY+= 4;
    }else{
        destruct--;
        if(destruct<0){
            gp.remove(this);
            gp.activeSuns.remove(this);
        }
    }
    setLocation(myX,myY);
}


public void mouseClicked(MouseEvent e) {


public void mousePressed(MouseEvent e) {

}


public void mouseReleased(MouseEvent e) {
    gp.setSunScore(gp.getSunScore()+25);
    gp.remove(this);
    gp.activeSuns.remove(this);
}


public void mouseEntered(MouseEvent e) {

}


public void mouseExited(MouseEvent e) {

}
}