package Studio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Map.Map;

public class TestGame {

	public static void main(String args[]) {
		MusicPlay.startBgm();		
		WindowMenu win = new WindowMenu();
		win.setVisible(true);
		do{
			System.out.println("广告位招租...等待玩家开始游戏...");
		}while(!win.gameOn) ;
		
		if (win.gameOn) {
			Map map = new Map();
			map.startGame();
			map.round1();
			map.UI();			         
			map.run();
			
			
			}
		
		
		}
	}

