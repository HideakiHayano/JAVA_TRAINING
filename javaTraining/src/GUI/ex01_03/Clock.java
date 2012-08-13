package GUI.ex1_3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import GUI.ex1_3.MyFrame.MyMenuBar.ActionAdapter;

public class Clock extends Window{
	
	public Clock(Frame owner) {
		super(owner);
	}
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		Clock clock = new Clock(frame);
	}
	
}
