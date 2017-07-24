package Stack;

import java.util.EmptyStackException;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */

public class LinkedListStack<E> implements MyLinkedListStack<E> {
    private Node<E> head;
    private int size;

    public LinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    @Override
    public void push(E item) {
        Node<E> temp = new Node(item, head);
        head = temp;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E temp = head.getData();
        head.setData(null);
        head = head.getNext();
        size--;

        return temp;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }

        return head.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
