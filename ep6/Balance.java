
public class Balance {
    public static void main(String[] args) {
        int[] input = {10, 10};
        int sum = sumArray(input);
        int acc = 0;
        boolean result = false;
        for (int i = 0; i < input.length; i++) {
            if (acc < sum) {
                acc += input[i];
                sum -= input[i];
            }
            else if (acc == sum) {
                result = true;
                break;
            }
            else {
                break;
            }
        }
        System.out.println(result);
    }

    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int entry : arr) {
            sum += entry;
        }
        return sum;
    }
}
