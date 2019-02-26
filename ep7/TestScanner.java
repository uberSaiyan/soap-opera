import java.lang.*;     //optional
import java.util.*;

class TestScanner {

	public static void main( String[] args ) {
		Scanner input = new Scanner(System.in);
				int type = input.nextInt();
				if (type == 1)
		  			readProcess1(input);
				else 
					readProcess2(input);
		 
	}

	public static void readProcess1(Scanner input) {
		// Scanner read1 = new Scanner(System.in);
		double sum = 0.0;
		// int NumOfInput = read1.nextInt();
        int NumOfInput = input.nextInt();
		for (int i = 0; i < NumOfInput; i++) 
			sum += input.nextInt();
		System.out.println("Average is " + sum/NumOfInput);
	}

	public static void readProcess2(Scanner input) {
		// Scanner read2 = new Scanner(System.in);
		double sum = 0.0;
		int count = 0;
		//while (read2.hasNext()) {
        while (input.hasNext()) {
			sum += input.nextInt();
			count++;
		}
		System.out.println("Average is " + sum/count);
	}
}
