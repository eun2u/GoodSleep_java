
public class Info {

	private int day;
	private int time;
	private boolean factor[] = new boolean[3];
	
	public Info() {
		day = -1;
		time = 0;
		for(int i=0;i<3;i++)
			factor[i] = false;
	}
	public Info(int day, int thetime,
			boolean thefact1, boolean thefact2,boolean thefact3){
		setDay(day);
		setTime(thetime);
		setFactors(thefact1,thefact2,thefact3);
			
	}

	public void setDay(int day) {
		// TODO Auto-generated method stub
		this.day = day;
	}
	
	public int getDay()
	{
		return day;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
	public void setFactors(boolean factor1,boolean factor2, boolean factor3) {
		this.factor[0] = factor1;
		this.factor[1]=factor2;
		this.factor[2]=factor3;
	}
	public boolean getFact1() {
		return factor[0];
	}
	public boolean getFact2() {
		return factor[1];
	}
	public boolean getFact3() {
		return factor[2];
	}
	public String toString()
	{
		char a[] = new char[3];
		for(int i = 0;i<3;i++) {
			if(factor[i] == true)
				a[i] = 't';
			else
				a[i] = 'f';
		}
			
		
		if(day == -1)
			return null;
		else
			return day + " " + time + " " + a[0] + " " + a[1] + " " + a[2] + "\n";	
	}
	
	
}
