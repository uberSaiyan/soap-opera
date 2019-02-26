import java.lang.*;     //optional
import java.util.*;

class TestScanner2 {

	public static void main( String[] args ) {
                /*  input is 
                    
                    3   // number of rows
                    4   // number of columns
                    1 2 3 4
                    5 6 7 8
                    2 4 6 8
                    COL 3
                */
		Scanner input = new Scanner(System.in);

		System.out.println("Before reading row and column");
		int row= input.nextInt();
		int col= input.nextInt();
                int [][] matrix = new int[row][col];   // create dynamic array

		System.out.println("Before reading the matrix");
		for (int i = 0; i < row; i++) 
		    for (int j = 0; j < col; j++) 
			matrix[i][j] = input.nextInt();

        input.nextLine();

		System.out.println("Trying to read query");
        String line = input.nextLine();     // to read the next line,
                                           // in this example, "COL 3"
		System.out.println("The query is " + line); //explain why line is empty here
 
		System.out.println("Creating the second Scanner");
        Scanner myScan = new Scanner(line); // it is possible to create
                                            // a second scanner object
                                            // with a different input 
                                            // stream
                
		System.out.println("trying to get  the query");
        String query = myScan.next();       // suppose to read COL in the example


                int queryNum = myScan.nextInt();

                if (query.equals("COL")) 
                      for (int i = 0; i < row; i++) 
                           System.out.println(matrix[i][queryNum]);
                else
                      for (int j = 0; j < col; j++) 
                           System.out.println(matrix[queryNum][j]);
                
	}
}
