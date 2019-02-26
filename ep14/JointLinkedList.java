import java.util.LinkedList;

public class JointLinkedList {
    LinkedList<Integer> run() {
        // create joint linked lists
        // headOne: 1 2 
        //                6 7 8 9
        // headTwo: 3 4 5 
        LinkedList<Integer> headOne = new LinkedList<Integer>();
        LinkedList<Integer> headTwo = new LinkedList<Integer>();
        
        headOne.add(6);
        headOne.add(7);
        headOne.add(8);
        headOne.add(9);

        LinkedList<Integer> tester = headOne;
        
        headTwo.add(3);
        headTwo.add(4);
        headTwo.add(5);

        headTwo.addAll(headOne);
        
        headOne.addFirst(2);
        headOne.addFirst(1);
       
        System.out.println(headOne);
        System.out.println(headTwo);

        // remove until get the common nodes
        while (headOne.size() > 0 && headTwo.size() > 0) {
            Integer topElement = headOne.peek();
            Integer botElement = headTwo.peek();
            if (topElement == botElement) {
                break;                
            }
            else if (topElement > botElement) {
                headTwo.remove();
            }
            else { // topElement < botElement
                headOne.remove();
            }
        }
        
        System.out.println(headTwo == headOne);
        System.out.println(headTwo == tester);
        System.out.println(headOne == tester);
        return headOne;
    }

    public static void main(String[] args) {
        JointLinkedList test = new JointLinkedList();
        System.out.println(test.run());
    }
}
