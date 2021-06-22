package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import Demension2D.Position;
import Map.Map;

public class Ball extends Objects{
	int r;
	public Map map;
	boolean boomEffect = false;
	boolean punctureEffect = false;
	public Ball(int r) {
		this.length = r;
		this.width = r;
		this.r = r;
	}
	public Ball(Map map,int r,Position p) {
		this.length = r*2;
		this.width = r*2;
		this.r =r;
		this.p = p;
		this.map=map;
	}
	
	
	@Override
	public void runRt() {
		// TODO Ball move
		update();
	}
	public boolean isBoomEffect() {
		return boomEffect;
	}
	public void setBoomEffect(boolean boomEffect) {
		this.boomEffect = boomEffect;
	}
	public boolean isPunctureEffect() {
		return punctureEffect;
	}
	public void setPunctureEffect(boolean punctureEffect) {
		this.punctureEffect = punctureEffect;
	}
	public void update() {
		if(getSpeed()!=0) {
			this.getPosition().setX(this.getPosition().getX()+this.getPosition().getDirX()*getSpeed());
			this.getPosition().setY(this.getPosition().getY()+this.getPosition().getDirY()*getSpeed());
			/*this.p.x +=(p.getDirX()*getSpeed());
			this.p.y +=(p.getDirY()*getSpeed());*/
		}
	}
	
	public int getR() {
		// TODO Auto-generated method stub
		return this.r;
	}
	public void setR(int r) {
		// TODO Auto-generated method stub
		this.r = r;
	}
	


}


	




