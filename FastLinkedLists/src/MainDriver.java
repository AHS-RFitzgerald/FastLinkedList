
import java.util.*;

public class MainDriver {

    public static void main(String[] args) {
        FastLinkedList<Integer> list = new FastLinkedList<Integer>();
        System.out.println(list);

        for (int k = 0; k < 21; k++) {
            list.insert(k);
        }

        System.out.println("nodes at level 0: " + list);
        System.out.println("nodes at level 1: " + list.toString(1));
        System.out.println("nodes at level 2: " + list.toString(2));
        System.out.println("nodes at level 3: " + list.toString(3));
        System.out.println("nodes at level 4: " + list.toString(4));
        System.out.println("nodes at level 5: " + list.toString(5));
        System.out.println("nodes at level 6: " + list.toString(6));
        System.out.println("nodes at level 7: " + list.toString(7));
        System.out.println("nodes at level 8: " + list.toString(8));
        System.out.println();

        if (list.contains(3)) {
            System.out.println("3 is in the list\n");
        } else {
            System.out.println("3 is in not the list\n");
        }

        list.delete(3);
        System.out.println(list);
        System.out.println("3 is deleted");

        int len = list.length();
        list.delete(len);
        System.out.println(list);
        System.out.println(len + " is deleted");

        list.delete(0);
        System.out.println(list);
        System.out.println("0 is deleted");

        list.insert(5);
        System.out.println(list);
        System.out.println("two 5s");
        list.delete(5);
        System.out.println(list);
        System.out.println("5 is deleted");
        //PLEASE ADD MORE TEST CASES TO MAKE SURE YOUR IMPLEMENTATION WORKS!
    }
}
