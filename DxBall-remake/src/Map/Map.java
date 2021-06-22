package Map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import Demension2D.Position;
import Objects.*;
import Studio.MusicPlay;
import Studio.TestGame;

public class Map implements KeyListener{
    public static int count=0;
    int blockNum1=10000;
    int blockNum2=10000;
    int blockNum3=10000;
    public static boolean round1Over=false;
    public boolean round2Over=false;
    public boolean round3Over=false;
    
	private JFrame frame;
	private Panels panel;
	//private ArrayList<Wall> walls = new ArrayList<Wall>();
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<SpeedUpBox> speedUpBox = new ArrayList<SpeedUpBox>();
	private ArrayList<PunctureBox> punctureBox = new ArrayList<PunctureBox>();
	private	ArrayList<BoomBox> boomBox = new ArrayList<BoomBox>();
	private ArrayList<BallSizeExchangeBox> ballSizeExchangeBox = new ArrayList<BallSizeExchangeBox>();
	private ArrayList<BoardLengthExchangeBox> boardLengthExchangeBox = new ArrayList<BoardLengthExchangeBox>();
	//private ArrayList<Drop> drops = new ArrayList<Drop>();
	public Ball ball;
	public Board board;
	public Wall wall;
	public ArrayList<Objects> gameBody = new ArrayList<Objects>();
	private ArrayList<Objects> destroyList = new ArrayList<Objects>();
	private ArrayList<Objects> addList = new ArrayList<Objects>();
	public int top,bottom,left,right;
	public boolean gameOver = false;
	int LocationX=0;
	int LocationY=0;
	public void UI() {
		
		this.frame = new JFrame("DxBall-remake");
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);      
        this.frame.setSize(1420,900);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        LocationX=screenWidth / 2 - 1420/ 2;
        LocationY=screenHeight / 2 - 900/ 2;
        this.frame.setLocation(LocationX,LocationY);
        this.bottom = LocationY+900;
        this.panel = new Panels();  
        this.frame.add(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	}

	public void startGame() {
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高		
		//Position ballPosition=new Position(screenWidth / 2-400,screenHeight / 2+900/2-80-100);
        Position ballPosition=new Position(screenWidth / 2,screenHeight / 2+900/2-35-100-40);
        this.ball=new Ball(this,20,ballPosition);
		//Position boardPosition=new Position(screenWidth / 2-400,screenHeight / 2+900/2-40-100);
		Position boardPosition=new Position(screenWidth / 2-150-200,screenHeight / 2+900/2-35-100);
		this.board=new Board(this,200,35,boardPosition);
		this.gameBody.add(ball);
		this.gameBody.add(board);
		
		//墙体
		this.wall = new Wall(this,1420,900,new Position(710,450));
		this.gameBody.add(wall);
	}
	public void round1() {
		blockNum1=0;
		for (int i=1; i<24;i+=2) {
			for(int j=1; j<16;j+=3) {
				this.blocks.add(new Block(this, 80, 30, new Position(i*60-10, j*30)));
				blockNum1++;
			}
		}
		this.gameBody.addAll(blocks);
		/*while(round2Over) {
			round2();
		}*/
		/*if(round1Over==true&&round2Over==false) {
			round2();	
	}*/
	}
public void round2() {
		blockNum2=0;
		this.gameBody.removeAll(blocks);
		for (int i=1; i<25;i++) {
			for(int j=1; j<20;j++) {
				this.blocks.add(new Block(this, 80, 30, new Position(i*60, j*30)));
				blockNum2++;
			}
		}
		this.gameBody.addAll(blocks);
		/*while(round2Over) {
			round3();
		}*/
		
	}
public void round3() {
	blockNum3=0;
	this.gameBody.removeAll(blocks);
	for (int i=25; i>1;i-=10) {
		for(int j=20; j>1;j-=20) {
			this.blocks.add(new Block(this, 80, 30, new Position(i*60, j*30)));
			blockNum3++;
		}
		}
	this.gameBody.addAll(blocks);
	while(round3Over) {
	System.out.println("Finishied!!!");
}}
	public void isGameOver() {
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
		//TODO 球碰到下边界游戏结束
        if(this.ball.getPosition().getY() > this.board.getPosition().getY()+20) {
			this.gameOver=true;
			MusicPlay.stopBgm(MusicPlay.clip1);
        MusicPlay.startMusic("die");
        
        }       
	}
	
	public void destroy(Objects body) {
    	this.destroyList.add(body);
    	if(body instanceof Block&&((body instanceof MagicBox)==false))count++;
    	if(count==blockNum1) {
    		System.out.println("闯关成功！");
    		round1Over=true;
    	}if(count==blockNum1+blockNum2) {
    		System.out.println("闯关成功！");
    		round2Over=true;
    	}if(count==blockNum1+blockNum2+blockNum3) {
    		System.out.println("闯关成功！");
    		round3Over=true;
    	}
    	  
    	MusicPlay.startMusic("button");
    }    
    public void add(Objects body) {
    	this.addList.add(body);
    }
    
	public void run() {    
        this.frame.addKeyListener(this);
        //主控循环
        while(!this.gameOver) {
       	//处理游戏对象的生成
        	this.gameBody.addAll(addList);
        	this.addList.clear();
        	//处理游戏对象的destroy
        	this.gameBody.removeAll(destroyList);
        	this.destroyList.clear();
        	this.isGameOver();
        	//每个游戏对象调用runPerTick()函数
        	for(Objects body:this.gameBody) {
        		body.runRt();
        	}        	
        	//System.out.println("round1Over="+round1Over+"   round2Over="+round2Over+"   round3Over="+round3Over);
        	//将所有游戏对象绘制出来
        	this.panel.setGameBodyList(this.gameBody);
        	this.panel.repaint();     	
        	//短暂休眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.board.getPosition().setDirX(-1);
			break;
		case KeyEvent.VK_RIGHT:
			this.board.getPosition().setDirX(1);
			break;
		case KeyEvent.VK_SPACE:
			if (!this.board.getFire())
				this.board.setFire();
			break;
		default:
			break;
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (this.board.getPosition().getDirX() == -1)
				this.board.getPosition().setDirX(0);
			break;
		case KeyEvent.VK_RIGHT:
			if (this.board.getPosition().getDirX() == 1)
				this.board.getPosition().setDirX(0);
			break;
		default:
			break;
		}
	}
	//画出所有对象
	static class Panels extends JPanel{
		Toolkit kit = Toolkit.getDefaultToolkit(); 
	    Dimension screenSize = kit.getScreenSize(); 
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height; 
		private static final long serialVersionUID = 1L;
		static Image bjImg;
		static Toolkit tk = Toolkit.getDefaultToolkit();
		static {
			bjImg = tk.createImage(Panels.class.getClassLoader().getResource("1.jpg"));
		}
		ArrayList<Objects> gameBodyList = new ArrayList<Objects>();	
		public void setGameBodyList(ArrayList<Objects> gameBodyList) {
			this.gameBodyList = gameBodyList;
		}
		
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(bjImg, 0, 0,1420,900, null);
	        //设置画笔颜色
	        g.setColor(Color.RED);
	        g.setFont(new Font("微软雅黑", 20, 50));
	        g.drawString("得分："+count,1200,100);
	        g.setColor(Color.GREEN);
	        if(round1Over==true) {
	        	g.drawString("恭喜通关！！！",600,400);
	        	
	        }
	        //循环画出所有游戏对象
	        for(Objects body:gameBodyList) {
	        	int x;
	        	int y;
	        		if(body instanceof Block) {
	        			g.setColor(Color.PINK);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getLength(), body.getWidth());
	        		}
	        		else if(body instanceof BoomBox) {
	        			g.setColor(Color.WHITE);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getWidth(), body.getWidth());
	        		}else if(body instanceof PunctureBox) {
	        			g.setColor(Color.GRAY);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getWidth(), body.getWidth());
	        		}else if(body instanceof SpeedUpBox) {
	        			g.setColor(Color.MAGENTA);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getWidth(), body.getWidth());
	        		}
	        		else if(body instanceof Board) {
	        			g.setColor(Color.ORANGE);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getLength(), body.getWidth());
	        		}
	        		else if(body instanceof Ball) {
	        		x = body.getPosition().getX()-body.getR();
	        		y = body.getPosition().getY()-body.getR();
	        		g.fillOval(x, y, body.getR()*2, body.getR()*2);
	        		}
	        		else if(body instanceof BallSizeExchangeBox) {
	        			g.setColor(Color.BLACK);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getWidth(), body.getWidth());
	        		}
	        		else if(body instanceof BoardLengthExchangeBox) {
	        			g.setColor(Color.RED);
	    				x = body.getPosition().getX() - body.getLength() / 2;
	    				y = body.getPosition().getY() - body.getWidth() / 2;
	    				g.fillRect(x, y, body.getWidth(), body.getWidth());
	        		}
	        	

	        }

	    }
	}
	public void boomdestroy(Block block) {
		// TODO Auto-generated method stub
		for(Objects body :gameBody) {
			if(body instanceof Block) {
				if(Math.abs(body.getPosition().getX()-block.getPosition().getX()) <= 200 && Math.abs(body.getPosition().getY() - block.getPosition().getY())<=200) {
					destroy(body);
				}
			}
		}
	}	
}
   