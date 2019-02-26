import java.util.Scanner;
public class MagicSquare {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
 
        int order = myScanner.nextInt();
        // NOTE: order must be odd
        
        int[][] matrix = new int[order][order];
        // NOTE: all entries initialized to 0

        int row = 1;
        int col = 0;
        int numberOfEntries = order * order;

        for (int i = 0; i < numberOfEntries; i++) {
            // go diagonally up+right
            int tempRow = (row - 1 + order) % order;
            int tempCol = (col + 1) % order;
            if (matrix[tempRow][tempCol] != 0) {
                // go down
                row = (row + 1) % order;
            }
            else {
                row = tempRow;
                col = tempCol;
            }
            matrix[row][col] = i + 1;
        }
        
        // print out matrix in proper form
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        
        int magicConstant = 0;

        for (int i = 0; i < order; i++) {
            magicConstant += matrix[0][i];
        }
        
        System.out.println("The magic constant is " + magicConstant);
    }
}
