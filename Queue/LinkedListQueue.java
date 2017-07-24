package Queue;

import java.util.NoSuchElementException;

/**
 * Created by Allyssa Albores on 24/07/2017.
 *
 * Singly-Linked List
 */

public class LinkedListQueue<E> implements MyLinkedListQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public class Node<T>{
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

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }


    @Override
    public void enqueue(E item) {
        Node<E> temp = new Node(item, null);
        if(isEmpty()) {
            front = temp;
            rear = temp;
        }

        rear.setNext(temp);
        rear = rear.getNext();
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }

        E temp = front.getData();
        front.setData(null);
        front = front.getNext();
        size--;
        return temp;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
