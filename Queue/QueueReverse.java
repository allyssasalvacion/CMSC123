package ThirdLongExam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Allyssa Albores on 25/07/2017.
 */
public class QueueReverse {
    public static void main(String[] args) {
        Queue<Object> q = new LinkedList<Object>();
        q.add("Allyssa");
        q.add("Mara");
        q.add("Star");
        q.add("Sansan");
        q.add("Joeb");
        q.add("Limar");
        q.add("Yenyen");

        int size = q.size();
        queueReverse(q);

        for(int i = 0; i < size; i++) {
            System.out.println(q.remove());
        }

    }

    public static void queueReverse(Queue q) {
        Stack<Object> stack = new Stack<Object>();
        for(int i = q.size(); i > 0; i--) {
            stack.push(q.remove());
        }

        for(int i = stack.size(); i > 0; i--) {
            q.add(stack.pop());
        }
    }
}
