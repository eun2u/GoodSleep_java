import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;


class JPanel011 extends JPanel implements ActionListener
{
	
	static boolean[] factorTF = new boolean[3];
	static int sleepH, sleepM, wakeH, wakeM, sleepTime;
	static int day;
	Info newInfo = new Info();
	
	private JPanel contentPane;
	//private JFrame frame;
	static JCheckBox[] factors = new JCheckBox[3];
	String[] factorName = {"음주", "야식", "카페인"};
	static JButton[] belows = new JButton[4];
	String[] belowName = {"입력", "통계", "수면분석", "음악재생"};
	static JSpinner Hour, Minute, Hour_1, Minute_1;
	static JRadioButton days[] = new JRadioButton[7];
	static String[] DayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	public JPanel011()
	{
		
		//frame = new JFrame("Good Sleep");
		contentPane = new JPanel(new BorderLayout());
		//EventHandle listener = new EventHandle();
		//getContentPane().setLayout(new FlowLayout());
		
		JPanel InputPanel = new JPanel(new GridLayout(3,1));
		
		JPanel radioPanel = new JPanel();
		
		JTextField dayText = new JTextField();
		dayText.setText("오늘은");
		dayText.setEditable(false);
		
		ButtonGroup group = new ButtonGroup();
		
		for(int i=0; i<DayOfWeek.length; i++)
		{
			days[i] = new JRadioButton(DayOfWeek[i]);
			group.add(days[i]);
			radioPanel.add(days[i]);
			days[i].addActionListener(this);
		}
		days[0].setSelected(true);
		
		//time spinner 생성
		JPanel spinnerPanel = new JPanel();
		spinnerPanel.setLayout(new GridLayout(2,1));
		
		//sleep panel
		JPanel sleepPanel = new JPanel();
		
		JTextField sleepText = new JTextField();
		sleepText.setText("잠든 시간");
		sleepText.setEditable(false);
		
		JPanel hour = new JPanel();
		
		Hour = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
		Hour.setFont(new Font("Agency FB", Font.PLAIN, 15));
		hour.add(Hour);
		
		JTextField hourText = new JTextField();
		hourText.setText("시");
		hourText.setEditable(false);
		hour.add(hourText);
		
		JPanel minute = new JPanel();
		Minute = new JSpinner(new SpinnerNumberModel(0, 0, 55, 5));
		Minute.setFont(new Font("Agency FB", Font.PLAIN, 15));
		minute.add(Minute);
		
		JTextField minuteText = new JTextField();
		minuteText.setText("분");
		minuteText.setEditable(false);
		minute.add(minuteText);
		
		sleepPanel.add(sleepText);
		sleepPanel.add(hour);
		sleepPanel.add(minute);
		
		// wake panel
		JPanel wakePanel = new JPanel();
		wakePanel.setBorder(null);
				
		JTextField wakeText = new JTextField();
		wakeText.setText("일어난 시간");
		wakeText.setEditable(false);
	
		JPanel hour_1 = new JPanel();
		Hour_1 = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
		Hour_1.setFont(new Font("Agency FB", Font.PLAIN, 15));
		hour_1.add(Hour_1);
		
		JTextField hourText_1 = new JTextField();
		hourText_1.setText("시");
		hourText_1.setEditable(false);
		hour_1.add(hourText_1);
		
		
		JPanel minute_1 = new JPanel();
		Minute_1 = new JSpinner(new SpinnerNumberModel(0, 0, 55, 5));
		Minute_1.setFont(new Font("Agency FB", Font.PLAIN, 15));
		minute_1.add(Minute_1);
		
		JTextField minuteText_1 = new JTextField();
		minuteText_1.setText("분");
		minuteText_1.setEditable(false);
		minute_1.add(minuteText_1);
		
		
		wakePanel.add(wakeText);
		wakePanel.add(hour_1);
		wakePanel.add(minute_1);
		
		spinnerPanel.add(sleepPanel);
		spinnerPanel.add(wakePanel);
		
		/*
		Hour.addChangeListener(listener);
		Minute.addChangeListener(listener);
		Hour_1.addChangeListener(listener);
		Minute_1.addChangeListener(listener);
		*/
		
		//check box 생성
		JPanel checkPanel = new JPanel();
		//checkPanel.setBounds(150,170,300,20);
		//checkPanel.setBackground(Color.WHITE);
		
		for(int i = 0; i<factorName.length;i++)
		{
			factors[i] = new JCheckBox(factorName[i], false);
			checkPanel.add(factors[i]);
			//factors[i].addItemListener(this);
			
		}
		
		//밑에 button 생성 - 입력, 통계, 수면분석, 음악재생
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setBounds(100,100,400,350);
		
		belows[0] = new JButton(belowName[0]);
		buttonPanel.add(belows[0]);
		belows[0].addActionListener(this);
		/*
		for(int i = 0;i<belowName.length;i++)
		{
			belows[i] = new JButton(belowName[i]);
			buttonPanel.add(belows[i]);
			belows[i].addActionListener(listener);
		}
		*/
		
		InputPanel.add(radioPanel);
		InputPanel.add(spinnerPanel);
		InputPanel.add(checkPanel);
		
		contentPane.add(InputPanel, BorderLayout.CENTER);

		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		add(contentPane);

	}
	
	public void actionPerformed(ActionEvent e) 
	{

		// TODO Auto-generated method stub

		if (e.getSource() == belows[0]) {
			
			sleepH = (int) Hour.getValue();
			sleepM = (int) Minute.getValue();
			wakeH = (int) Hour_1.getValue();
			wakeM = (int) Minute_1.getValue();
			
			sleepTime = ((wakeH+24) * 60 + wakeM) - (sleepH * 60 + sleepM);
			
			for(int i=0; i<DayOfWeek.length; i++)
			{
				if(days[i].isSelected())
				{
					day = i;
					break;
				}
				
			}
			for(int i=0;i<3;i++)
			{
				if(factors[i].isSelected())
				{
					//System.out.println("true");
					factorTF[i] = true;
				}
				else
				{
					//System.out.println("false");
					factorTF[i]=false;
				}
			}
			goodsleep.info[day]=new Info(day,sleepTime,factorTF[0], factorTF[1], factorTF[2]);
			//nmain.showstatistic();
			DrawingPanel.inputvalue(goodsleep.info[day],day);
			new JPanel033();
			checkWarning.calculfactors(goodsleep.info);
			//new Statistics();
			

		}

	}
}

class JPanel022 extends JPanel
{
	public JPanel022()
	{
		JFrame frame = new JFrame();
		Container contentPane = frame.getContentPane();
		setLayout(new BorderLayout());
		
		//JPanel contentPane = new JPanel();
		contentPane = frame.getContentPane();
		DrawingPanel drawingPanel = new DrawingPanel();
		
		contentPane.add(drawingPanel);
		// 그래프를 그릴 패널
		add(contentPane,BorderLayout.CENTER);
		JPanel controlPanel1 = new JPanel();
		JPanel controlPanel2 = new JPanel();
		
		
		add(controlPanel2, BorderLayout.SOUTH);
		
		//drawingPanel.inputvalue();
		
		controlPanel1.add(new JLabel("최단 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.minhour + "시간  "));

		controlPanel1.add(new JLabel("최장 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.maxhour + "시간  "));
	
		controlPanel1.add(new JLabel("평균 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.avghour + "시간"));
	
		contentPane.add(controlPanel1, BorderLayout.NORTH);
		//contentPane.setVisible(true);
		frame.setVisible(true);
		frame.pack();
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
	}
}

class JPanel033 extends JPanel
{
	public JPanel033()
	{
		//System.out.println("frame3");
		JFrame frame = new JFrame();
		Container contentPane = frame.getContentPane();
		setLayout(new BorderLayout());
		
		String[] factorName = { "음주", "야식", "카페인" };
		contentPane = frame.getContentPane();
		DrawingPanel_factor drawingPanel = new DrawingPanel_factor();

		
		checkWarning.calculfactors(goodsleep.info);
		System.out.println(checkWarning.f1_cnt);
		System.out.println(checkWarning.f2_cnt);
		System.out.println(checkWarning.f3_cnt);
	
		 
		/*
		 * System.out.println("\nf1 : " + f1); System.out.println("f2 : " + f2);
		 * System.out.println("f3 : " + f3);
		 */
		
		drawingPanel.repaint();
		contentPane.add(drawingPanel);
		add(contentPane, BorderLayout.CENTER);
		
		JPanel statusPanel = new JPanel();

		ImageIcon good;
		ImageIcon just;
		ImageIcon bad;
		
		if(checkWarning.f1_cnt<3) {
			good = new ImageIcon("1.jpg");
			JButton bt1_good = new JButton(good);

			bt1_good.setBorderPainted(false); 
			bt1_good.setFocusPainted(false);
			bt1_good.setContentAreaFilled(false);
			statusPanel.add(bt1_good);
		}
		else if(checkWarning.f1_cnt>=3 && checkWarning.f1_cnt<5) { //warning
			
			just = new ImageIcon("2.jpg");
			JButton bt1_just = new JButton(just);
			bt1_just.setBorderPainted(false); 
			bt1_just.setFocusPainted(false);
			bt1_just.setContentAreaFilled(false);
			statusPanel.add(bt1_just);
		}
		else if(checkWarning.f1_cnt>=5) {//very warning
			bad = new ImageIcon("3.jpg");
			JButton bt1_bad = new JButton(bad);
			bt1_bad.setBorderPainted(false); 
			bt1_bad.setFocusPainted(false);
			bt1_bad.setContentAreaFilled(false);
			statusPanel.add(bt1_bad);
		}

		if(checkWarning.f2_cnt<2) {
			good = new ImageIcon("1.jpg");
			JButton bt2_good = new JButton(good);
			bt2_good.setBorderPainted(false); 
			bt2_good.setFocusPainted(false);
			bt2_good.setContentAreaFilled(false);
			statusPanel.add(bt2_good);
			//System.out.println("야식 good");
		}
		else if(checkWarning.f2_cnt>=2 && checkWarning.f2_cnt<4) {//warning
			just = new ImageIcon("2.jpg");
			JButton bt2_just = new JButton(just);
			bt2_just.setBorderPainted(false); 
			bt2_just.setFocusPainted(false);
			bt2_just.setContentAreaFilled(false);
			
			statusPanel.add(bt2_just);
		}
		else if(checkWarning.f2_cnt>=4) {
			bad = new ImageIcon("3.jpg");
			JButton bt2_bad = new JButton(bad);
			bt2_bad.setBorderPainted(false); 
			bt2_bad.setFocusPainted(false);
			bt2_bad.setContentAreaFilled(false);
			statusPanel.add(bt2_bad);
		}
		
		if(checkWarning.f3_cnt<4) {	
			good = new ImageIcon("1.jpg");
			JButton bt3_good = new JButton(good);
			bt3_good.setBorderPainted(false); 
			bt3_good.setFocusPainted(false);
			bt3_good.setContentAreaFilled(false);
			statusPanel.add(bt3_good);
			
		}else if(checkWarning.f3_cnt<=4 && checkWarning.f3_cnt>6) {
			just = new ImageIcon("2.jpg");
			JButton bt3_just = new JButton(just);
			bt3_just.setBorderPainted(false); 
			bt3_just.setFocusPainted(false);
			bt3_just.setContentAreaFilled(false);
			statusPanel.add(bt3_just);
		}
		else if(checkWarning.f3_cnt>=6) {
			bad = new ImageIcon("3.jpg");
			JButton bt3_bad = new JButton(bad);
			bt3_bad.setBorderPainted(false); 
			bt3_bad.setFocusPainted(false);
			bt3_bad.setContentAreaFilled(false);
			statusPanel.add(bt3_bad);
		}
		
		//statusPanel.setBackground(Color.WHITE);

		add(statusPanel, BorderLayout.NORTH);
		//frame.add(contentPane);
		frame.setVisible(true);
		frame.pack();

		

	}
	


}

class JPanel044 extends JPanel implements ActionListener
{
	
	public JPanel044()
	{
		setLayout(new BorderLayout( ));

		JPanel playPanel= new JPanel();

		
		JPanel musicPanel1 = new JPanel();
		JLabel musicLabel1 = new JLabel("8시간 깊은 수면 음악");
		JButton musicButton1 = new JButton("click1");
		musicButton1.addActionListener(this);
		musicPanel1.add(musicLabel1);
		musicPanel1.add(musicButton1);
		playPanel.add(musicPanel1);
		
		JPanel musicPanel2 = new JPanel();
		JLabel musicLabel2 = new JLabel("5분 안에 반드시 잠오는 ASMR 음악");
		JButton musicButton2 = new JButton("click2");
		musicButton2.addActionListener(this);
		musicPanel2.add(musicLabel2);
		musicPanel2.add(musicButton2);
		playPanel.add(musicPanel2);

		JPanel musicPanel3 = new JPanel();
		JLabel musicLabel3 = new JLabel("잠 잘오는 백색소음 음악");
		JButton musicButton3 = new JButton("click3");
		musicButton3.addActionListener(this);
		musicPanel3.add(musicLabel3);
		musicPanel3.add(musicButton3);
		playPanel.add(musicPanel3);

		
		add(playPanel,BorderLayout.CENTER);

		

	}
	public void actionPerformed(ActionEvent e) 
	{
		  String buttonString = e.getActionCommand( );

	        if (buttonString.equals("click1")) {
	    		try {
	    			System.out.println("click1 ok");
	    			Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=zm--TkytN_M/")); 
	    		}
	    		catch (IOException e1) 
	    		{ 
	    			e1.printStackTrace();
	    		}
	    		catch (URISyntaxException e1) {
	    			e1.printStackTrace(); 
	    		}
	        }
	        else if (buttonString.equals("click2")) {
	        	try {
	        		System.out.println("click2 ok");
	    			Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=KZQIaPl-smI")); 
	    		}
	    		catch (IOException e1) 
	    		{ 
	    			e1.printStackTrace();
	    		}
	    		catch (URISyntaxException e1) {
	    			e1.printStackTrace(); 
	    		}
	            
	        }
	        else if (buttonString.equals("click2")) {
	          	try {
	          			System.out.println("click3 ok");
	        			Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=lvKD8zBT4mw")); 
	        		}
	        		catch (IOException e1) 
	        		{ 
	        			e1.printStackTrace();
	        		}
	        		catch (URISyntaxException e1) {
	        			e1.printStackTrace(); 
	        		}
	        
	        }
	        else
	            System.out.println("Unexpected error.");


	}
}
public class panel_last extends JFrame {

	//goodsleep.init();
	String nname;
	public JPanel011 jpanel01 = null;
	public JPanel022 jpanel02 = null;
	public JPanel033 jpanel03 = null;
	public JPanel044 jpanel04 = null;
	public panel_last(String name)
	{
		nname = name;
		jpanel01 = new JPanel011();
		jpanel02 = new JPanel022();
		jpanel03 = new JPanel033();
		jpanel04 = new JPanel044();
		
		JTabbedPane jtab = new JTabbedPane();
		
		jtab.addTab("입력", jpanel01);
		jtab.addTab("통계", jpanel02);
		jtab.addTab("수면분석", jpanel03);
		jtab.addTab("음악재생", jpanel04);
		
		
		add(jtab);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		addWindowListener(new CheckOnExit());
		setVisible(true);
	}
	
	
	private class CheckOnExit extends WindowAdapter
	   {
	      
	      public void windowClosing(WindowEvent e)
	      {
	         PrintWriter outputStream = null;
	         File file = new File(nname);
	         FileWriter writer = null;
	         
	         try {
	            outputStream=
	                  new PrintWriter(new FileOutputStream(nname));

	         }
	         catch(FileNotFoundException e1) {
	            System.out.println("File not found");
	            System.out.println("or could not be opened");
	            System.exit(0);
	         }
	         
	         int i;
	         
	         for(i=0;i<7;i++)
	         {
	            if(goodsleep.info[i].toString() == null)
	               continue;
	            outputStream.write(goodsleep.info[i].toString());
	            outputStream.flush();
	         }
	         
	      }
	   }

}
