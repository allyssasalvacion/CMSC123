package Queue;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public interface MyArrayQueue<E> {

    void enqueue(E item);

    E dequeue();

    E front();

    boolean isEmpty();

    boolean isFull();
    
    int size();
}
