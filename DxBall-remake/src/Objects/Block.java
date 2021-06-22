package Objects;

import java.util.Random;

import Demension2D.Position;
import Map.Map;
import Studio.MusicPlay;

public class Block extends Objects{
	public Map map;
	public Ball ball;
	public Board board;
	public Block(Map map ,int length,int width,Position p){
		this.length = length;
		this.width = width;
		this.p = p;
		this.map = map;
	}

	@Override
	public void runRt() {
		// TODO Auto-generated method stub
		/*if(map.round1Over==true&&map.round2Over==false) {
			map.round2();	
	}*/
		BallBockCollision();
	}
	public void BallBockCollision() {
		boolean isCollision = false;
		if(!map.ball.isBoomEffect() && !map.ball.isPunctureEffect()) {
			if(Math.abs(map.ball.getPosition().getY()-this.getPosition().getY()) <= width/2+map.ball.getR() && Math.abs(map.ball.getPosition().getX() - this.getPosition().getX())<= (length/2+map.ball.getR()) ) {
				isCollision = true;
				map.ball.getPosition().setDirY(1);
				destroy(this);
			}
			if(map.ball.getPosition().getX()>= this.getPosition().getX() && isCollision == true) {
				map.ball.getPosition().setDirX(1);
			}else if(isCollision == true) {
				map.ball.getPosition().setDirX(-1);
				
			}
		}else if(map.ball.isBoomEffect()) {
			/**/if(Math.abs(map.ball.getPosition().getY()-this.getPosition().getY()) <= (width/2+map.ball.getR()) && Math.abs(map.ball.getPosition().getX() - this.getPosition().getX())<= (length/2+map.ball.getR())) {
				map.boomdestroy(this);
				isCollision = true;
				map.ball.getPosition().setDirY(1);
				MusicPlay.startMusic("boom");
				map.ball.setBoomEffect(false);
			}
			if(map.ball.getPosition().getX()>= this.getPosition().getX() && isCollision == true) {
				map.ball.getPosition().setDirX(1);
			}else if(isCollision == true) {
				map.ball.getPosition().setDirX(-1);
				
			}
			
		}else if(map.ball.isPunctureEffect()) {
			if(Math.abs(map.ball.getPosition().getY()-this.getPosition().getY()) <= +width/2+map.ball.getR() && Math.abs(map.ball.getPosition().getX() - this.getPosition().getX())<= (length/2+map.ball.getR()) ) {
				isCollision = true;
				destroy(this);
			}
		}
	}
	public void dropBoomBox() {
		this.map.add(new BoomBox(this.map,this.width,this.width,this.getPosition()));
	}
	public void dropPunctureBox() {
		this.map.add(new PunctureBox(this.map,this.width,this.width,this.getPosition()));
	}
	public void dropSpeedUpBox() {
		this.map.add(new SpeedUpBox(this.map,this.width,this.width,this.getPosition()));
	}
	public void dropBallSizeExchangeBox() {
		this.map.add(new BallSizeExchangeBox(this.map,this.width,this.width,this.getPosition()));
	}
	public void dropBoardLengthExchangeBox() {
		this.map.add(new BoardLengthExchangeBox(this.map,this.width,this.width,this.getPosition()));
	}

	public void destroy(Objects obj) {
		// TODO Auto-generated method stub
		Random r = new Random();
		if(r.nextInt(200) <=10) dropBoomBox();
		else if(r.nextInt(200) <=20) dropPunctureBox();
		else if(r.nextInt(200)<=30) dropSpeedUpBox();
		else if(r.nextInt(200) <= 40) dropBallSizeExchangeBox();
		else if(r.nextInt(200) <=50) dropBoardLengthExchangeBox();
		map.destroy(this);
	}
}