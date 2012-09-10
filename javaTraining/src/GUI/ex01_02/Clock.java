package GUI.ex01_02;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Frame{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	MyCanvas canvas = new MyCanvas();
	int width;
	int height;
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	
	Clock(){
		super("���v");
		super.setSize(400, 100);
		
		//���I��TimerTask.run()�����s
	    timer.scheduleAtFixedRate(timerTask, 0, 1000);
	    
		add(canvas);

		setMenuBar(new MyMenuBar());

		addWindowListener(new ClosingWindowListener());
		super.setVisible(true);
		
	}

	public void setSize(int w, int h){
		super.setSize(w, h);
	}
	
	public static void main(String[] args){
		Clock clock = new Clock();
	}
	
	class MyCanvas extends Canvas{
		
		Font font;
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		Color fontColor;
		
		int drawPointX = 20;
		int drawPointY = 20;
		
		MyCanvas(){
			MyTime myTime = new MyTime();
			font = new Font(myTime.time, fontKind, fontSize);
			fontColor = Color.BLACK;
		}
		
		public void setFontKind(int fontKind){
			MyTime myTime = new MyTime();
	        this.fontKind = fontKind;
			this.font = new Font(myTime.time, fontKind, fontSize);
		}
		
		public void setFontSize(int fontSize){
			MyTime myTime = new MyTime();
			this.fontSize = fontSize;
			this.font = new Font(myTime.time, fontKind, fontSize);
		}
		
		public void setFontColor(Color color){
			this.fontColor = color;
		}
		
		public void setDrawPoint(int x, int y){
			this.drawPointX = x;
			this.drawPointY = y;
		}
		
		public void paint(Graphics g){
			MyTime myTime = new MyTime();
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
	
	class MyMenuBar extends MenuBar{
		MyMenuBar(){
			Menu mn = new Menu("���j���[");
			Menu mn1 = new Menu("�v���p�e�B");
			Menu mnf = new Menu("�t�H���g");
			Menu mnbg = new Menu("�w�i");

			mn1.add(mnf);
			mn1.add(mnbg);
			
			Menu mnfk = new Menu("�t�H���g�̎��");
			Menu mnfs = new Menu("�t�H���g�T�C�Y");
			Menu mnfc = new Menu("�����F");
			
			mnf.add(mnfk);
			mnf.add(mnfs);
			mnf.add(mnfc);
			
			MenuItem mifk1 = new MenuItem("�W��");
			MenuItem mifk2 = new MenuItem("����");
			MenuItem mifk3 = new MenuItem("�C�^���b�N");
			mnfk.add(mifk1);
			mnfk.add(mifk2);
			mnfk.add(mifk3);
			
			MenuItem mifs1 = new MenuItem("25");
			MenuItem mifs2 = new MenuItem("50");
			MenuItem mifs3 = new MenuItem("75");
			mnfs.add(mifs1);
			mnfs.add(mifs2);
			mnfs.add(mifs3);
			
			MenuItem mifc1 = new MenuItem("��");
			MenuItem mifc2 = new MenuItem("��");
			mnfc.add(mifc1);
			mnfc.add(mifc2);
			
			MenuItem mibg1 = new MenuItem("��");
			MenuItem mibg2 = new MenuItem("��");
			MenuItem mibg3 = new MenuItem("��");
			mnbg.add(mibg1);
			mnbg.add(mibg2);
			mnbg.add(mibg3);
			
			mn.add(mn1);
			add(mn);
			
			mifk1.addActionListener(new ActionAdapter());
			mifk2.addActionListener(new ActionAdapter());
			mifk3.addActionListener(new ActionAdapter());
			
			mifs1.addActionListener(new ActionAdapter());
			mifs2.addActionListener(new ActionAdapter());
			mifs3.addActionListener(new ActionAdapter());
			
			mifc1.addActionListener(new ActionAdapter());
			mifc2.addActionListener(new ActionAdapter());
			
			mibg1.addActionListener(new ActionAdapter());
			mibg2.addActionListener(new ActionAdapter());
			mibg3.addActionListener(new ActionAdapter());
			
		}
		
		class ActionAdapter implements ActionListener{
		    public void actionPerformed(ActionEvent e) {

		        if (e.getActionCommand() == "�W��"){
		        	canvas.setFontKind(Font.PLAIN);
		        }

		        if (e.getActionCommand() == "����"){
		        	canvas.setFontKind(Font.BOLD);
		        }
		        if (e.getActionCommand() == "�C�^���b�N"){
		        	canvas.setFontKind(Font.ITALIC);
		        }
		        
		        if (e.getActionCommand() == "25"){
		        	canvas.setDrawPoint(20, 20);
		        	setSize(400, 100);
		        	canvas.setFontSize(25);
		        }
		        
		        if (e.getActionCommand() == "50"){
		        	canvas.setDrawPoint(50, 50);
		        	setSize(700, 150);
		        	canvas.setFontSize(50);
		        }
		        
		        if (e.getActionCommand() == "75"){
		        	canvas.setDrawPoint(75, 75);
		        	setSize(1200, 200);
		        	canvas.setFontSize(100);
		        }
		        
		        if(e.getActionCommand() == "��"){
		        	canvas.setFontColor(Color.BLACK);
		        }
		        
		        if(e.getActionCommand() == "��"){
		        	canvas.setFontColor(Color.WHITE);
		        }
		        
		        if(e.getActionCommand() == "��"){
		        	setBackGround(Color.RED);
		        }
		        if(e.getActionCommand() == "��"){
		        	setBackGround(Color.GREEN);
		        }
		        if(e.getActionCommand() == "��"){
		        	setBackGround(Color.YELLOW);
		        }
		   }
		}
		
	}
	
	class Task extends TimerTask{
		
		public void run() {
		    canvas.repaint();
		}
		   
	} 
		
	class ClosingWindowListener extends WindowAdapter{      
		public void windowClosing(WindowEvent e){
			System.exit(0);      
		}   
	}

	public void setBackGround(Color color) {
		super.setBackground(color);
	}
		
}
