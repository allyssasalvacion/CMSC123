package list;

/**
 * Created by Allyssa Albores on 20/07/2017.
 */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();
        MyLinkedList<String> list2 = new MyLinkedList<String>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");

        list.remove("2");

        for(String s : list) {
            System.out.print(s + " ");
        }
    }
}
