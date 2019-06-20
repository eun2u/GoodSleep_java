
public class Info {

	private int time;
	private boolean factor1,factor2,factor3;
	
	public Info() {
		time=0;
		factor1=false;
		factor2=false;
		factor3=false;
	}
	public Info(int thetime,
			boolean thefact1, boolean thefact2,boolean thefact3){
		
		setTime(thetime);
		setFactors(thefact1,thefact2,thefact3);
			
	}

	public void setTime(int time) {
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
	public void setFactors(boolean factor1,boolean factor2, boolean factor3) {
		this.factor1 = factor1;
		this.factor2=factor2;
		this.factor3=factor3;
	}
	public boolean getFact1() {
		return factor1;
	}
	public boolean getFact2() {
		return factor2;
	}
	public boolean getFact3() {
		return factor3;
	}
	
	
}
