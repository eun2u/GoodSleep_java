import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EventHandle implements ItemListener, ActionListener, ChangeListener{

	static boolean[] factorTF = new boolean[3];
	static int sleepH, sleepM, wakeH, wakeM, sleepTime;
	static int day;
	Info newInfo = new Info();
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			//System.out.println(e.getItem() + " 선택");
			if(e.getItem() == Input.factors[0])
			{
				factorTF[0] = true;
			}
			else if(e.getItem()== Input.factors[1])
			{
				factorTF[1] = true;
			}
			else if(e.getItem() == Input.factors[2])
			{
				factorTF[2] = true;
			}
		}
		if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			//System.out.println(e.getItem() + " 해제");
			if(e.getItem() == Input.factors[0])
			{
				factorTF[0] = false;
			}
			else if(e.getItem()== Input.factors[1])
			{
				factorTF[1] = false;
			}
			else
				factorTF[2] = false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i= 0; i<7;i++)
		{
			if(e.getSource().equals(Input.days[i]))
				day = i;
		}
		if(e.getSource().equals(Input.belows[1]))
		{
			System.out.printf("%s\n", Input.DayOfWeek[day]);
			System.out.printf("잠든시간  %d : %d\n", sleepH, sleepM);
			System.out.printf("일어난 시간  %d : %d\n", wakeH, wakeM);
			sleepTime = ((wakeH+24) * 60 + wakeM) - (sleepH * 60 + sleepM);
			
			for(int i = 0;i<3;i++)
			{
				System.out.print(factorTF[i] + " ");
			}
			
			goodsleep.info[day]=new Info(sleepTime,factorTF[0], factorTF[1], factorTF[2]);
		}
	}
	@Override
	public void stateChanged(ChangeEvent ce) {
		// TODO Auto-generated method stub
		sleepH = (int) Input.Hour.getValue();
		
		sleepM = (int) Input.Minute.getValue();
		
		wakeH = (int) Input.Hour_1.getValue();
		
		wakeM = (int) Input.Minute_1.getValue();
	}

}
