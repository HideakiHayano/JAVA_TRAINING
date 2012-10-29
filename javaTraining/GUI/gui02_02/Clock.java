package gui02_02;

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
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Clock extends Frame {
	int width = 400;
	int height = 100;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM/d (EEE) HH:mm:ss");
	Timer timer = new Timer();
	TimerTask timerTask = new Task();
	MyPanel myMenu = new MyPanel(this);
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
		new Clock();
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

	class MyDialog extends JDialog implements ListSelectionListener, ActionListener, ChangeListener{
		Clock clock;
		MyPanel myMenu;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JList lst1;
		JList fontList;
		JList fontSizeList;

		String[] menuStr = {"font","font size","font color","background color"};
		String[] fs;
		String[] fontSizeStr = {"20","30","40","50"};
		String  preFontStyle;
		int preFontKind;
		int preFontSize;
		Color preFontColor;
		Color preBgColor;
		JButton okButton;
		JButton cancelButton;
		JColorChooser colorChooser;
		JScrollPane scroll;
		JPanel listPanel;
		
		public MyDialog(Clock owner) {
			super(owner);
			this.clock = owner;
			
			preFontStyle = clock.myMenu.getFontStyle();
			preFontKind = clock.myMenu.getFontKind();
			preFontSize = clock.myMenu.getFontSize();
			preFontColor = clock.myMenu.getFontColor();
			preBgColor = clock.myMenu.getBackGroundColor();
			
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			fs = ge.getAvailableFontFamilyNames();
			
			fontList = new JList(fs);
			fontList.setVisibleRowCount(4);
			fontSizeList = new JList(fontSizeStr);
			
			lst1 = new JList(menuStr);

			add(0, 0, 1, 1, lst1, gbl, gbc);
			
			okButton = new JButton("O.K.");
			cancelButton = new JButton("Cancel");
			
			add(2, 4, 1, 1, okButton, gbl, gbc);
			add(3, 4, 1, 1, cancelButton, gbl, gbc);

			lst1.addListSelectionListener(this);
     		fontList.addListSelectionListener(this);
     		fontSizeList.addListSelectionListener(this);
     		
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
				clock.myMenu.setFontColor(preFontColor);
				clock.myMenu.setFontKind(preFontKind);
				clock.myMenu.setBackground(preBgColor);
			}
		}
		
		public void valueChanged(ListSelectionEvent e) {
			if(e.getSource().equals(lst1)){
				this.remove(fontList);
				this.remove(fontSizeList);

				if(lst1.getSelectedValue().equals("font")){
					add(1, 0, 1, 1, fontList, gbl, gbc);
				}
				else if(lst1.getSelectedValue().equals("font size")){
					add(1, 0, 1, 1, fontSizeList, gbl, gbc);
				}
				else if(lst1.getSelectedValue().equals("font color")){
					colorChooser = new JColorChooser();
					Color color = colorChooser.showDialog(this, "Choose color", Color.white);
				    if(color != null){
				    	clock.myMenu.setFontColor(color);
				    }
				}
				else if(lst1.getSelectedValue().equals("background color")){
					colorChooser = new JColorChooser();
					Color color = colorChooser.showDialog(this, "Choose color", Color.white);
				    if(color != null){
				        clock.myMenu.setBackground(color);
				    }
				}
			}
			
			if(e.getSource().equals(fontList)){
				clock.myMenu.setFontStyle((String) fontList.getSelectedValue());
			}
			else if(e.getSource().equals(fontSizeList)){
				clock.myMenu.setFontSize(Integer.parseInt((String) fontSizeList.getSelectedValue()));
			}
			setLayout(gbl);
			setVisible(true);
		}

		public void stateChanged(ChangeEvent e) {
		    Color color = colorChooser.getColor();
		    clock.myMenu.setBackground(color);	
		}
	}
	
	class MyPanel extends JPanel{
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
		
		public MyPanel(Clock clock){
			myTime = new MyTime();
			this.clock = clock;
			font = new Font(fontStyle, fontKind, fontSize);
			super.setBackground(bgColor);
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