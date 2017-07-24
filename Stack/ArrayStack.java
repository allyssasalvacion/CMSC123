package Stack;

import java.util.EmptyStackException;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public class ArrayStack<E> implements MyArrayStack<E> {
    private E[] items;
    private int top;
    private int size;

    final static int CAPACITY = 10;

    public ArrayStack() {
        clear();
    }

    @Override
    public void push(E item) {
        if(isFull()) {
            throw new StackOverflowError("The stack is full.");
        }

        items[++top] = item;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        size--;
        E temp = items[top--];

        return temp;
    }

    @Override
    public E top() {
        if(isEmpty()) {
            return null;
        }

        return items[top];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return size() >= CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        items = (E[]) new Object[CAPACITY];
        top = -1;
        size = 0;
    }
}
