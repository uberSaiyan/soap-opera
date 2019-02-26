import java.util.*;
public class ArrangingNumbers {
    public static void main(String[] args) {
        int[] digitCount = new int[10];
        // Note that by default each index is initialised
        // at 0 for int[]
        Scanner myScanner = new Scanner(System.in);
        int inputNumber = myScanner.nextInt();
        myScanner.close();
        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            digitCount[lastDigit]++;
            inputNumber /= 10;
        }
        boolean valid = true;
        int smallestPerm = 0;
        int biggestPerm = 0;
        for (int i = 0; i < 9; i++) {
            if (digitCount[i] == 4) {
                valid = false;
                break;
            }
            else {
                while (digitCount[i] > 0) {
                    smallestPerm *= 10;
                    smallestPerm += i;
                    biggestPerm /= 10;
                    biggestPerm += i * 1000;
                    digitCount[i]--;
                }
            }
        }
        if (!valid) {
            System.out.println("Invalid input.");
        }
        else {
            System.out.println("Biggest number: " + biggestPerm);
            System.out.println("Smallest number: " + smallestPerm);
        }
    }
}
