package list;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Allyssa Albores on 21/07/2017.
 */
public class DoublyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private Node<E> body;
    private int pointer;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private class DLListIterator implements Iterator {
        private Node<E> current;
        private Node<E> previous;
        private Node<E> previous2;
        private boolean removeCalled;

        public DLListIterator() {
            current = head;
            previous = null;
            previous2 = null;
            removeCalled = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            E temp = current.getData();
            previous2 = previous;
            previous = current;
            current = current.getNext();
            removeCalled = false;
            return temp;
        }

        @Override
        public void remove() {
            if(previous == null) {  //previous == null for the start
                throw new IllegalStateException();
            }

            if(previous2 == null) {
                head = current;
                previous = previous2;
            } else {
                previous2.setNext(current);
                previous = previous2;
            }
            size--;
            removeCalled = true;
        }
    }

    public void append(E item) {
        if(head == null) {
            head = new Node(item, null, null);
            tail = head;
        } else {
            tail.setNext(new Node(item, null, tail));
            tail = tail.getNext();
        }
        size++;
    }

    public void add(int index, E item) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            head = new Node(item, head, null);
        } else if(index == size() - 1) {
            append(item);
        } else {
            Node<E> current;
            if(index < size()/2) {
                current = head;
                for(int i = 0; i < index; i++) {
                    current = current.getNext();
                }

                current.setNext(new Node(item, current.getNext(), current));

            } else {
                current = tail;
                for(int i = size() - 1; i > index; i--) {
                    current = current.getPrev();
                }

                current.setPrev(new Node(item, current, current.getPrev()));
            }
        }
        size++;
    }

    public void remove(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            head = head.getNext();
            head.getPrev().setData(null);
        } else if(index == size() - 1) {
            tail = tail.getPrev();
            tail.getNext().setData(null);
        } else {
            Node<E> current;
            if(index < size/2) {
                current = head;
                for(int i = 0; i < index; i++) {
                    current = current.getNext();
                }
            } else {
                current = tail;
                for(int i = size() - 1; i > index; i--) {
                    current = current.getPrev();
                }
            }

            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.setNext(null);
            current.setPrev(null);
        }
        size--;
    }

    public boolean remove(E item) {
        if (head.getData().equals(item)) {
            remove(0);
            return true;
        } else if (tail.getData().equals(item)) {
           remove(size() - 1);
            return true;
        } else {
            Node<E> current = head;
                for(int i = 0; i < size() - 1; i++) {
                    current = current.getNext();
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    current.setNext(null);
                    current.setPrev(null);
                    size--;
                    return true;
                }
        }
        return false;
    }

    public void set(int index, E item) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current;
        if(index < size()/2) {
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setData(item);
        } else {
            current = tail;
            for(int i = size() - 1; i > index; i--) {
                current = current.getPrev();
            }
            current.setData(item);
        }

    }

    public int size() {
        return this.size;
    }

    public E get(int index) {                           // with a third pointer
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current;
        int temp = (pointer - index);
        int temp2 = size()/2 - index;
        System.out.println(pointer);

        if(temp < 0) {
            temp *= -1;
        }

        if(temp2 < 0) {
            temp *= -1;
        }

        if(temp <= temp2 && body != null) {
            current = body;
            if(pointer - index < 0) {
                for(int i = pointer; i < index; i++) {
                    current = current.getNext();
                }
            } else {
                for(int i = pointer; i > index; i--) {
                    current = current.getPrev();
                }
            }
            System.out.println("Second get");
        } else {
            if(index < size()/2) {
                current = head;
                for(int i = 0; i < index; i++) {
                    current = current.getNext();
                }
            } else {
                current = tail;
                for(int i = size() - 1; i > index; i--) {
                    current = current.getPrev();
                }
            }
            System.out.println("First get");
        }

        pointer = index;
        body = current;

        return current.getData();
    }

    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex > size()) {
            throw new IndexOutOfBoundsException();
        }

        if(fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }

        MyLinkedList<E> sublist = new MyLinkedList<E>();

        for(int i = fromIndex; i <= toIndex; i++) {
            E e = this.get(i);
            sublist.add(e);
        }

        return sublist;
    }

    public void merge(List l) {
        for(int i = 0; i < l.size(); i++) {
            Object e = l.get(i);

            tail.setNext(new Node(e, null, tail));
            tail = tail.getNext();
            size++;
        }
    }

    public void reverse() {
        Node<E> current1 = head;
        Node<E> current2 = tail;
        for(int i = size() - 1; i >= size()/2; i--) {
            E temp1 = current1.getData();
            E temp2 = current2.getData();
            current1.setData(temp2);
            current2.setData(temp1);
            current1 = current1.getNext();
            current2 = current2.getPrev();
        }
    }

    public boolean palindromic() {
        Node<E> current1 = head;
        Node<E> current2 = tail;
        for(int i = size() - 1; i >= size()/2; i--) {
            E temp1 = current1.getData();
            E temp2 = current2.getData();
            if(!(temp1.equals(temp2))) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getPrev();
        }
        return true;
    }

    public Iterator iterator() {
        return new DLListIterator();
    }
}
