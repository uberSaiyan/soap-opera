import java.util.*;

public class LogSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputArr = {24, 17, 12, 11, 5, 0, 0, 0, 0, 0, 0};
        printArray(inputArr);
        System.out.println(find(inputArr, sc.nextInt()));
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(" " + i);
        }   
        System.out.println("]");
    }

    // O(log m) time
    static int getSmallestZeroIndex(int[] arr) {
        int oneBasedIndex = 1;
        while (arr[oneBasedIndex-1] != 0) {
            oneBasedIndex *= 2;
        }
        return oneBasedIndex;
    }

    // find x in O(log m) time, where m is the number of 
    // non-zero ints in the arr
    // returns index of x if found, otherwise return -1
    static int find(int[] arr, int x) {
        int back = getSmallestZeroIndex(arr);
        int front = 1;
        while (front != back - 1) {
            int temp = (front - 1 + back - 1) / 2;
            if (arr[temp] == x) {
                return temp;
            }
            else if (arr[temp] > x) {
                front = temp + 1;
            }
            else {
                back = temp + 1;
            }
        }
        return -1;
    }
}
