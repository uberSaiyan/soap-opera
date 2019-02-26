import java.util.*;

public class Matrioshkas {
    public static void main(String[] args) {
        Matrioshkas test = new Matrioshkas();
        test.run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<Integer>();
        while (sc.hasNextInt()) {
            int input = sc.nextInt();
            if (input > 0) {
                if (s.empty()) {
                    System.out.println(":-( Try again.");
                    return;
                }
                else {
                    if (s.peek() == -input) {
                        s.pop();
                    }
                    else {
                        System.out.println(":-( Try again.");
                        return;
                    }
                }
            }
            else {
                if (s.empty()) {
                    s.push(input);
                }
                else {
                    if (s.peek() >= input) {
                        System.out.println(":-( Try again.");
                        return;
                    }
                    else {
                        s.push(input);
                    }
                }
            }
        }
        if (s.empty()) {
            System.out.println(":-) Matrioshka!");
        }
        else {
            System.out.println(":-( Try again.");
        }
    }
}
