package GUI.ex1_3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame extends Frame{
	int width = 400;
	int height = 100;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	MyMenuBar myMenu = new MyMenuBar(this);

	MyFrame(){
		super("時計");
		super.setSize(width, height);
		
		//定期的にTimerTask.run()を実行
	    timer.scheduleAtFixedRate(timerTask, 0, 1000);
	  
	    add(myMenu);
		
		addWindowListener(new ClosingWindowListener());
		setUndecorated(true);
		addMouseMotionListener((MouseMotionListener) new MouseAdapter(this));
		super.setVisible(true);
		
	}
	
	public void setBackGround(Color color) {
		super.setBackground(color);
	}
	
	public void setSize(int w, int h){
		super.setSize(w, h);
	}
	
	class MouseAdapter implements MouseListener, MouseMotionListener{
		MyFrame frame;
		MyMenuBar panel;
		int x;
		int y;
		
		public MouseAdapter(MyMenuBar panel, MyFrame frame){
			this.panel = panel;
			this.frame = frame;
		}
		
		public MouseAdapter(MyFrame frame){
			this.frame = frame;
		}
		
		public void mouseDragged(MouseEvent e) {
//			System.out.println("drag");
//			MyFrame myFrame = new MyFrame();
//			MyFrame myFrame = new MyFrame();
//			loc = myFrame.getLocation(loc);
//			int x = loc.x - start.getX() + me.getX();
//			int y = loc.y - start.getY() + me.getY();
//			myFrame.setLocation(e.getX(), e.getY());
		}
		
	    public void mouseReleased(MouseEvent e){
//	    	MyFrame newFrame = new MyFrame();
//	    	newFrame.setLocation(e.getX(), e.getY());
	    	frame.setLocation(e.getX(), e.getY());
	    	try {
	    		//this.frame.remove(panel);
//				panel.setVisible(false);
				//this.frame.setVisible(false);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	
		public void mouseMoved(MouseEvent e) {
//			System.out.println("m");
//			MyFrame myFrame = new MyFrame();
//			loc = myFrame.getLocation(loc);
//			int x = loc.x - start.getX() + me.getX();
//			int y = loc.y - start.getY() + me.getY();
//			myFrame.setLocation(e.getX(), e.getY());
		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		    if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON1_MASK) != 0) {
		    	System.out.println("左");
		    }
		    else if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON3_MASK) != 0) {
		    	System.out.println("右");
		    	panel.popup.show(panel, e.getX(), e.getY());
		    }
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
	
	class MyMenuBar extends Panel{
		private PopupMenu popup;
		
		Font font;
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		Color fontColor;
		
		int drawPointX = 20;
		int drawPointY = 20;
		
		MyFrame frame;
		
		MyMenuBar(MyFrame frame){
			this.frame = frame;
			MyTime myTime = new MyTime();
			font = new Font(myTime.time, fontKind, fontSize);
			fontColor = Color.BLACK;
			
			popup = new PopupMenu();
			
			Menu mn = new Menu("メニュー");
			Menu mn1 = new Menu("プロパティ");
			Menu mnf = new Menu("フォント");
			Menu mnbg = new Menu("背景");

			mn1.add(mnf);
			mn1.add(mnbg);
			
			Menu mnfk = new Menu("フォントの種類");
			Menu mnfs = new Menu("フォントサイズ");
			Menu mnfc = new Menu("文字色");
			
			mnf.add(mnfk);
			mnf.add(mnfs);
			mnf.add(mnfc);
			
			MenuItem mifk1 = new MenuItem("標準");
			MenuItem mifk2 = new MenuItem("太字");
			MenuItem mifk3 = new MenuItem("イタリック");
			mnfk.add(mifk1);
			mnfk.add(mifk2);
			mnfk.add(mifk3);
			
			MenuItem mifs1 = new MenuItem("25");
			MenuItem mifs2 = new MenuItem("50");
			MenuItem mifs3 = new MenuItem("75");
			mnfs.add(mifs1);
			mnfs.add(mifs2);
			mnfs.add(mifs3);
			
			MenuItem mifc1 = new MenuItem("黒");
			MenuItem mifc2 = new MenuItem("白");
			mnfc.add(mifc1);
			mnfc.add(mifc2);
			
			MenuItem mibg1 = new MenuItem("赤");
			MenuItem mibg2 = new MenuItem("緑");
			MenuItem mibg3 = new MenuItem("黄");
			mnbg.add(mibg1);
			mnbg.add(mibg2);
			mnbg.add(mibg3);
			
			mn.add(mn1);
			popup.add(mn);
			
			addMouseListener((MouseListener) new MouseAdapter(this, frame));
			addMouseMotionListener((MouseMotionListener) new MouseAdapter(this.frame));
			
			add(popup);
			
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
			Image bufi = createImage(width, height);
			Graphics bufg = bufi.getGraphics();
			super.paint(g);
			MyTime myTime = new MyTime();
      	    bufg.setFont(font);
			bufg.setColor(fontColor);
			bufg.drawString(myTime.time, drawPointX, drawPointY);
			g.drawImage(bufi, drawPointX, drawPointY, this);
		}
		
		public void update(Graphics g){
			paint(g);
		}
		
		class ActionAdapter implements ActionListener{
		    public void actionPerformed(ActionEvent e) {

		        if (e.getActionCommand() == "標準"){
		        	myMenu.setFontKind(Font.PLAIN);
		        }

		        if (e.getActionCommand() == "太字"){
		        	myMenu.setFontKind(Font.BOLD);
		        }
		        if (e.getActionCommand() == "イタリック"){
		        	myMenu.setFontKind(Font.ITALIC);
		        }
		        
		        if (e.getActionCommand() == "25"){
		        	myMenu.setDrawPoint(20, 20);
		        	setSize(400, 100);
		        	myMenu.setFontSize(25);
		        }
		        
		        if (e.getActionCommand() == "50"){
		        	myMenu.setDrawPoint(50, 50);
		        	setSize(700, 150);
		        	myMenu.setFontSize(50);
		        }
		        
		        if (e.getActionCommand() == "75"){
		        	myMenu.setDrawPoint(75, 75);
		        	setSize(1200, 200);
		        	myMenu.setFontSize(100);
		        }
		        
		        if(e.getActionCommand() == "黒"){
		        	myMenu.setFontColor(Color.BLACK);
		        }
		        
		        if(e.getActionCommand() == "白"){
		        	myMenu.setFontColor(Color.WHITE);
		        }
		        
		        if(e.getActionCommand() == "赤"){
		        	setBackGround(Color.RED);
		        }
		        if(e.getActionCommand() == "緑"){
		        	setBackGround(Color.GREEN);
		        }
		        if(e.getActionCommand() == "黄"){
		        	setBackGround(Color.YELLOW);
		        }
		   }
		}
		
	}
	
	class Task extends TimerTask{
		
		public void run() {
		    myMenu.repaint();
		}
		   
	} 
		
	class ClosingWindowListener extends WindowAdapter{      
		public void windowClosing(WindowEvent e){
			System.exit(0);      
		}   
	}

}