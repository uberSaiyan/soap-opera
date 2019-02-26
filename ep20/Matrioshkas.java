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
                    int sum = 0;
                    while (s.peek() > 0) {
                        sum -= s.pop();
                    }
                    if (sum > s.peek() && s.peek() == -input) {
                        s.pop();
                        s.push(input);
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
                    s.push(input);
                }
            }
        }
        if (s.size() == 1 && s.peek() > 0) {
            System.out.println(":-) Matrioshka!");
            return;
        }
        else {
            System.out.println(":-( Try again.");
            return;
        }
    }
}
