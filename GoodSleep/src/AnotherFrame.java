import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class AnotherFrame extends JFrame {
	
    public AnotherFrame() {
    	
    	JFrame frame;
    	String[] factorName = {"음주", "야식", "카페인"};
    	JButton[] belows = new JButton[4];
    	String[] belowName = {"입력", "통계", "수면분석", "음악재생"};
    
    	frame = new JFrame("수면 분석");
    	JPanel contentPane = new JPanel(new BorderLayout());
  
    	JPanel buttonPanel = new JPanel();
		DrawingPanel drawingPanel = new DrawingPanel();
		
	
		goodsleep.init();
		
		
		drawingPanel.setScores(4, 2, 2);
		drawingPanel.repaint();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
    	
		
		JPanel statusPanel= new JPanel();
		
		ImageIcon good= new ImageIcon("1.jpg");
		JButton bt1 = new JButton(good);
		ImageIcon just= new ImageIcon("2.jpg");
		JButton bt2 = new JButton(just);
		ImageIcon bad= new ImageIcon("3.jpg");
		JButton bt3 = new JButton(bad);
		
		bt1.setBorderPainted(false); 
		bt1.setFocusPainted(false); 
		bt1.setContentAreaFilled(false);
		
		bt2.setBorderPainted(false); 
		bt2.setFocusPainted(false); 
		bt2.setContentAreaFilled(false);
		
		bt3.setBorderPainted(false); 
		bt3.setFocusPainted(false); 
		bt3.setContentAreaFilled(false);
		
		statusPanel.add(bt1);
		statusPanel.add(bt2);
		statusPanel.add(bt3);
	
		contentPane.add(statusPanel,BorderLayout.NORTH);

		
		
    	for(int i = 0;i<belowName.length;i++)
		{
			belows[i] = new JButton(belowName[i]);
			buttonPanel.add(belows[i]);
		}
    	contentPane.add(buttonPanel, BorderLayout.SOUTH);

    	
    	
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(contentPane);
		frame.setBounds(100,100, 400, 500);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);


    }
}
class DrawingPanel extends JPanel
{
	int fact1, fact2, fact3;
	public void paint(Graphics g){

		g.clearRect(0,0,getWidth(),getHeight());
		g.drawLine(50,250,350,250);
		for(int cnt = 0 ;cnt<8;cnt++)
		{
			g.drawString(cnt *1 +"",25,255-20*cnt);
			g.drawLine(50, 250-20*cnt, 350,250-20*cnt);
			//g.drawLine(50,100,100,100);
		}
		g.drawLine(50,90,50,250);
		g.drawString("야식",100,270);
		g.drawString("음주",200,270);
		g.drawString("카페인",300,270);
		g.setColor(Color.RED);
		
		if (fact1>0)
			g.fillRect(110,250-fact1*20,10,fact1*20);
		if(fact2>0)
			g.fillRect(210,250-fact2*20,10,fact2*20);
		if(fact3>0)
			g.fillRect(310,250-fact3*20,10,fact3*20);
	}
	void setScores(int fact1, int fact2, int fact3)
	{
		this.fact1=fact1;
		this.fact2=fact2;
		this.fact3=fact3;
	}
}

