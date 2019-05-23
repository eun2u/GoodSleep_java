
public class checkWarning {

	private int factor1;
	private int factor2;
	private int factor3;
	
	
	public checkWarning() {
		
		factor1=0;
		factor2=0;
		factor3=0;
		
	}
	public checkWarning(Info[] info) {
	
		int f1_cnt=0;
		int f2_cnt=0;
		int f3_cnt=0;

		for(int i=1;i<=7;i++) {
			if(info[i]!=null) {
				if(info[i].getFact1()==true) 
					f1_cnt++;
				if(info[i].getFact2()==true)
					f2_cnt++;
				if(info[i].getFact3()==true)
					f3_cnt++;
			}
		}
		
		setFactor1(f1_cnt);
		setFactor1(f2_cnt);
		setFactor1(f3_cnt);
		
	}

	public int getFactor1() {
		return factor1;
	}

	public void setFactor1(int factor1) {
		this.factor1 = factor1;
	}

	public int getFactor2() {
		return factor2;
	}

	public void setFactor2(int factor2) {
		this.factor2 = factor2;
	}

	public int getFactor3() {
		return factor3;
	}

	public void setFactor3(int factor3) {
		this.factor3 = factor3;
	}
	
}
