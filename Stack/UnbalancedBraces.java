import java.util.Stack;

/**
 * Created by Allyssa Albores on 25/07/2017.
 */
public class UnbalancedBraces {
    public static void main(String[] args) {
        char[] array = {'[', '{', '(', '}', ']'};

        unbalancedBraces(array);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void unbalancedBraces(char[] array) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int flag = 0;

        if(array.length % 2 != 0) {
            flag = array.length/2;
        }

        for(int i = 0; i < array.length; i++) {
            if((array[i] == '(' || array[i] == '{' || array[i] == '[') && flag != i) {
                stack1.push(array[i]);
                stack2.push(i);
            } else if((array[i] == ')' || array[i] == '}' || array[i] == ']') && flag != i) {
                if(stack1.peek() == '(' && array[i] == ')'
                        || stack1.peek() == '{' && array[i] == '}'
                        || stack1.peek() == '[' && array[i] == ']') {
                    stack1.pop();
                    stack2.pop();
                } else {
                    array[i] = '#';
                    int temp = stack2.pop();
                    array[temp] = '#';
                }
            } else if(flag == i){
                array[i] = '#';
            }
        }
    }
}
