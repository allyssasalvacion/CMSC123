package ThirdLongExam;

import java.util.Stack;

/**
 * Created by Allyssa Albores on 25/07/2017.
 */
public class UnbalancedBraces {
    public static void main(String[] args) {
        char[] array = {'(', '{', '(', '[', ']', '}', '}',')'};

        unbalancedBraces(array);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void unbalancedBraces(char[] array) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Integer> stack4 = new Stack<Integer>();

        // set first
        for(int i = 0; i < array.length/2; i++) {
            if(!(array[i] == '(' || array[i] == '{' || array[i] == '[')) {
                array[i] = '#';
            }

            stack1.push(array[i]);
            stack2.push(i);
        }

        if(array.length % 2 != 0) {
            array[array.length/2] = '#';
            for(int i = array.length - 1; i > array.length/2; i--) {
                if(!(array[i] == ')' || array[i] == '}' || array[i] == ']')) {
                    array[i] = '#';
                }

                stack3.push(array[i]);
                stack4.push(i);
            }
        } else {
            for(int i = array.length - 1; i >= array.length/2; i--) {
                if(!(array[i] == ')' || array[i] == '}' || array[i] == ']')) {
                    array[i] = '#';
                }

                stack3.push(array[i]);
                stack4.push(i);
            }
        }

        while(!(stack1.isEmpty())) {
            if(!((stack1.peek() == '(' && stack3.peek() == ')') ||
                    (stack1.peek() == '[' && stack3.peek() == ']') ||
                    (stack1.peek() == '{' && stack3.peek() == '}'))) {
                stack1.pop();
                stack3.pop();
                array[stack2.pop()] = '#';
                array[stack4.pop()] = '#';
            } else {
                stack1.pop();
                stack2.pop();
                stack3.pop();
                stack4.pop();
            }
        }
    }
}
