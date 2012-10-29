package gui02_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Clock extends JFrame{
	
	MyPanel panel;
	
	Clock(){
		super("clock");
		int width = 400;
		int height = 100;
		super.setSize(width, height);
		super.setBackground(new Color(100, 200, 200));
		
		panel = new MyPanel();
		this.getContentPane().add(panel);
	
		Locale.setDefault(Locale.ENGLISH);
	
		Timer timer = new Timer();
		TimerTask timerTask = new Task();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	class MyPanel extends JPanel{
		MyTime myTime;
		
		int drawPointX = 20;
		int drawPointY = 20;
		
		Font font;
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		Color fontColor = Color.BLACK;
		Color bgColor = Color.GREEN;
		
		public MyPanel(){
			myTime = new MyTime();
			font = new Font(myTime.time, Font.PLAIN, fontSize);
			super.setBackground(bgColor);
		}
		
		public void setDrawPoint(int x, int y){
			drawPointX = x;
			drawPointY = y;
		}
		
		public void setFontColor(Color color){
			this.fontColor = color;
		}
		
		public void setFontKind(int fontKind){
			myTime = new MyTime();
			this.font = new Font(myTime.time, fontKind, fontSize);
		}
		
		public void setFontSize(int fontSize){
			myTime = new MyTime();
			this.font = new Font(myTime.time, fontKind, fontSize);
		}
		
		public void setBackGroundColor(Color color){
			this.bgColor = color;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			super.setBackground(bgColor);
			myTime = new MyTime();
      	    g.setFont(font);
			g.setColor(fontColor);
			g.drawString(myTime.time, drawPointX, drawPointY);
		}
	}
	
	class MyTime{
		String time;
		
		MyTime(){
			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo" ));
			time = sdf.format(date.getTime());
		}
	}
	
	   class Task extends TimerTask{

		@Override
			public void run() {
			    panel.repaint();
			}
		   
	   } 
	   
		public static void main(String[] args){
			Clock clock = new Clock();
		}
	
}
