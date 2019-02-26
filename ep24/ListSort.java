public class ListSort {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(9);
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(7);
        list.add(7);

        list.print();
        list.sort();
        list.print();
    }


}
