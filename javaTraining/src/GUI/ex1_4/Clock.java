package GUI.ex1_4;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import GUI.ex1_3.MyFrame;

public class Clock extends Frame {
	int width = 400;
	int height = 100;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	MyMenuBar myMenu = new MyMenuBar(this);
	Clock() {
		super("時計");
		super.setSize(width, height);

		// 定期的にTimerTask.run()を実行
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		
		add(myMenu);

		addWindowListener(new ClosingWindowListener());
		super.setVisible(true);

	}

	public static void main(String[] args) {
		Clock clock = new Clock();
	}

	public void setBackGround(Color color) {
		super.setBackground(color);
	}

	public void setSize(int w, int h) {
		super.setSize(w, h);
	}

	class MyTime {
		String time;

		MyTime() {
			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy MMM/d (EEE) HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
			time = sdf.format(date.getTime());
		}
	}

	class MyDialog extends Dialog implements ItemListener, ActionListener{
		Frame frame;
		MyMenuBar myMenu;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		List lst1;
		List fontList;
		List fontSizeList;
		String[] fs;
		Button okButton;
		Button cancelButton;
		
		public MyDialog(Frame owner, MyMenuBar myMenu) {
			super(owner);
			this.frame = owner;
			this.myMenu = myMenu;
			
			fontList = new List(4, false);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			fs = ge.getAvailableFontFamilyNames();
			for (int i = 0; i < fs.length; i++ ) {
				fontList.add(fs[i]);
			}
			
			fontSizeList = new List(4, false);
			fontSizeList.add("10");
			fontSizeList.add("20");
			fontSizeList.add("30");
			
			lst1 = new List(4, false);
			lst1.add("フォント");
			lst1.add("フォントサイズ");
			lst1.add("文字色");
			lst1.add("背景色");
			add(0, 0, 1, 1, lst1, gbl, gbc);
			
			okButton = new Button("O.K.");
			cancelButton = new Button("Cancel");
			
			add(2, 4, 1, 1, okButton, gbl, gbc);
			add(3, 4, 1, 1, cancelButton, gbl, gbc);

			lst1.addItemListener(this);
     		fontList.addItemListener(this);
			
     		lst1.addActionListener(this);
     		fontList.addActionListener(this);
     		
			okButton.addActionListener(this);
			cancelButton.addActionListener(this);
			addWindowListener(new ClosingWindowListener());
			
			setLayout(gbl);
			setSize(400, 150);
			setResizable(false);
			setVisible(true);
		}

		private void add(int x, int y, int w, int h, Component o,
			GridBagLayout gb, GridBagConstraints gc) {
			gc.gridx = x;
			gc.gridy = y;
			gc.gridwidth = w;
			gc.gridheight = h;
			gb.setConstraints(o, gc);
			add(o);
		}

		class ClosingWindowListener extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}

		public void actionPerformed(ActionEvent e) {		
			if(e.getSource().equals(okButton)){
				if(lst1.getSelectedItem().equals("フォント")){

				}
			}
			if(e.getSource().equals(cancelButton)){
				
			}
		}

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource().equals(lst1)){
				if(lst1.getSelectedItem().equals("フォント")){
					add(1, 0, 1, 1, fontList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("フォントサイズ")){
					System.out.println("c");
					add(1, 0, 1, 1, fontSizeList, gbl, gbc);
				}
			}
			if(e.getSource().equals(fontList)){
				for(int i = 0; i < fs.length; i++){
					if(fontList.getSelectedItem().equals(fs[i])){
						System.out.println("d");
						Font f = new Font(fs[i], Font.PLAIN, 10);
						this.myMenu.setFont(f);
					}
				}
			}
			else if(e.getSource().equals(fontList)){
					System.out.println("d");
					int fontSize = Integer.parseInt(fontSizeList.getSelectedItem());
					Font f = new Font(fs[22], Font.PLAIN, fontSize);
					this.myMenu.setFont(f);
			}
			setLayout(gbl);
			setVisible(true);
		}
	}

	class MyMenuBar extends Panel {
		private PopupMenu popup;

		Font font;
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		Color fontColor;

		int drawPointX = 20;
		int drawPointY = 20;

		int numOfItems = 4;

		Clock frame;

		MyMenuBar(Clock frame) {
			this.frame = frame;
			MyTime myTime = new MyTime();
			font = new Font(myTime.time, fontKind, fontSize);
			fontColor = Color.BLACK;

			popup = new PopupMenu();

//			MyDialog dialog = new MyDialog(this.frame, this);
			
			Menu mn = new Menu("メニュー");
			Menu mn1 = new Menu("プロパティ");
			Menu mnf = new Menu("フォント");
			Menu mnbg = new Menu("背景");

			// mn1.add(mnf);
			// mn1.add(mnbg);
			//
			// Menu mnfk = new Menu("フォントの種類");
			// Menu mnfs = new Menu("フォントサイズ");
			// Menu mnfc = new Menu("文字色");
			//
			// mnf.add(mnfk);
			// mnf.add(mnfs);
			// mnf.add(mnfc);
			//
			// MenuItem mifk1 = new MenuItem("標準");
			// MenuItem mifk2 = new MenuItem("太字");
			// MenuItem mifk3 = new MenuItem("イタリック");
			// mnfk.add(mifk1);
			// mnfk.add(mifk2);
			// mnfk.add(mifk3);
			//
			// MenuItem mifs1 = new MenuItem("25");
			// MenuItem mifs2 = new MenuItem("50");
			// MenuItem mifs3 = new MenuItem("75");
			// mnfs.add(mifs1);
			// mnfs.add(mifs2);
			// mnfs.add(mifs3);
			//
			// MenuItem mifc1 = new MenuItem("黒");
			// MenuItem mifc2 = new MenuItem("白");
			// mnfc.add(mifc1);
			// mnfc.add(mifc2);
			//
			// MenuItem mibg1 = new MenuItem("赤");
			// MenuItem mibg2 = new MenuItem("緑");
			// MenuItem mibg3 = new MenuItem("黄");
			// mnbg.add(mibg1);
			// mnbg.add(mibg2);
			// mnbg.add(mibg3);
			//
			// mn.add(mn1);
//			popup.add(mn);

			add(popup);
			MyDialog dialog = new MyDialog(this.frame, this);
			// mifk1.addActionListener(new ActionAdapter());
			// mifk2.addActionListener(new ActionAdapter());
			// mifk3.addActionListener(new ActionAdapter());
			//
			// mifs1.addActionListener(new ActionAdapter());
			// mifs2.addActionListener(new ActionAdapter());
			// mifs3.addActionListener(new ActionAdapter());
			//
			// mifc1.addActionListener(new ActionAdapter());
			// mifc2.addActionListener(new ActionAdapter());
			//
			// mibg1.addActionListener(new ActionAdapter());
			// mibg2.addActionListener(new ActionAdapter());
			// mibg3.addActionListener(new ActionAdapter());

		}

		public void setFontKind(int fontKind) {
			MyTime myTime = new MyTime();
			this.fontKind = fontKind;
			this.font = new Font(myTime.time, fontKind, fontSize);
		}

		public void setFontSize(int fontSize) {
			MyTime myTime = new MyTime();
			this.fontSize = fontSize;
			this.font = new Font(myTime.time, fontKind, fontSize);
		}

		public void setFontColor(Color color) {
			this.fontColor = color;
		}

		public void setDrawPoint(int x, int y) {
			this.drawPointX = x;
			this.drawPointY = y;
		}

		public void paint(Graphics g) {
			Image bufi = createImage(width, height);
			Graphics bufg = bufi.getGraphics();
			super.paint(g);
			MyTime myTime = new MyTime();
			bufg.setFont(font);
			bufg.setColor(fontColor);
			bufg.drawString(myTime.time, drawPointX, drawPointY);
			g.drawImage(bufi, drawPointX, drawPointY, this);
		}

		public void update(Graphics g) {
			paint(g);
		}

		class ActionAdapter implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand() == "標準") {
					myMenu.setFontKind(Font.PLAIN);
				}

				if (e.getActionCommand() == "太字") {
					myMenu.setFontKind(Font.BOLD);
				}
				if (e.getActionCommand() == "イタリック") {
					myMenu.setFontKind(Font.ITALIC);
				}

				if (e.getActionCommand() == "25") {
					myMenu.setDrawPoint(20, 20);
					setSize(400, 100);
					myMenu.setFontSize(25);
				}

				if (e.getActionCommand() == "50") {
					myMenu.setDrawPoint(50, 50);
					setSize(700, 150);
					myMenu.setFontSize(50);
				}

				if (e.getActionCommand() == "75") {
					myMenu.setDrawPoint(75, 75);
					setSize(1200, 200);
					myMenu.setFontSize(100);
				}

				if (e.getActionCommand() == "黒") {
					myMenu.setFontColor(Color.BLACK);
				}

				if (e.getActionCommand() == "白") {
					myMenu.setFontColor(Color.WHITE);
				}

				if (e.getActionCommand() == "赤") {
					setBackGround(Color.RED);
				}
				if (e.getActionCommand() == "緑") {
					setBackGround(Color.GREEN);
				}
				if (e.getActionCommand() == "黄") {
					setBackGround(Color.YELLOW);
				}
			}
		}

	}

	class Task extends TimerTask {

		public void run() {
			myMenu.repaint();
		}

	}

	class ClosingWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}