package soapopera.ep2;

import java.util.Scanner;

class AddingNumbersEfficiently {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int[] inputArray = {2, 1, 3, 5, 6, 4, 7, 8, 9, 10};
        int[] summedArray = new int[inputArray.length];
        summedArray[0] = inputArray[0];
        for (int i = 1; i < summedArray.length; i++) {
            summedArray[i] = summedArray[i - 1] + inputArray[i];
        }

        System.out.print("Enter first index: ");
        int firstIndex = myScanner.nextInt();
        System.out.print("Enter second index: ");
        int secondIndex = myScanner.nextInt();
        myScanner.close();
        int result = summedArray[secondIndex] - summedArray[firstIndex - 1];
        System.out.println(result);
    }
}