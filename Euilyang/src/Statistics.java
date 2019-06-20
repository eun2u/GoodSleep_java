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
		// �׷����� �׸� �г�

		JPanel controlPanel1 = new JPanel();
		JPanel controlPanel2 = new JPanel();
		
		//frame.add(controlPanel1);
		
		
		JButton button1 = new JButton("�Է�");
		JButton button2 = new JButton("���");
		JButton button3 = new JButton("����м�");
		JButton button4 = new JButton("�������");
		
		
		controlPanel2.add(button1);
		controlPanel2.add(button2);
		controlPanel2.add(button3);
		controlPanel2.add(button4);
		contentPane.add(controlPanel2, BorderLayout.SOUTH);
		
		drawingPanel.inputvalue();
		
		controlPanel1.add(new JLabel("�ִ� �ð�:"));
		controlPanel1.add(new JLabel(drawingPanel.minhour + "�ð�  "));

		controlPanel1.add(new JLabel("���� �ð�:"));
		controlPanel1.add(new JLabel(drawingPanel.maxhour + "�ð�  "));
	
		controlPanel1.add(new JLabel("��� �ð�:"));
		controlPanel1.add(new JLabel(drawingPanel.avghour + "�ð�"));
	
		contentPane.add(controlPanel1, BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
		// "�׷��� �׸���" ��ư�� �������� �۵� �� �����͵��
		frame.pack();
		frame.setVisible(true);
	}
}

/*
//��ư �������� �����ϴ� ������
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
			JOptionPane.showMessageDialog(drawingPanel, "�߸��� ���� �Է��Դϴ�", "�����޽���", JOptionPane.ERROR_MESSAGE);
		}
	}
}*/