package ThirdLongExam;

import java.util.Stack;

/**
 * Created by Allyssa Albores on 25/07/2017.
 */
public class MergeStack {
    public static void main(String[] args) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();

        s1.push('C');
        s1.push('B');
        s1.push('A');
        s2.push('G');
        s2.push('F');
        s2.push('E');

        mergeStack(s1, s2);

        for(int i = s1.size(); i > 0; i--) {
            System.out.println(s1.pop());
        }
    }

    public static void mergeStack(Stack s1, Stack s2) {
        Stack<Object> s3 = new Stack<Object>();
        for(int i = s2.size(); i > 0; i--) {
            s3.push(s2.pop());
        }
        for(int i = s3.size(); i > 0; i--) {
            s1.push(s3.pop());
        }
    }
}
