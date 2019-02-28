import java.util.*;

public class StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        System.out.println("There are " + stringCount(input) + " combinations.");
    }

    static int stringCount(int input) {
        return stringCount(input, 1, 1, 1);
    }

    static int stringCount(int input, int n, int xCount, int aCount) {
        if (input == n) {
            return xCount + aCount;
        }
        else if (input > n) {
            return stringCount(input, n + 1, aCount, xCount + aCount);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
