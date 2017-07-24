package Queue;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public interface MyLinkedListQueue<E> {

    void enqueue(E item);

    E dequeue();

    E peek();

    int size();

    boolean isEmpty();
}
