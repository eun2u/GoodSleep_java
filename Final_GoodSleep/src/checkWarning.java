
public class checkWarning {
	
	static int f1_cnt=0;
	static int f2_cnt=0;
	static int f3_cnt=0;

	public static void calculfactors(Info[] info) {

		f1_cnt = 0;
		f2_cnt= 0;
		f3_cnt= 0;
		for(int i=0;i<7;i++) {
			if(info[i]!=null) {
				System.out.println(i + " " + info[i].getFact1()+ " " + info[i].getFact2()+ " " + info[i].getFact3());
				if(info[i].getFact1()==true) 
					f1_cnt++;
				if(info[i].getFact2()==true)
					f2_cnt++;
				if(info[i].getFact3()==true)
					f3_cnt++;
			}
		}		
	}

	public static int getFactor1() {
		return f1_cnt;
	}

	public static int getFactor2() {
		return f2_cnt;
	}
	public static  int getFactor3() {
		return f3_cnt;
	}

	
}
