import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class DrawingPanel_factor extends JPanel {

	public void paint(Graphics g) {

			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawLine(50, 250, 350, 250);
			for (int cnt = 0; cnt < 8; cnt++) {
				g.drawString(cnt * 1 + "", 25, 255 - 20 * cnt);
				g.drawLine(50, 250 - 20 * cnt, 350, 250 - 20 * cnt);
				// g.drawLine(50,100,100,100);
			}
			g.drawLine(50, 90, 50, 250);
			g.drawString("음주", 100, 270);
			g.drawString("야식", 200, 270);
			g.drawString("카페인", 300, 270);
			g.setColor(Color.RED);

		/*
		 * System.out.println("f1: " +checkWarning.f1_cnt); System.out.println("f2: "
		 * +checkWarning.f2_cnt); System.out.println("f3: " +checkWarning.f3_cnt);
		 */

			if (checkWarning.f1_cnt > 0)
				g.fillRect(110, 250 - checkWarning.f1_cnt * 20, 10, checkWarning.f1_cnt * 20);
			if (checkWarning.f2_cnt > 0)
				g.fillRect(210, 250 - checkWarning.f2_cnt * 20, 10, checkWarning.f2_cnt * 20);
			if (checkWarning.f3_cnt > 0)
				g.fillRect(310, 250 - checkWarning.f3_cnt * 20, 10, checkWarning.f3_cnt * 20);
			
			
			
		}
	}