package ThirdLongExam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Allyssa Albores on 25/07/2017.
 */
public class MassSuicide {
    public static void main(String[] args) {
        int n = 12;
        int m = 3;

        int answer = massSuicide(n, m);
        System.out.println("The answer is " + answer);
    }

    public static int massSuicide(int n, int m) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++) {
                queue.add(queue.remove());
            }
            stack.push(queue.remove());
        }

        return stack.pop();
    }
}
