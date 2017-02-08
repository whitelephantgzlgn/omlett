package omlethegame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

public class Tava {
	
	public static final String TAVA = "res/tava.png";
	public static final String TAVA_YUMURTALI = "res/tava_yumurtali.png";
	private Image tava_image;
	private Graphics graph;
	private int tava_x,tava_y;
	private Ellipse collision_circle;
	
	public Tava() throws SlickException{
		tava_image = new Image(TAVA);
	}
	
	public Ellipse getCircle(){
		return this.collision_circle;
	}
	
	public void setGraphics(Graphics g1){
		g1 = this.graph;
	}
	
	public void setImage(String adress) throws SlickException{
		this.tava_image = new Image(adress);
	}
	
	public void setLocation(Graphics g1,int x, int y){
		tava_x = x;
		tava_y = y;
		tava_y--;
		if(tava_y < 300){
			tava_y = 370;
		}
		g1.drawImage(tava_image, tava_x - 50, tava_y - 10);
	}
	
	public void collisionDetector(){
		int tava_centerX = tava_x + (tava_image.getHeight() / 12);
		int tava_centerY = tava_y + (tava_image.getWidth() / 5);
		collision_circle = new Ellipse(tava_centerX, tava_centerY, 30,30);
	}
}
