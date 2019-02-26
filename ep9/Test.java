public class Test {
    private static int a = 0, b = 0;

    private static int add() {
        return a + b;
    }

    public static void main(String[] args) {
        a = 2;
        b = 3;
        System.out.println(add());
    }
}
