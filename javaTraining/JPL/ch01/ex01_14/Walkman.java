package ch01.ex01_14;

import java.io.File;

public class Walkman {
	
	private static final int NUM_OF_TERMINAL = 1;
	
	private static int[] terminalID;
	
	static{
		
		terminalID = new int[NUM_OF_TERMINAL];
		
		for(int i=0; i<NUM_OF_TERMINAL; i++){
			
			terminalID[i] = i;
			
		}
		
	}
	
	protected int musicVolumeLevel;
	
	public int getMusicVolumeLevel(){
		
		return musicVolumeLevel;
		
	}
	
	public void playMusic(File musicFile){
		
		
		
	}
	
	public void setMusicVolumeLevel(int musicVolumeLevel){
		
		this.musicVolumeLevel = musicVolumeLevel;
		
	}
	
}
