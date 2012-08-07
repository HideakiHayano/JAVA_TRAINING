package Interpret;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	
	static Map<String, Object> objectMap = new HashMap<String, Object>();
	
	Class cls;
	Object o;

	Display display;
	Display display1;
	Display display2;
	
	class Display extends JFrame{
		
		JTextArea text;
		JScrollPane scroll;
		
		Display(){
			text = new JTextArea();
			text.setWrapStyleWord(true);
			scroll = new JScrollPane(text);
			add(scroll);
			addWindowListener(new ClosingWindowListener());
			setSize(600, 500);
			setVisible(true);
		}
		
		Display(String title){
			super(title);
			text = new JTextArea();
			text.setWrapStyleWord(true);
			scroll = new JScrollPane(text);
			add(scroll);
			addWindowListener(new ClosingWindowListener());
			setSize(600, 500);
			setVisible(true);
		}
		
		void append(String str){
			text.append(str);
		}
		
	}
	
	JLabel label;
	JTextField text;
	JButton button;
	
	JButton printButton;
	JButton printFieldButton;
	JButton printConstructorButton;
	JButton printMethodButton;
	
	JLabel fLabel;
	JLabel fLabel0;
	JLabel fLabel1;
	JTextField fText;
	JTextField fText0;
	JTextField fText1;
	JButton fButton;
	
	JLabel cLabel;
	JLabel cLabel0;
	JTextField cText;
	JTextField cText0;
	JButton cButton;
	
	JLabel aLabel;
	JLabel aLabel0;
	JTextField aText;
	JTextField aText0;
	JButton aButton;
	
	JLabel asLabel;
	JLabel asLabel0;
	JTextField asText;
	JTextField asText0;
	JButton asButton;
	
	JLabel mLabel;
	JLabel mLabel0;
	JTextField mText;
	JTextField mText0;
	JButton mButton;
	
	public MyFrame(){
		display1 = new Display("�C���X�^���X���X�g");
		display2 = new Display("�N���X���");
		display = new Display();
		Interpret ip = new Interpret(display, display1, display2);
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		
		label = new JLabel("�C���X�^���X�𐶐��������N���X�������");
		add(0, 0, 5, 1, label, gbl, gbc);
		text = new JTextField(40);
		add(0, 1, 10, 1, text, gbl, gbc);
		button = new JButton("O.K.");
		button.addActionListener(this);
		add(0, 2, 1, 1, button, gbl, gbc);
		
//		printButton = new JButton("�S���\��");
//		printButton.addActionListener(this);
//		add(1, 2, 2, 1, printButton, gbl, gbc);
		
		printFieldButton = new JButton("�t�B�[���h");
		printFieldButton.addActionListener(this);
		add(2, 2, 1, 1, printFieldButton, gbl, gbc);
		
		printConstructorButton = new JButton("�R���X�g���N�^");
		printConstructorButton.addActionListener(this);
		add(3, 2, 2, 1, printConstructorButton, gbl, gbc);
		
		printMethodButton = new JButton("���\�b�h");
		printMethodButton.addActionListener(this);
		add(5, 2, 2, 1, printMethodButton, gbl, gbc);
		
		cLabel0 = new JLabel("�C���X�^���X��");
		add(0, 3, 2, 1, cLabel0, gbl, gbc);
		cLabel = new JLabel("�R���X�g���N�^�̈������u,�v�ŋ�؂��ē���");
		add(2, 3, 5, 1, cLabel, gbl, gbc);
		cText0 = new JTextField(10);
		add(0, 4, 2, 1, cText0, gbl, gbc);
		cText = new JTextField(30);
		add(2, 4, 8, 1, cText, gbl, gbc);
		cButton = new JButton("O.K.");
		cButton.addActionListener(this);
		add(0, 5, 1, 1, cButton, gbl, gbc);
		
		aLabel0 = new JLabel("�z��");
		add(0, 6, 2, 1, aLabel0, gbl, gbc);
		aLabel = new JLabel("��������z��̌^�ƃT�C�Y���u,�v�ŋ�؂��ē���");
		add(2, 6, 5, 1, aLabel, gbl, gbc);
		aText0 = new JTextField(10);
		add(0, 7, 2, 1, aText0, gbl, gbc);
		aText = new JTextField(30);
		add(2, 7, 8, 1, aText, gbl, gbc);
		aButton = new JButton("O.K.");
		aButton.addActionListener(this);
		add(0, 8, 1, 1, aButton, gbl, gbc);
		
		asLabel0 = new JLabel("�z��");
		add(0, 9, 2, 1, asLabel0, gbl, gbc);
		asLabel = new JLabel("�C���f�b�N�X�Ɛݒ肷��l���u,�v�ŋ�؂��ē���");
		add(2, 9, 5, 1, asLabel, gbl, gbc);
		asText0 = new JTextField(10);
		add(0, 10, 2, 1, asText0, gbl, gbc);
		asText = new JTextField(30);
		add(2, 10, 8, 1, asText, gbl, gbc);
		asButton = new JButton("O.K.");
		asButton.addActionListener(this);
		add(0, 11, 1, 1, asButton, gbl, gbc);
		
		fLabel0 = new JLabel("�C���X�^���X��");
		add(0, 12, 2, 1, fLabel0, gbl, gbc);
		fLabel = new JLabel("�擾: �u�t�B�[���h�v  or �ݒ�: �u�t�B�[���h�v, �u�l�v");
		add(2, 12, 5, 1, fLabel, gbl, gbc);
		fText0 = new JTextField(10);
		add(0, 13, 2, 1, fText0, gbl, gbc);
		fText = new JTextField(30);
		add(2, 13, 8, 1, fText, gbl, gbc);
		fButton = new JButton("O.K.");
		fButton.addActionListener(this);
		add(0, 14, 1, 1, fButton, gbl, gbc);
		
		mLabel0 = new JLabel("�C���X�^���X��");
		add(0, 15, 2, 1, mLabel0, gbl, gbc);
		mLabel = new JLabel("���\�b�h���A �������u,�v�ŋ�؂��ē���");
		add(2, 15, 5, 1, mLabel, gbl, gbc);
		mText0 = new JTextField(10);
		add(0, 16, 2, 1, mText0, gbl, gbc);
		mText = new JTextField(30);
		add(2, 16, 10, 1, mText, gbl, gbc);
		mButton = new JButton("O.K.");
		mButton.addActionListener(this);
		add(0, 17, 1, 1, mButton, gbl, gbc);
		
		addWindowListener(new ClosingWindowListener());
		super.setSize(600, 500);
		super.setVisible(true);
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
	
	@SuppressWarnings({ "unchecked", "unused" })
	public void actionPerformed(ActionEvent e){		
		if(e.getSource().equals(button)){
			//�N���X�I�u�W�F�N�g�̎擾
			cls = Interpret.getClass(text.getText());
		}
		else if(e.getSource().equals(printButton)){
			Interpret.printAllMembers(cls);
		}
		else if(e.getSource().equals(printFieldButton)){
			Interpret.printFields(cls);
		}
		else if(e.getSource().equals(printConstructorButton)){
			Interpret.printConstructors(cls);
		}
		else if(e.getSource().equals(printMethodButton)){
			Interpret.printMethods(cls);
		}
		else if(e.getSource().equals(cButton)){
			//�R���X�g���N�^�̈������擾���ăC���X�^���X����
			//���[�U���w�肵�������񂩂�C���X�^���X�̔z��𐶐����ăR���X�g���N�^�̈����Ƃ��ė��p�B
			if(cText.getText().equals(null) || cText.getText().equals("")){
				try {
					String name = cText0.getText();
					if(objectMap.containsKey(name)){
						display.append("���̃C���X�^���X���͊��Ɏg�p����Ă��܂�\r\n");
					}
					else{
						o = Interpret.getInstance(cls);
						objectMap.put(name, o);
					}

				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
					display.append("IllegalArgumentException\r\n");
				} catch (SecurityException e1) {
					e1.printStackTrace();
					display.append("SecurityException\r\n");
				} catch (InstantiationException e1) {
					e1.printStackTrace();
					display.append("InstantiationException\r\n");
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
					display.append("IllegalAccessException\r\n");
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
					display.append("InvocationTargetException\r\n");
					display.append(e1.getCause().toString() + "\r\n");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					display.append("ClassNotFoundException\r\n");
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					display.append("NoSuchMethodException\r\n");
				}
			}
			else{//���[�U���w�肵����������L�[�Ƃ���I�u�W�F�N�g��map�ɂ���Ύ擾�B�Ȃ���Ε�����������Ƃ��Ĉ����B
				String[] str = cText.getText().split(",");
				Object[] args = new Object[str.length];
				for(int i = 0; i < args.length; i++){
					try {
//						if(objectMap.get(str[i]) != null){
//							args[i] = objectMap.get(str[i]);
//						}
//						else{
//							args[i] = str[i];
//						}
						//�������z��̏ꍇ
						if(str[i].contains("[")){
							String key = str[i].substring(0, str[i].indexOf("["));
							int index = Integer.parseInt(str[i].substring(str[i].indexOf("[")+1, str[i].indexOf("]")));
							args[i] = Interpret.getElement((Object[])objectMap.get(key), index);
						}
						else{//�������z��ȊO�̏ꍇ
							//objectMap�ɃL�[�����݂���ꍇ
							if(objectMap.get(str[i]) != null){
								args[i] = objectMap.get(str[i]);
							}
							else{
								try{
									args[i] = Integer.parseInt(str[i]);
								}
								catch(NumberFormatException e1){
									if(str[i].equals("true") || str[i].equals("false")){
										args[i] = Boolean.parseBoolean(str[i]);
									}
									else{
										args[i] = str[i];
									}
								}
							}
						}
//						args[i] = Interpret.getInstance(Interpret.getClass(str[i]));
						o = Interpret.getInstance(cls, args);
						objectMap.put(cText0.getText(), o);
						display1.append(cText0.getText() + "\r\n");
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
						display.append("IllegalArgumentException\r\n");
					} catch (SecurityException e1) {
						e1.printStackTrace();
						display.append("SecurityException\r\n");
					} catch (InstantiationException e1) {
						e1.printStackTrace();
						display.append("InstantiationException\r\n");
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
						display.append("IllegalAccessException\r\n");
					} catch (InvocationTargetException e1) {
						e1.printStackTrace();
						display.append("InvocationTargetException\r\n");
						display.append(e1.getCause().toString() + "\r\n");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
						display.append("ClassNotFoundException\r\n");
					} catch (NoSuchMethodException e1) {
						e1.printStackTrace();
						display.append("NoSuchMethodException\r\n");
					}
				}
			}
		}
		else if(e.getSource().equals(aButton)){
			String[] str = aText.getText().split(",");
			String arrayName = aText0.getText(); 
			try {
				if(objectMap.get(str[1]) != null){
					o = Interpret.toArray(Class.forName(str[0]), (Integer)objectMap.get(str[1]));
				}
				else{
					o = Interpret.toArray(Class.forName(str[0]), Integer.parseInt(str[1]));
				}
				if(!objectMap.containsKey(arrayName)){
					objectMap.put(arrayName, o);
					display1.append(arrayName + "\r\n");
				}
				else{
					display.append("���̔z�񖼂͊��Ɏg�p����Ă��܂�");
				}
				
				
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(asButton)){
			String[] str = asText.getText().split(",");
			String arrayName = asText0.getText(); 
			//str[0]: index
			int index = Integer.parseInt(str[0]);
			//�z����擾
			o = objectMap.get(arrayName);
			//�z��̃N���X�����擾
//			Class<?> arrType = o.getClass();
//			System.out.println("arrType"+arrType.getName());
			Object value;
			
			//�������z��̏ꍇ
			if(str[1].contains("[")){
				String key = str[1].substring(0, str[1].indexOf("["));
				int index2 = Integer.parseInt(str[1].substring(str[1].indexOf("[")+1, str[1].indexOf("]")));
				value = Interpret.getElement((Object[])objectMap.get(key), index2);
			}
			else{//�������z��ȊO�̏ꍇ
				if(objectMap.get(str[1]) != null){
					value = objectMap.get(str[1]);
				}
				else{
					try{
						value = Integer.parseInt(str[1]);
					}
					catch(NumberFormatException e1){
						if(str[1].equals("true") || str[1].equals("false")){
							value = Boolean.parseBoolean(str[1]);
						}
						else{
							value = str[1];
						}
					}
				}
			}
//			System.out.println("�z��ɒl�����B �C���f�b�N�X: " + index + " " + "�v�f�^: " + value.getClass().getName());

			//o.get(index)��value�͓����^�ł���K�v������
//			oArr[index] = value.getClass().cast(oArr[index]);

			Interpret.setElement((Object[])o, value, index);
		}
		else if(e.getSource().equals(fButton)){
			Object arg = new Object();
			String[] str = fText.getText().split(",");
			
			String name = fText0.getText();
			//�C���X�^���X�����z��̏ꍇ
			if(name.contains("[")){
				String key = name.substring(0, name.indexOf("["));
				int index = Integer.parseInt(name.substring(name.indexOf("[")+1, name.indexOf("]")));
				o = Interpret.getElement((Object[])objectMap.get(key), index);
			}
			//�C���X�^���X�����z��ȊO�̏ꍇ
			else{
				o = objectMap.get(name);
			}
			
			if(str.length == 1){
				try {
					Interpret.getField(o, str[0]);
				} catch (SecurityException e1) {
					e1.printStackTrace();
					display.append("SecurityException\r\n");
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
					display.append("IllegalArgumentException\r\n");
				} catch (NoSuchFieldException e1) {
					e1.printStackTrace();
					display.append("NoSuchFieldException\r\n");
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
					display.append("IllegalAccessException\r\n");
				}
			}
			else{
				//�������z��̏ꍇ
				if(str[1].contains("[")){
					String key = str[1].substring(0, str[1].indexOf("["));
					int index = Integer.parseInt(str[1].substring(str[1].indexOf("[")+1, str[1].indexOf("]")));
					arg = Interpret.getElement((Object[])objectMap.get(key), index);
				}
				else{//�������z��ȊO�̏ꍇ
					if(objectMap.get(str[1]) != null){
						arg = objectMap.get(str[1]);
					}
					else{
						try{
							arg = Integer.parseInt(str[1]);
						}
						catch(NumberFormatException e1){
							if(str[1].equals("true") || str[1].equals("false")){
								arg = Boolean.parseBoolean(str[1]);
							}
							else{
								arg = str[1];
							}
						}
					}
				}
				try {
					Interpret.setField(o, str[0], arg);
				} catch (SecurityException e1) {
					e1.printStackTrace();
					display.append("SecurityException\r\n");
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
					display.append("IllegalArgumentException\r\n");
				} catch (NoSuchFieldException e1) {
					e1.printStackTrace();
					display.append("NoSuchFieldException\r\n");
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
					display.append("IllegalAccessException\r\n");
				}
			}
		}
		else if(e.getSource().equals(mButton)){
			String[] str = mText.getText().split(",");
			String name = mText0.getText();
			//�C���X�^���X�����z��̏ꍇ
			if(name.contains("[")){
				String key = name.substring(0, name.indexOf("["));
				int index = Integer.parseInt(name.substring(name.indexOf("[")+1, name.indexOf("]")));
				o = Interpret.getElement((Object[])objectMap.get(key), index);
			}
			//�C���X�^���X�����z��ȊO�̏ꍇ
			else{
				o = objectMap.get(name);
			}
			//�����Ȃ�
			if(str.length == 1){
				try {
					Interpret.invoke(o, str[0]);
				} catch (SecurityException e1) {
					e1.printStackTrace();
					display.append("SecurityException\r\n");
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					display.append("NoSuchMethodException\r\n");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					display.append("ClassNotFoundException\r\n");
				}
			}
			//��������
			else{
				Object[] args = new Object[str.length - 1];
				for(int i = 0; i < args.length; i++){
					//�������z��̏ꍇ
					if(str[i + 1].contains("[")){
						String key = str[i + 1].substring(0, str[i + 1].indexOf("["));
						int index = Integer.parseInt(str[i + 1].substring(str[i + 1].indexOf("[")+1, str[i + 1].indexOf("]")));
						args[i] = Interpret.getElement((Object[])objectMap.get(key), index);
					}
					else{//�������z��ȊO�̏ꍇ
						//objectMap�ɃL�[�����݂���ꍇ
						if(objectMap.get(str[1]) != null){
							args[i] = objectMap.get(str[i + 1]);
						}
						else{
							try{
								args[i] = Integer.parseInt(str[i + 1]);
							}
							catch(NumberFormatException e1){
								if(str[i + 1].equals("true") || str[i + 1].equals("false")){
									args[i] = Boolean.parseBoolean(str[i + 1]);
								}
								else{
									args[i] = str[i + 1];
								}
							}
						}
					}
					
				}
				try {
					Interpret.invoke(o, str[0], args);
				} catch (SecurityException e1) {
					e1.printStackTrace();
					display.append("SecurityException\r\n");
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					display.append("NoSuchMethodException\r\n");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					display.append("ClassNotFoundException\r\n");
				}
			}
		}
	}
	
    class ClosingWindowListener extends WindowAdapter{      
	   public void windowClosing(WindowEvent e){
		   System.exit(0);      
	   }   
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}
