package gui02_03;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Clock extends JWindow {
	int width = 400;
	int height = 100;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	MyPanel myMenu = new MyPanel(this);
	
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
		
		//setMenuBar(property);
		add(myMenu);
		
		addWindowListener(new ClosingWindowListener());
		addMouseMotionListener((MouseMotionListener) new MouseAdapter(this, myMenu));
		addMouseListener(new MouseAdapter(this, myMenu));
		super.setVisible(true);

	}
	
	class MouseAdapter implements MouseListener, MouseMotionListener{
		Clock clock;
		MyPanel panel;
		int startX;
		int startY;
		Point loc;
		
		public MouseAdapter(Clock clock, MyPanel panel){
			this.clock = clock;
			this.panel = panel;
		}
		
		public void mouseDragged(MouseEvent e) {
			loc = clock.getLocation(loc);
			int x = loc.x + e.getX() - startX;
			int y = loc.y  + e.getY() - startY;
			clock.setLocation(x, y);
		}
	
		public void mouseMoved(MouseEvent e) {

		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
		    if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON1_MASK) != 0) {
		    	this.startX = e.getX();
		    	this.startY = e.getY();
		    	System.out.println(startX);
		    	System.out.println(startY);
		    }
		    else if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON3_MASK) != 0) {
		    	panel.popup.show(panel, e.getX(), e.getY());
		    }
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
	public static void main(String[] args) {
		new Clock();
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
	
	class MyPanel extends JPanel{
		JPopupMenu popup;
		
		MyTime myTime;
		Clock clock;
		
		int drawPointX = 20;
		int drawPointY = 20;
		
		Font font;
		int fontKind = Font.PLAIN;
		int fontSize = 25;
		String fontStyle = "Aharoni";
		Color fontColor = Color.BLACK;
		Color bgColor = Color.WHITE;
		
		String[] fs;
		String[] colorStr = {"black", "white", "red", "green", "blue"};
		Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.GREEN, Color.BLUE};
		String[] bgColorStr = {"cyan", "pink", "yellow", "magenta", "orange"};
		Color[] bgColors = {Color.CYAN, Color.PINK, Color.YELLOW, Color.MAGENTA, Color.ORANGE};
		int FONT_SIZE_LENGTH = 4;
		int COLOR_LIST_LENGTH = 5;
		
		JEditorPane editor;
		
		public MyPanel(Clock clock){
			myTime = new MyTime();
			this.clock = clock;
			font = new Font(fontStyle, fontKind, fontSize);
			super.setBackground(bgColor);
			popup = new JPopupMenu();
			
			JMenu mn = new JMenu("menu");
			editor = new JEditorPane();
			editor.setContentType("text/html");
			editor.setEditable(true);
			
			editor.setText("<b>Hello</b>");
			mn.add(editor);
			JMenu mnf = new JMenu("font style");
			JMenu mnfs = new JMenu("font size");
			JMenu mnfc = new JMenu("font color");
			JMenu mnbg = new JMenu("background color");
			
			mn.add(mnf);
			mn.add(mnfs);
			mn.add(mnfc);
			mn.add(mnbg);
			
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			fs = ge.getAvailableFontFamilyNames();
			JMenuItem[] mif = new JMenuItem[fs.length];
			for(int i = 0; i < fs.length; i++){
				mif[i] = new JMenuItem(fs[i]);
				mnf.add(mif[i]);
				mif[i].addActionListener(new ActionAdapter(this, this.clock));
			}
			
			JMenuItem[] mifs = new JMenuItem[FONT_SIZE_LENGTH];
			for(int i = 0; i < FONT_SIZE_LENGTH; i++){
				mifs[i] = new JMenuItem(Integer.valueOf(10*2*(i+1)).toString());
				mnfs.add(mifs[i]);
				mifs[i].addActionListener(new ActionAdapter(this, this.clock));
			}
			
			JMenuItem[] mifc = new JMenuItem[COLOR_LIST_LENGTH];
			for(int i = 0; i < COLOR_LIST_LENGTH; i++){
				mifc[i] = new JMenuItem(colorStr[i]);
				mnfc.add(mifc[i]);
				mifc[i].addActionListener(new ActionAdapter(this, this.clock));
			}
			
			JMenuItem[] mibg = new JMenuItem[COLOR_LIST_LENGTH];
			for(int i = 0; i < COLOR_LIST_LENGTH; i++){
				mibg[i] = new JMenuItem(bgColorStr[i]);
				mnbg.add(mibg[i]);
				mibg[i].addActionListener(new ActionAdapter(this, this.clock));
			}
			
			popup.add(mn);
			add(popup);
		
		}
		
		public void setDrawPoint(int x, int y){
			drawPointX = x;
			drawPointY = y;
		}
		
		public String getFontStyle(){
			return this.fontStyle;
		}
		
		public Color getFontColor(){
			return this.fontColor;
		}
		
		public int getFontKind(){
			return this.fontKind;
		}
		
		public int getFontSize(){
			return this.fontSize;
		}
		
		public Color getBackGroundColor(){
			return this.bgColor;
		}
		
		public void setFontStyle(String fontStyle) {
			this.fontStyle = fontStyle;
			this.font = new Font(fontStyle, fontKind, fontSize);
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
			clock.setSize(fontSize*16, fontSize*4);
			this.setDrawPoint(fontSize, fontSize);
		}
		
		public void setBackGroundColor(Color color){
			this.bgColor = color;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			myTime = new MyTime();
      	    g.setFont(font);
			g.setColor(fontColor);
			g.drawString(myTime.time, drawPointX, drawPointY);
		}
		
		class ActionAdapter implements ActionListener{
			MyPanel panel;
			Clock clock;
			public ActionAdapter(MyPanel panel, Clock clock){
				this.panel = panel;
				this.clock = clock;
			}
			
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Exit")){
					System.exit(0);
				}
				
				for(int i = 0; i < fs.length; i ++){
					if(e.getActionCommand().equals(fs[i]))
					{
						setFontStyle(fs[i]);
					}
				}

				for(int i = 0; i < FONT_SIZE_LENGTH; i ++){	
					if(e.getActionCommand().equals(Integer.valueOf(10*2*(i+1)).toString())){
						setFontSize(10*2*(i+1));
					}
				}
				
				for(int i = 0; i < COLOR_LIST_LENGTH; i ++){	
					if(e.getActionCommand().equals(colorStr[i])){
						setFontColor(colors[i]);
					}
				}
				
				for(int i = 0; i < COLOR_LIST_LENGTH; i ++){
					if(e.getActionCommand().equals(bgColorStr[i])){
						clock.myMenu.setBackground(bgColors[i]);
					}
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