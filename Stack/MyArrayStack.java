package Stack;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public interface MyArrayStack<E> {
    void push(E item);

    E pop();

    E top();

    boolean isEmpty();

    boolean isFull();

    int size();

    void clear();
}
