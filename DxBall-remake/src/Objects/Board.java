package Objects;

import Demension2D.Position;
import Map.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * @author b1ue-e
 * @see Board����ư��ƶ��Ϳ�����Ͱ���ײ����
 */
public class Board extends Objects{
	public boolean isFire = false;
	//Map map;
	public Board(Map map,int length,int width,Position p) {
		this.p =p;
		this.length = length;
		this.width = width;
		setSpeed(1);
	}

	@Override
	public void runRt() {
		// TODO control the ball moving
		moveBall();
		BallBoardCollision();
	}
	public void moveBall() {
		if(getFire() != true) {
			//����Ͱ�һ���ƶ�
			Position BoardComBallPosition = new Position(this.getPosition().x,this.getPosition().y);
			BoardComBallPosition.setY(BoardComBallPosition.getY()+(this.width+this.map.ball.r)/2);
			map.ball.setPosition(BoardComBallPosition);
		}else {
			//TODO С���ұ߽�
			if(this.getPosition().getX() >length/2 /*&& this.p.x <*/) {
				this.getPosition().setX(this.getPosition().getX()*this.speed*this.getPosition().getDirX());
			}
		}
	}
	public void BallBoardCollision() {
		//ֻҪ������ײy���򼴿̸ı� һ����˵�������������
		boolean isCollision =false;
		if(map.ball.getPosition().getY() == this.getPosition().getY()+(this.width+map.ball.getR())/2) {
			//map.ball.p.setDirY(1);
			isCollision = true;
		}
		if(isCollision == true) map.ball.getPosition().setDirY(1);
		if(map.ball.getPosition().getX() >= this.getPosition().getX() && isCollision == true) {
			map.ball.getPosition().setDirX(1);
		}else if(isCollision == true) {
			map.ball.getPosition().setDirX(-1);
		}
	}
	//fire or not
	public void setFire() {
		this.isFire = true;
	}
	public boolean getFire() {
		return isFire;
	}
	
	
	/*public void keyPressed(KeyEvent e) {	
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.p.setDirX(-1);
			break;
		case KeyEvent.VK_RIGHT:
			this.p.setDirX(1);
			break;
		case KeyEvent.VK_SPACE:
			if(!getFire())
				setFire();
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(this.p.getDirX() == -1) {
				this.p.setDirX(0);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(this.p.getDirX() == 1) {
				this.p.setDirX(0);
			}
			break;
		}
	}*/
	//д��panel
	
}

