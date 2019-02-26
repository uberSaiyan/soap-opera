import java.util.*;

public class StackPermutations {
    public static void main(String[] args) {
        StackPermutations sp = new StackPermutations();
        sp.run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> originalStack = new Stack<Integer>();
        Queue<Integer> resultStack = new Queue<Integer>();
        int noOfNumbers = sc.nextInt();
        for (int i = 0; i < noOfNumbers; i++) {
            originalStack.push(sc.nextInt());
        }
        for (int i = 0; i < noOfNumbers; i++) {
            resultStack.offer(sc.nextInt());
        }
        String resultString = "";
        while 
    }
    
    
}
