package Studio;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
		public static Clip clip1;

	public static void startBgm() {
		try {
			File musicPath = new File("src\\bgm.wav");
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip1=clip;
				clip1.open(audioInput);
				clip1.start();		
				clip1.loop(Clip.LOOP_CONTINUOUSLY);
				System.out.println("bgm≤•∑≈÷–...");
			} else {
				System.out.println("bgm≤•∑≈ ß∞‹£°");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void stopBgm(Clip clip1) {
		try {
				clip1.stop();
			} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void startMusic(String name) {
		try {
			File musicPath = new File("src\\"+name+".wav");

			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
