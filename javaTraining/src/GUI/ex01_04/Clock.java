package GUI.ex1_4;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;

public class Clock extends Frame {
	int width = 400;
	int height = 100;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	MyMenuBar myMenu = new MyMenuBar(this);
	MyDialog myDialog;
	Property property = new Property(this);
	
	int bgRed;
	int bgGreen;
	int bgBlue;
	
	Preferences prefs;
	static final String BGRED= "bgred";
	static final String BGGREEN= "bggreen";
	static final String BGBLUE= "bgblue";
    static final String LOCATION_X = "locationX";
    static final String LOCATION_Y = "locationY";
    static final String WIDTH = "width";
    static final String HEIGHT = "height";

    int locationX;
    int locationY;
    
    
	public void save(){
		Rectangle rect = this.getBounds();
		prefs.putInt(LOCATION_X, rect.x);
		prefs.putInt(LOCATION_Y, rect.y);
		prefs.putInt(WIDTH, rect.width);
		prefs.putInt(HEIGHT, rect.height);
		
		Color color = this.myMenu.getBackground();
		bgRed = color.getRed();
		bgGreen = color.getGreen();
		bgBlue = color.getBlue();
		prefs.putInt(BGRED, bgRed);
		prefs.putInt(BGGREEN, bgGreen);
		prefs.putInt(BGBLUE, bgBlue);
	}
	
	public void load(){
        locationX = prefs.getInt(LOCATION_X, 0);
        locationY = prefs.getInt(LOCATION_Y, 0);
        width = prefs.getInt(WIDTH, 400);
        height = prefs.getInt(HEIGHT, 100);

		bgRed = prefs.getInt(BGRED, 255);
		bgGreen= prefs.getInt(BGGREEN, 255);
		bgBlue = prefs.getInt(BGBLUE, 255);
	}
	
	Clock() {
		super("時計");
		super.setSize(width, height);
		
		prefs = Preferences.userNodeForPackage(this.getClass());
		load();
		this.setBounds(locationX, locationY, width, height);
		this.myMenu.setBackground(new Color(bgRed, bgGreen, bgBlue));
		
		// 定期的にTimerTask.run()を実行
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		setMenuBar(property);
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
	
	class Property extends MenuBar implements ActionListener{
		Menu mn;
		MenuItem mi;
		Clock clock;
		Property(Clock clock){
			this.clock = clock;
			mn = new Menu("プロパティ");
			mi = new MenuItem("ダイアログ");
			mn.addActionListener(this);
			mi.addActionListener(this);
			mn.add(mi);
			add(mn);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mn)){
				clock.myDialog = new MyDialog(clock);
			}
	        if (e.getActionCommand() == "ダイアログ"){
	        	clock.myDialog = new MyDialog(clock);
	        }
		}
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
		Clock clock;
		MyMenuBar myMenu;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		List lst1;
		List fontList;
		List fontSizeList;
		List fontColorList;
		List backGroundColorList;
		String[] fs;
		Font  preFont;
		Font  font;
		Color preColor;
		Button okButton;
		Button cancelButton;
		
		public MyDialog(Clock owner) {
			super(owner);
			this.clock = owner;
			preFont = clock.myMenu.font;
			preColor = clock.getBackground();
			
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
			
			backGroundColorList = new List(4, false);
			backGroundColorList.add("赤");
			backGroundColorList.add("青");
			backGroundColorList.add("黄");
			backGroundColorList.add("緑");
			backGroundColorList.add("白");
			backGroundColorList.add("黒");
			
			fontColorList = new List(4, false);
			fontColorList.add("赤");
			fontColorList.add("青");
			fontColorList.add("黄");
			fontColorList.add("緑");
			fontColorList.add("白");
			fontColorList.add("黒");
			
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
     		lst1.addActionListener(this);
     		fontList.addItemListener(this);
     		fontList.addActionListener(this);
     		backGroundColorList.addItemListener(this);
     		backGroundColorList.addActionListener(this);
     		
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
//				if(lst1.getSelectedItem().equals("フォント")){
//				}
//				else if(lst1.getSelectedItem().equals("フォントサイズ")){
//				}
//				clock.myMenu.setBackground(Color.BLACK);
				this.setVisible(false);
			}
			if(e.getSource().equals(cancelButton)){
				clock.myMenu.setBackground(preColor);
			}
			if(e.getSource().equals(backGroundColorList)){

			}
		}

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource().equals(lst1)){
				this.remove(fontList);
				this.remove(fontSizeList);
				this.remove(fontColorList);
				this.remove(backGroundColorList);
				if(lst1.getSelectedItem().equals("フォント")){
					add(1, 0, 1, 1, fontList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("フォントサイズ")){
					System.out.println("c");
					add(1, 0, 1, 1, fontSizeList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("文字色")){
					add(1, 0, 1, 1, fontColorList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("背景色")){
					add(1, 0, 1, 1, backGroundColorList, gbl, gbc);
				}
			}
			if(e.getSource().equals(fontList)){
				for(int i = 0; i < fs.length; i++){
					if(fontList.getSelectedItem().equals(fs[i])){
						System.out.println("d");
						
						Font f = new Font(fs[i], Font.PLAIN, 10);
						clock.myMenu.setFont(f);
					}
				}
			}
			else if(e.getSource().equals(fontList)){
					System.out.println("d");
					int fontSize = Integer.parseInt(fontSizeList.getSelectedItem());
					Font f = new Font(fs[22], Font.PLAIN, fontSize);
					clock.myMenu.setFont(f);
			}
			else if(e.getSource().equals(fontColorList)){
				if(fontColorList.getSelectedItem().equals("赤")){
					clock.myMenu.setFontColor(Color.RED);
				}
				else if(fontColorList.getSelectedItem().equals("青")){
					clock.myMenu.setBackground(Color.BLUE);
				}
				else if(fontColorList.getSelectedItem().equals("黄")){
					clock.myMenu.setBackground(Color.YELLOW);
				}
				else if(fontColorList.getSelectedItem().equals("緑")){
					clock.myMenu.setBackground(Color.GREEN);
				}
				else if(fontColorList.getSelectedItem().equals("白")){
					clock.myMenu.setBackground(Color.WHITE);
				}
				else if(fontColorList.getSelectedItem().equals("黒")){
					clock.myMenu.setBackground(Color.BLACK);
				}
			}
			else if(e.getSource().equals(backGroundColorList)){
				if(backGroundColorList.getSelectedItem().equals("赤")){
					clock.myMenu.setBackground(Color.RED);
				}
				else if(backGroundColorList.getSelectedItem().equals("青")){
					clock.myMenu.setBackground(Color.BLUE);
				}
				else if(backGroundColorList.getSelectedItem().equals("黄")){
					clock.myMenu.setBackground(Color.YELLOW);
				}
				else if(backGroundColorList.getSelectedItem().equals("緑")){
					clock.myMenu.setBackground(Color.GREEN);
				}
				else if(backGroundColorList.getSelectedItem().equals("白")){
					clock.myMenu.setBackground(Color.WHITE);
				}
				else if(backGroundColorList.getSelectedItem().equals("黒")){
					clock.myMenu.setBackground(Color.BLACK);
				}
			}
			setLayout(gbl);
			setVisible(true);
		}
	}
	
	class MyMenuBar extends Panel {

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
			save();
			System.exit(0);
		}
	}

}