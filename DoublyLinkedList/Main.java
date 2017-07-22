package list;

import java.util.List;

/**
 * Created by Allyssa Albores on 20/07/2017.
 */

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
        DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
        List<String> list3;

        list1.append("A");
        list1.append("B");
        list1.append("C");
        list1.append("D"); //
        list1.append("E");
        list1.append("F"); //
        list1.append("G");

        list2.append("1");
        list2.append("2");
        list2.append("3");
        list2.append("4"); //
        list2.append("5");
        list2.append("6"); //
        list2.append("7");

        list2.reverse();

        for(String s : list2) {
            System.out.println(s);
        }

    }
}
