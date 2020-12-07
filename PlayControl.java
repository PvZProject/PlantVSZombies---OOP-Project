package events;
import GUI.*;
import characters.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;

public class PlayControl {

	public LevelControl level=new LevelControl();
	private Physics phy = new Physics();
	private static ArrayList<Zombies> zombies = new ArrayList<>();
	private static ArrayList<Bullet> bullets = new ArrayList<>();
	private static  ArrayList<Sun> sun = new ArrayList<>();
	private Integer[] stopPos = new Integer[5];
	private Zombies tempZombie;
	private Bullet tempBullet;
	private Sun tempSun;
	private Main screen;
	public Graphics g;
	private Sound Punch;
	public Sound ZomWalk;
	private int scoreSun;
	public int limitness = 0;

	//--------------------------------------PLANTS--------------------------------------
	public void renderPlants(Plants p) throws SlickException      {level.drawPlants(p);}

	//--------------------------------------Sun Flowers---------------------------------
	public int getDelayTimeSun(int maxTime)     {return (int)(Math.random()*maxTime)+1;}
	public void renderSunFlowers(SunFlower s)   {s.draw();}

	//--------------------------------------BULLET---------------------------------------
			public void shoot()
			{
				for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
				{
					tempBullet=bullets.get(i);

					if(tempBullet.xPos>screen.WIDTH)          // remove bullets out of screen
					{
						removeBullet(tempBullet);
					}

					if(phy.Collision(tempBullet, zombies))
					{
						removeBullet(tempBullet);
					}
					tempBullet.flying();
				}
			}

			public void renderBullet(Graphics g) throws SlickException    // draw bullets
			{

				for(int i=0;i<bullets.size();i++)
				{
					tempBullet=bullets.get(i);
					level.drawBullets(tempBullet);
				}
			}

			public void addBullet(Bullet b)     {bullets.add(b);}
			public void removeBullet(Bullet b)  {bullets.remove(b);}

	//--------------------------------------ZOMBIE---------------------------------------
	public void zomWalk() throws SlickException
	{
		for(int i=0;i<zombies.size();i++)  ///shoot all the bullets in the list
		{
			Punch = new Sound("res/Play/Punch.wav");
			ZomWalk = new Sound("res/Play/zombie.wav");
			tempZombie=zombies.get(i);
			tempZombie.moving();
			if(tempZombie.getHp()<=0)
			{
				removeZombie(tempZombie);
				Punch.play();
			}
			if(phy.Collision(tempZombie, bullets))
			{
				level.setHp(tempZombie);
			}
		}

	}
	public void renderZombie()
	{
		for(int i=0;i<zombies.size();i++)
		{
			tempZombie=zombies.get(i);
			tempZombie.draw();
		}
	}
	
	public void addZombie(Zombies z)      {zombies.add(z);}
	public void removeZombie(Zombies z)   {zombies.remove(z);}

	//--------------------------------------SUN---------------------------------------

	public void fall() throws SlickException
	{	stopPos[0]=195;
		stopPos[1]=295;
		stopPos[2]=395;
		stopPos[3]=495;
		stopPos[4]=595;
		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);

			if(tempSun.yPos <= stopPos[tempSun.getRandomInt()])
				tempSun.yPos += 1;
			}
	}
	public void renderSun()              // draw suns
	{
		for(int i=0;i<sun.size();i++)
		{
			tempSun=sun.get(i);
			tempSun.draw();
		}
	}
	public void addSun(Sun b)        {sun.add(b);}
	public void removeSun(Sun b)     {sun.remove(b);}
	public void checkToSwitchLevel()
	{
		if(scoreSun*50>=level.setScoreLimitness() && bullets.size()==0)// temporary bug fixing
		{
			clearScore();
			level.gameLevel++;
		}
	}
	public void delete()             {removeSun(tempSun);}

	public void onClickSun() {
			for (int i=0; i<sun.size(); i++) {
				if (checkSunMouse(sun.get(i)) == true ) {
					sun.remove(i);
					scoreSun+=1;
				}
			}
	}
	public int printscore ()       {return scoreSun*50;}
	public void clearScore()        {scoreSun = 0;}
	public boolean checkSunMouse (Sun sun) {
		double x = Play.getShooter().getxPos();
		double y = Play.getShooter().getyPos();
		if (y >= sun.yPos -30  && y <= sun.yPos + 77 && x <= sun.xPos + 56 && x >= sun.xPos -100)
		return true;
		else
		return false;
	}

	///////////////Check Game to GameOver ////////////////////
	public void checkGame(StateBasedGame sbg,double x) {
			if(x<165)
			{
				zombies.clear();
				bullets.clear();
				sun.clear();
				clearScore();
				sbg.getState(2);
				sbg.enterState(2);
				level.gameLevel=1;
			}
	}
	
	public ArrayList<Zombies> getZombies() {return zombies;}
//	public void setZombies(ArrayList<Zombies> zombies) {PlayControl.zombies = zombies;}
}
