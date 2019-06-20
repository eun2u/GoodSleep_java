import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import java.awt.Font;

public class Input extends JFrame{
	public Input() {
	}

	private JPanel contentPane;
	private JFrame frame;
	static JCheckBox[] factors = new JCheckBox[3];
	String[] factorName = {"음주", "야식", "카페인"};
	static JButton[] belows = new JButton[4];
	String[] belowName = {"입력", "통계", "수면분석", "음악재생"};
	static JSpinner Hour, Minute, Hour_1, Minute_1;
	static JRadioButton days[] = new JRadioButton[7];
	static String[] DayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	//File file = new File("")
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		goodsleep.init();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Input().createAndshowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void createAndshowGUI() {
	
		frame = new JFrame("Good Sleep");
		contentPane = new JPanel(new BorderLayout());
		EventHandle listener = new EventHandle();
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
			days[i].addActionListener(listener);
		}
		
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
		
		Hour.addChangeListener(listener);
		Minute.addChangeListener(listener);
		Hour_1.addChangeListener(listener);
		Minute_1.addChangeListener(listener);
		
		//check box 생성
		JPanel checkPanel = new JPanel();
		//checkPanel.setBounds(150,170,300,20);
		//checkPanel.setBackground(Color.WHITE);
		
		for(int i = 0; i<factorName.length;i++)
		{
			factors[i] = new JCheckBox(factorName[i], false);
			checkPanel.add(factors[i]);
			factors[i].addItemListener(listener);
			
		}
		
		//밑에 button 생성 - 입력, 통계, 수면분석, 음악재생
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setBounds(100,100,400,350);
		
		for(int i = 0;i<belowName.length;i++)
		{
			belows[i] = new JButton(belowName[i]);
			buttonPanel.add(belows[i]);
			belows[i].addActionListener(listener);
		}
		
		InputPanel.add(radioPanel);
		InputPanel.add(spinnerPanel);
		InputPanel.add(checkPanel);
		
		contentPane.add(InputPanel, BorderLayout.CENTER);
		//contentPane.add(spinnerPanel, BorderLayout.CENTER);
		//contentPane.add(checkPanel, BorderLayout.CENTER);
		//contentPane.add(new JButton("로그아웃"), BorderLayout.SOUTH);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setBounds(100, 100, 400, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}

}
