package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Watch extends Frame{
	
	Panel panel;
	Label label;
	TextArea text;
	Calendar date = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
	
	Watch(){
		super("éûåv");
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
		//íËä˙ìIÇ…TimerTask.run()Çé¿çs
	    timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		addWindowListener(new ClosingWindowListener());
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		Watch watch = new Watch();
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
