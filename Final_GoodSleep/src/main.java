
import java.awt.Window;
import javax.swing.JFrame;

public class main {
	start loginview;
	//Input newinput;
	//Statistics newstatistic;
	panel_last lastview;
	String name;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		main nmain = new main();
		nmain.loginview = new start();
		nmain.loginview.setMain(nmain);
	}
	
	public void showSecondTest()
	{
		name = loginview.getFile();
		goodsleep.init(name);
		this.lastview = new panel_last(name);
	}


}
