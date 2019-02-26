public class CombiningNumbers {
    public static void main(String[] args) {
        int[] input = {50, 2, 1, 9};
        System.out.println(finalCombi(input));
    }

    static int finalCombi(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = largestCombi(result, arr);
        }
        return result;
    }

    static int largestCombi(int a, int[] arr) {
        int result = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = combineTwo(a, arr[i]);
            if (temp > result) { 
                result = temp;
                index = i;
            }
        }
        arr[index] = 0;
        return result;
    }

    static int combineTwo(int a, int b) {
        int first = a + b * (int)Math.pow(10, numberOfDigits(a));
        int second = b + a * (int)Math.pow(10, numberOfDigits(b));
        return first > second ? first : second;
    }

    static int numberOfDigits(int a) {
        int result = 0;
        while (a > 0) {
            a /= 10;
            result++;
        }
        return result;
    }
}
