import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class goodsleep {

	public static void init() {

		
		Scanner keyboard= new Scanner(System.in);
	//	String FileName= keyboard.nextLine();

		Scanner inputStream=null;
		try {
			inputStream=
					new Scanner(new FileInputStream("eunju.txt"));

		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.out.println("or could not be opened");
			System.exit(0);
		}


		Info info[]=new Info[8];
		int day, time ;
		String factor;
		boolean f1, f2, f3;


		//text -> °´Ã¼¿¡ ³Ö±â
		while(inputStream.hasNext()) {
			day=inputStream.nextInt();

			time=inputStream.nextInt();
			factor=inputStream.nextLine();

			String delimiters = " "; //Comma and blank space
			StringTokenizer nameFactory = 
					new StringTokenizer(factor, delimiters);    

			String f1String=nameFactory.nextToken();
			if(f1String.equalsIgnoreCase("t"))
				f1=true;
			else f1=false;

			String f2String=nameFactory.nextToken();
			if(f2String.equalsIgnoreCase("t"))
				f2=true;
			else f2=false;

			String f3String=nameFactory.nextToken();
			if(f3String.equalsIgnoreCase("t"))
				f3=true;
			else f3=false;


			info[day]=new Info(day,time,f1,f2,f3);
		}

	}
	public static void checkWarning(Info info[]) {
		
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


		if(f1_cnt<3) 
			System.out.println("\nok\n");
		else if(f1_cnt>=3 && f1_cnt<5) 
			//warning
			System.out.println(f1_cnt+ "warning!\n");		
		else if(f1_cnt>=5) 
			//warning!@!!!
			System.out.println("\nwarning!!!!!\n");


		if(f2_cnt<2) 
			System.out.println("\nok\n");		
		else if(f2_cnt>=2 && f2_cnt<4) 
			//warning		
			System.out.println(f2_cnt+"warning!\n");	
		else if(f2_cnt >=4)
			System.out.println("\nwarning!!!!!\n");


		if(f3_cnt<4)
			System.out.println(f3_cnt+"ok\n");
		else if(f3_cnt<=4 && f3_cnt>6)
			System.out.println("\nwarning!\n");
		else if(f3_cnt>=6)
			System.out.println("\nwarning!!!!!\n");

	}
	
}

