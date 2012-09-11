package gui01_01;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Clock extends Frame{
	
	Panel panel;
	Label label;
	TextArea text;
	Calendar date = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
	
	Clock(){
		super("���v");
		int width = 400;
		int height = 100;
		super.setSize(width, height);
		super.setBackground(new Color(100, 200, 200));
		
		panel = new Panel();
		add(panel);
		
		label = new Label();
		panel.add(label);
		
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo" ));
		
		Timer timer = new Timer();
		TimerTask timerTask = new Task();
		//���I��TimerTask.run()�����s
	    timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		addWindowListener(new ClosingWindowListener());
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		Clock clock = new Clock();
	}
	
	   class ClosingWindowListener extends WindowAdapter{      
		   public void windowClosing(WindowEvent e){
			   System.exit(0);      
		   }   
	   }
	   
	   class Task extends TimerTask{

		@Override
			public void run() {
			    date = Calendar.getInstance();
				label.setText(sdf.format(date.getTime()));
			}
		   
	   } 
	
}
