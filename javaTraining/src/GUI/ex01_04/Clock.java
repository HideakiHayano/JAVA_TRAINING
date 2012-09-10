package GUI.ex01_04;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
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
	
	String fStyle;
	int fSize;
	int fRed;
	int fGreen;
	int fBlue;
	
	Preferences prefs;
	static final String BGRED= "bgred";
	static final String BGGREEN= "bggreen";
	static final String BGBLUE= "bgblue";
    static final String LOCATION_X = "locationX";
    static final String LOCATION_Y = "locationY";
    static final String WIDTH = "width";
    static final String HEIGHT = "height";
    static final String FONTSTYLE = "fontstyle";
    static final String FONTSIZE = "fontsize";
    static final String FRED = "fred";
    static final String FGREEN = "fgreen";
    static final String FBLUE = "fblue";
    
    int locationX;
    int locationY;
    
	public void save(){
		Rectangle rect = this.getBounds();
		prefs.putInt(LOCATION_X, rect.x);
		prefs.putInt(LOCATION_Y, rect.y);
		prefs.putInt(WIDTH, rect.width);
		prefs.putInt(HEIGHT, rect.height);
		
		prefs.put(FONTSTYLE, this.myMenu.fontStyle);
		prefs.putInt(FONTSIZE, this.myMenu.fontSize);
		
		Color fColor = this.myMenu.fontColor; 
		fRed = fColor.getRed();
		fGreen = fColor.getGreen();
		fBlue = fColor.getBlue();
		prefs.putInt(FRED, fRed);
		prefs.putInt(FGREEN, fGreen);
		prefs.putInt(FBLUE, fBlue);
		
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
        
        fStyle = prefs.get(FONTSTYLE, "Aharoni");
        fSize = prefs.getInt(FONTSIZE, 25);
        
		fRed = prefs.getInt(FRED, 255);
		fGreen = prefs.getInt(FGREEN, 255);
		fBlue = prefs.getInt(FBLUE, 255);
        
		bgRed = prefs.getInt(BGRED, 255);
		bgGreen= prefs.getInt(BGGREEN, 255);
		bgBlue = prefs.getInt(BGBLUE, 255);
	}
	
	Clock() {
		super("clock");
		super.setSize(width, height);
		Locale.setDefault(Locale.ENGLISH);
		
		prefs = Preferences.userNodeForPackage(this.getClass());
		load();
		this.setBounds(locationX, locationY, width, height);
		this.myMenu.setFontStyle(fStyle);
		this.myMenu.setFontSize(fSize);
		this.myMenu.setFontColor(new Color(fRed, fGreen, fBlue));
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
			mn = new Menu("property");
			mi = new MenuItem("dialog");
			mn.addActionListener(this);
			mi.addActionListener(this);
			mn.add(mi);
			add(mn);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mn)){
				clock.myDialog = new MyDialog(clock);
			}
	        if (e.getActionCommand() == "dialog"){
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
		String  preFontStyle;
		int preFontSize;
		Color preFontColor;
		Color preColor;
		Button okButton;
		Button cancelButton;
		
		public MyDialog(Clock owner) {
			super(owner);
			this.clock = owner;
			
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
			backGroundColorList.add("red");
			backGroundColorList.add("blue");
			backGroundColorList.add("yellow");
			backGroundColorList.add("green");
			backGroundColorList.add("white");
			backGroundColorList.add("black");
			
			fontColorList = new List(4, false);
			fontColorList.add("red");
			fontColorList.add("blue");
			fontColorList.add("yellow");
			fontColorList.add("green");
			fontColorList.add("white");
			fontColorList.add("black");
			
			lst1 = new List(4, false);
			lst1.add("font");
			lst1.add("font size");
			lst1.add("font color");
			lst1.add("background color");
			add(0, 0, 1, 1, lst1, gbl, gbc);
			
			okButton = new Button("O.K.");
			cancelButton = new Button("Cancel");
			
			add(2, 4, 1, 1, okButton, gbl, gbc);
			add(3, 4, 1, 1, cancelButton, gbl, gbc);

			lst1.addItemListener(this);
     		lst1.addActionListener(this);
     		fontList.addItemListener(this);
     		fontList.addActionListener(this);
     		fontSizeList.addItemListener(this);
     		fontSizeList.addActionListener(this);
     		fontColorList.addItemListener(this);
     		fontColorList.addActionListener(this);
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
				this.setVisible(false);
			}
			if(e.getSource().equals(cancelButton)){
				clock.myMenu.setFontStyle(preFontStyle);
				clock.myMenu.setFontSize(preFontSize);
				clock.myMenu.fontColor = preFontColor;
				clock.myMenu.setBackground(preColor);
			}
		}

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource().equals(lst1)){
				this.remove(fontList);
				this.remove(fontSizeList);
				this.remove(fontColorList);
				this.remove(backGroundColorList);
				if(lst1.getSelectedItem().equals("font")){
					add(1, 0, 1, 1, fontList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("font size")){
					System.out.println("c");
					add(1, 0, 1, 1, fontSizeList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("font color")){
					add(1, 0, 1, 1, fontColorList, gbl, gbc);
				}
				else if(lst1.getSelectedItem().equals("background color")){
					add(1, 0, 1, 1, backGroundColorList, gbl, gbc);
				}
			}
			if(e.getSource().equals(fontList)){
				preFontStyle = clock.myMenu.fontStyle;
				clock.myMenu.setFontStyle(fontList.getSelectedItem());
			}
			else if(e.getSource().equals(fontSizeList)){
				preFontSize = clock.myMenu.fontSize;
				clock.myMenu.setFontSize(Integer.parseInt(fontSizeList.getSelectedItem()));
			}
			else if(e.getSource().equals(fontColorList)){
				preFontColor = clock.myMenu.fontColor;
				if(fontColorList.getSelectedItem().equals("red")){
					clock.myMenu.setFontColor(Color.RED);
				}
				else if(fontColorList.getSelectedItem().equals("blue")){
					clock.myMenu.setFontColor(Color.BLUE);
				}
				else if(fontColorList.getSelectedItem().equals("yellow")){
					clock.myMenu.setFontColor(Color.YELLOW);
				}
				else if(fontColorList.getSelectedItem().equals("green")){
					clock.myMenu.setFontColor(Color.GREEN);
				}
				else if(fontColorList.getSelectedItem().equals("white")){
					clock.myMenu.setFontColor(Color.WHITE);
				}
				else if(fontColorList.getSelectedItem().equals("black")){
					clock.myMenu.setFontColor(Color.BLACK);
				}
				System.out.println(clock.myMenu.fontColor);
			}
			else if(e.getSource().equals(backGroundColorList)){
				preColor = clock.myMenu.getBackground();
				if(backGroundColorList.getSelectedItem().equals("red")){
					clock.myMenu.setBackground(Color.RED);
				}
				else if(backGroundColorList.getSelectedItem().equals("blue")){
					clock.myMenu.setBackground(Color.BLUE);
				}
				else if(backGroundColorList.getSelectedItem().equals("yellow")){
					clock.myMenu.setBackground(Color.YELLOW);
				}
				else if(backGroundColorList.getSelectedItem().equals("green")){
					clock.myMenu.setBackground(Color.GREEN);
				}
				else if(backGroundColorList.getSelectedItem().equals("white")){
					clock.myMenu.setBackground(Color.WHITE);
				}
				else if(backGroundColorList.getSelectedItem().equals("black")){
					clock.myMenu.setBackground(Color.BLACK);
				}
			}
			setLayout(gbl);
			setVisible(true);
		}
	}
	
	class MyMenuBar extends Panel {

		Font font;
		String fontStyle = "Aharoni";
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		Color fontColor = Color.BLACK;;

		int drawPointX = 20;
		int drawPointY = 20;

		int numOfItems = 4;

		Clock frame;

		MyMenuBar(Clock frame) {
			this.frame = frame;
			font = new Font(fontStyle, fontKind, fontSize);
		}
		
		public void setFontStyle(String fontStyle) {
			this.fontStyle = fontStyle;
			this.font = new Font(fontStyle, fontKind, fontSize);
		}
		
		public void setFontKind(int fontKind) {
			this.fontKind = fontKind;
			this.font = new Font(fontStyle, fontKind, fontSize);
		}

		public void setFontSize(int fontSize) {
			this.fontSize = fontSize;
			this.font = new Font(fontStyle, fontKind, fontSize);
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