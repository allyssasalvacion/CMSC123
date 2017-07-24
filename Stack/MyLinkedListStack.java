package Stack;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */

public interface MyLinkedListStack<E> {
    void push(E item);

    E pop();

    E peek();

    int size();

    boolean isEmpty();
}
