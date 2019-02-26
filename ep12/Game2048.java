import java.util.Stack;
import java.util.Scanner;
public class Game2048 {
    public static void main(String[] args) {
        Game2048 test = new Game2048();
        test.run();
    }

    void run() {
        int[][] board = new int[4][4];
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int input = sc.nextInt();
                board[row][col] = input;
            }
        }
        int action = sc.nextInt();

        switch (action) {
            case 0: // go left
                shiftLeft(board);
                printBoard(board);
                break;
            case 1: // go up
                board = rotateLeft(board);
                shiftLeft(board);
                board = rotateRight(board);
                printBoard(board);
                break;
            case 2: // go right
                board = flip(board);
                shiftLeft(board);
                board = flip(board);
                printBoard(board);
                break;
            case 3: // go down
                board = rotateRight(board);
                shiftLeft(board);
                board = rotateLeft(board);
                printBoard(board);
                break;
        }
    }

    int[][] rotateRight(int[][] board) {
        int[][] newBoard = new int[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                newBoard[col][3 - row] = board[row][col];
            }   
        }
        return newBoard;
    }

    int[][] rotateLeft(int[][] board) {
        return rotateRight(rotateRight(rotateRight(board)));
    }

    int[][] flip(int[][] board) {
        return rotateRight(rotateRight(board));
    }

    void printBoard(int[][] board) {
        String str = "";
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                str += board[row][col];
                str += " ";
            }
            str = str.trim();
            str += "\n";
        }
        System.out.print(str);
    }

    void shiftLeft(int[][] board) {
        for (int i = 0; i < 4; i++) {
            int[] row = board[i];
            row = format(merge(row));
            board[i] = row;
        }
    }

    Object[] merge(int[] row) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int newInt : row) {
            if (newInt != 0) {
                if (!stack.empty()) {
                    if (newInt == stack.peek().intValue()) {
                        stack.pop();
                        stack.push(newInt * 2);
                        stack.push(0);
                        continue;
                    }
                }
                stack.push(newInt);
            }
        }
        return stack.toArray();
    }

    int[] format(Object[] row) {
        int[] formattedRow = new int[4];
        int index = 0;
        for (Object obj : row) {
            Integer curr = (Integer) obj;
            int value = curr.intValue();
            if (value != 0) {
                formattedRow[index] = value;
                index++;
            }
        }
        return formattedRow;
    }
}
