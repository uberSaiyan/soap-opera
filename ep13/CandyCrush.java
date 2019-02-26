import java.util.Scanner;
public class CandyCrush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfRows = sc.nextInt();
        int numberOfCols = sc.nextInt();

        int[][] matrix = new int[numberOfRows][numberOfCols];
        Point[] colourfulCandies = new Point[10];
        int numberOfColourfulCandies = 0;
        int max = 0;

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                int input = sc.nextInt();
                matrix[row][col] = input;
                if (input == -1) {
                    colourfulCandies[numberOfColourfulCandies] = new
                        Point(row, col);
                    numberOfColourfulCandies++;
                }
            }
        }

        for (Point pt : colourfulCandies) {
            if (pt instanceof Point) {
                int temp = checkSurroundings(matrix, pt);       
                max = temp > max ? temp : max;
            }
        }

        max += 1; // account for colourful candy
        System.out.println(max);
    }

    private static int checkSurroundings(int[][] matrix, Point pt) {
        int actualMax = matrix.length * matrix[0].length - 1;
        int max = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int r = pt.getRow();
        int c = pt.getCol();
        if (r > 0) { // check up
            int toCheck = matrix[r-1][c];
            if (toCheck == -1) {
                return actualMax;
            }
            else {
                int temp = countEntries(matrix, toCheck);
                max = temp > max ? temp : max;
            }
        }
        if (r < maxRow - 1) { // check down
            int toCheck = matrix[r+1][c];
            if (toCheck == -1) {
                return actualMax;
            }
            else {
                int temp = countEntries(matrix, toCheck);
                max = temp > max ? temp : max;
            }
        }
        if (c > 0) { // check left
            int toCheck = matrix[r][c-1];
            if (toCheck == -1) {
                return actualMax;
            }
            else {
                int temp = countEntries(matrix, toCheck);
                max = temp > max ? temp : max;
            }
        }
        if (c < maxCol - 1) { // check right
            int toCheck = matrix[r][c+1];
            if (toCheck == -1) {
                return actualMax;
            }
            else {
                int temp = countEntries(matrix, toCheck);
                max = temp > max ? temp : max;
            }
        }
        return max;
    }

    private static int countEntries(int[][] matrix, int e) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == e) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Point {
    private int _row;
    private int _col;

    Point(int row, int col) {
        _row = row;
        _col = col;
    }

    int getRow() {
        return _row;
    }

    int getCol() {
        return _col;
    }
}
