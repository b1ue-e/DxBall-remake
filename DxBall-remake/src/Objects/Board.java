package Objects;

import Demension2D.Position;

import Map.Map;
import Studio.MusicPlay;

/**
 * 
 * @author b1ue-e
 * @see Board类控制板移动和考虑球和板碰撞情形
 */
public class Board extends Objects{
	public boolean isFire = false;
	public Map map;
	public Board(Map map,int length,int width,Position p) {
		this.p =p;
		this.length = length;
		this.width = width;
		this.map = map;
		setSpeed(5);
	}
	
	@Override
	public void runRt() {
		// TODO control the ball moving
		update();
		moveBall();
		BallBoardCollision();
	}
	public void update() {
		if(getSpeed()!=0) {
			this.getPosition().setX(this.getPosition().getX()+this.getPosition().getDirX()*this.getSpeed());
			this.getPosition().setY(this.getPosition().getY()+this.getPosition().getDirY()*this.getSpeed());
		}
	}
	public void moveBall() {
		if(getFire() != true) {
			//让球和板一起移动
			Position BoardComBallPosition = new Position(this.getPosition().getX(),this.getPosition().getY());
			BoardComBallPosition.setY(BoardComBallPosition.getY()-map.ball.getR()-this.width/2);
			map.ball.setPosition(BoardComBallPosition);
		}
		/*else if(this.getPosition().getX() >length/2) {
				this.getPosition().setX(this.getPosition().getX()*this.speed*this.getPosition().getDirX());
			}*/
		}
	public void BallBoardCollision() {
		//只要发生碰撞y方向即刻改变 一般来说碰到板会向上走
		boolean isCollision =false;
		if(map.ball.getPosition().getY() >= this.getPosition().getY()-map.ball.getR()-this.width/2 && Math.abs(map.ball.getPosition().getX() - this.getPosition().getX())<= (length/2+map.ball.getR())) 
			//map.ball.p.setDirY(1);
			isCollision = true;
		
		if(getFire()==true&&isCollision == true) {
			map.ball.getPosition().setDirY(-1);
			MusicPlay.startMusic("bounce");
			map.ball.setSpeed(3);
			map.ball.setPunctureEffect(false);
		}
		if(map.ball.getPosition().getX() >= this.getPosition().getX() && isCollision == true) {
			map.ball.getPosition().setDirX(1);
		}else if(isCollision == true) {
			map.ball.getPosition().setDirX(-1);
		}
	}
	//fire or not
	public void setFire() {
		map.ball.setSpeed(3);
		map.ball.getPosition().setDirX(1);
		map.ball.getPosition().setDirY(-1);
		this.isFire = true;
	}
	public boolean getFire() {
		return isFire;
	}
	

	
	
	
}

