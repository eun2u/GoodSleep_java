import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//�׷����� �׸��� �г� Ŭ����
public class DrawingPanel extends JPanel {
	
	int week[] = new int[7];
	int max=0, min=9999;
	int day, time;
	double avg=0;
	String maxhour, minhour,avghour;
	
	public void inputvalue() {		
		
		//week[day] = time;
		
		this.week[0] = 180; //��
		this.week[1] = 300; //ȭ
		this.week[2] = 360; //...
		this.week[3] = 180;
		this.week[4] = 240;
		this.week[5] = 630;
		this.week[6] = 660;
		
		int valued_cnt = 0;

		for (int i = 0; i < 7; i++) {

			if (week[i] != 0) {
				valued_cnt++; // '0'�� �ƴ� ����ð� ���� üũ
				
				if (max < this.week[i])
					max = this.week[i];

				if (min > this.week[i])
					min = this.week[i];
				
				avg += week[i];
			}
		}
		max = max/60;
		min = min/60;
		avg = avg / valued_cnt;
		avg = avg/60;
		avg = Math.round(avg*100)/100.0; //�Ҽ��� �Ʒ� 2�ڸ�
		maxhour = String.valueOf(max);
		minhour = String.valueOf(min);
		avghour = Double.toString(avg);

	}
	
	
	public void paint(Graphics g) { //paint()�޼ҵ�� GUI application�� ����ɶ� ȣ���!
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(30, 250, 350, 250); //�� �Ʒ���
		
		g.drawString("����", 5, 20);
		g.drawString("�ð�", 5, 34);
		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt + 2 + "", 10, 255 - 20 * cnt); //�� ����ð� ���� ����
			g.drawLine(30, 250 - 20 * cnt, 350, 250 - 20 * cnt); //�ð����� ��
		}
		
		
		g.drawLine(30, 30, 30, 250); //���� �� ���� ��
		
		//���ϱ۾�
		g.drawString("��", 45, 270);
		g.drawString("ȭ", 90, 270);
		g.drawString("��", 135, 270);
		g.drawString("��", 180, 270);
		g.drawString("��", 225, 270);
		g.drawString("��", 270, 270);
		g.drawString("��", 315, 270);
		
		//����׷��� ����
		g.setColor(Color.BLUE);
		if (week[0] > 0)
			g.fillRect(42, 250 - ((week[0]/60)-2)*20 , 20, ((week[0]/60)-2)*20);
		if (week[1] > 0)
			g.fillRect(87, 250 - ((week[1]/60)-2)*20, 20, ((week[1]/60)-2)*20);
		if (week[2] > 0)
			g.fillRect(132, 250 - ((week[2]/60)-2)*20, 20, ((week[2]/60)-2)*20);
		if (week[3] > 0)
			g.fillRect(177, 250 - ((week[3]/60)-2)*20, 20, ((week[3]/60)-2)*20);
		if (week[4] > 0)
			g.fillRect(222, 250 - ((week[4]/60)-2)*20, 20, ((week[4]/60)-2)*20);
		if (week[5] > 0)
			g.fillRect(267, 250 - ((week[5]/60)-2)*20, 20, ((week[5]/60)-2)*20);
		if (week[6] > 0)
			g.fillRect(312, 250 - ((week[6]/60)-2)*20, 20, ((week[6]/60)-2)*20);
	
	}

	/*
	void setScores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}*/
}

