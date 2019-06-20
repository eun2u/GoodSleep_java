import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Statistics {
	public static void main(String args[]) {
		JFrame frame = new JFrame("GoodSleep");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 400));
		Container contentPane = frame.getContentPane();
		DrawingPanel drawingPanel = new DrawingPanel();
		
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		// 그래프를 그릴 패널

		JPanel controlPanel1 = new JPanel();
		JPanel controlPanel2 = new JPanel();
		
		//frame.add(controlPanel1);
		
		
		JButton button1 = new JButton("입력");
		JButton button2 = new JButton("통계");
		JButton button3 = new JButton("수면분석");
		JButton button4 = new JButton("음악재생");
		
		
		controlPanel2.add(button1);
		controlPanel2.add(button2);
		controlPanel2.add(button3);
		controlPanel2.add(button4);
		contentPane.add(controlPanel2, BorderLayout.SOUTH);
		
		drawingPanel.inputvalue();
		
		controlPanel1.add(new JLabel("최단 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.minhour + "시간  "));

		controlPanel1.add(new JLabel("최장 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.maxhour + "시간  "));
	
		controlPanel1.add(new JLabel("평균 시간:"));
		controlPanel1.add(new JLabel(drawingPanel.avghour + "시간"));
	
		contentPane.add(controlPanel1, BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
		// "그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
		frame.pack();
		frame.setVisible(true);
	}
}

/*
//버튼 눌렀을때 동작하는 리스너
class DrawActionListener implements ActionListener {
	JTextField text1, text2, text3;
	DrawingPanel drawingPanel;

	DrawActionListener(JTextField text1, JTextField text2, JTextField text3, DrawingPanel drawingPanel) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.drawingPanel = drawingPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			//int korean = Integer.parseInt(text1.getText());
			//int english = Integer.parseInt(text2.getText());
			//int math = Integer.parseInt(text3.getText());
			int korean = 80;
			int english = 70;
			int math = 60;
			drawingPanel.setScores(korean, english, math);
			drawingPanel.repaint();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(drawingPanel, "잘못된 숫자 입력입니다", "에러메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
}*/