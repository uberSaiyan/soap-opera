import java.util.*;

public class Useless {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(1);
        q.offer(4);
        q.offer(3);
        q.offer(2);
        q.offer(5);
        q.offer(7);
        q.offer(6);
        q.offer(9);
        q.offer(8);
        q.offer(10);
        System.out.println("Original: " + q);

        Stack<Integer> s = new Stack<Integer>();

        while (!q.isEmpty()) {
            if (s.isEmpty()) {
                s.push(q.poll());
            }
            else if (q.peek() == s.peek() + 1) {
                s.push(q.poll());
            }
            else {
                s.push(q.poll());
                int n = 1;
                while (q.peek() < s.peek()) {
                    s.push(q.poll());
                    n++;
                }
                int qSize = q.size();
                for (int i = 0; i < n; i++) {
                    q.offer(s.pop());
                }
                for (int i = 0; i < qSize; i++) {
                    s.push(q.poll());
                }
                for (int i = 0; i < qSize; i++) {
                    q.offer(s.pop());
                }
                for (int i = 0; i < n; i++) {
                    s.push(q.poll());
                }
                for (int i = 0; i < qSize; i++) {
                    s.push(q.poll());
                }
                for (int i = 0; i < qSize; i++) {
                    q.offer(s.pop());
                }
            }
        }
        System.out.println("Result: " + s);
    }
}
