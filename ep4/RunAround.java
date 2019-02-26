import java.util.Scanner;
public class RunAround {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int numberToCheck = myScanner.nextInt();
        int storedNumber = numberToCheck;
        myScanner.close();
        /*
           if (isRunAroundNumber(numberToCheck)) {
           System.out.println(numberToCheck + " is a runaround number.");
           }
           else {
           System.out.println(numberToCheck + " is not a runaround number.");
           }
         */
        while (!isRunAroundNumber(numberToCheck)) {
            numberToCheck++;
        }
        System.out.println("Smallest runaround number above " +
                storedNumber + " is " + numberToCheck + ".");
    }

    static boolean isRunAroundNumber(int number) {
        int numberOfDigits = getNumberOfDigits(number);
        int[] digitArr = new int[numberOfDigits];
        boolean[] boolArr = new boolean[numberOfDigits];
        populateArray(digitArr, number);
        if (isValidNumber(digitArr)) {
            int j = 0;
            for (int i = 0; i < numberOfDigits; i++) {
                j = (j + digitArr[j]) % numberOfDigits;
                boolArr[j] = true;
            }
            boolean result = true;
            for (int i = 0; i < numberOfDigits; i++) {
                result = result && boolArr[i];
            }
            return result;
        }
        else {
            return false;
        }
    }

    static boolean isValidNumber(int[] arr) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    result = false;
                }
            }
        }
        return result;
    }

    static int getNumberOfDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    static void populateArray(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            int digit = number % 10;
            number /= 10;
            arr[arr.length - 1 - i] = digit;
        }
    }
}
