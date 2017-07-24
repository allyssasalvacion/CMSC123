package Queue;

import java.util.NoSuchElementException;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public class ArrayQueue<E> implements MyArrayQueue<E> {
    E[] items;
    int size;
    int front;
    int rear;

    final static int CAPACITY = 10;

    public ArrayQueue() {
        items = (E[]) new Object[CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(E item) {
        if(size >= CAPACITY) {
            throw new IllegalStateException("The queue is full.");
        }

        items[rear++] = item;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        E temp = items[front];
        items[front++] = null;
        size--;

        return temp;
    }

    @Override
    public E front() {
        if(isEmpty()) {
            return null;
        }
        return items[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }
}
