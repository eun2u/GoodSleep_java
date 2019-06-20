import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class goodsleep {

	static Info info[]=new Info[7];
	public static void init(String name) {

		for(int i = 0;i<7;i++)
			info[i] = new Info();
		
			Scanner inputStream=null;
			try {
				inputStream=
						new Scanner(new FileInputStream(name));

			}
			catch(FileNotFoundException e) {
				System.out.println("File not found");
				System.out.println("or could not be opened");
				System.exit(0);
			}


		
		int day, time ;
		String factor;
		boolean f1, f2, f3;


		//text -> °´Ã¼¿¡ ³Ö±â
		while(inputStream.hasNext()) {
			day=inputStream.nextInt();
			time=inputStream.nextInt();
			factor=inputStream.nextLine();

			//System.out.printf("%d %d %s\n", day, time, factor);
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
			
			info[day].setDay(day);
			info[day].setTime(time);
			info[day].setFactors(f1,f2,f3);
			DrawingPanel.inputvalue(goodsleep.info[day],day);
			
		}

	}
	
	
}

