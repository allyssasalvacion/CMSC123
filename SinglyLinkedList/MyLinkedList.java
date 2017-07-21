package list;

import java.util.*;

/**
 * Created by Allyssa Albores on 20/07/2017.
 */
public class MyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    // constructors
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    public class Node<T> {
        private T data;
        private Node<T> next; //pointer to the next node in the list

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            this.data = newData;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> newNext) {
            this.next = newNext;
        }
    }

    public class LinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous;
        private Node<E> previous2;
        private boolean removeCalled;

        public LinkedListIterator() {
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
            if(current == null) {
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
            if(previous == null || removeCalled) {  //previous == null for the start
                throw new IllegalStateException();
            }
            if(previous2 == null) {
                head = current;
                previous = previous2;
            } else {
                previous2.setNext(current);
                previous = previous2;
            }
            currentSize--;
            removeCalled = true;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        for(E e : this) {
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof List) {
            List otherList = (List) obj;
            if(this.size() == otherList.size()) {
                Iterator list1 = this.iterator();
                Iterator list2 = otherList.iterator();

                while(list1.hasNext()) {
                    Object e1 = list1.next();
                    Object e2 = list2.next();

                    if(!(e1 == null ? e2 == null : e1.equals(e2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyLinkedList<E> copy = new MyLinkedList<E>();

        for(E e : this) {
            copy.add(e);
        }
        return copy;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public boolean contains(Object o) {
        for(E element : this) {
            if(o == null ? element == null : o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];

        int i = 0;
        for(E e : this) {
            array[i] = e;
            i++;
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] result = a;
        if(size() > result.length) {
            result = new Object[size()];
        }

        int i = 0;
        for(E e : this) {
            result[i] = e;
            i++;
        }

        if(result.length > i) {
            result[i] = null;
        }

        return (T[]) result;
    }

    @Override
    public boolean add(E e) {
        if(isEmpty()) {
            head = new Node(e, null);
            tail = head;
        } else {
            tail.setNext(new Node(e, null));
            tail = tail.getNext();
        }
        currentSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<E> iterator = this.iterator();

        while(iterator.hasNext()) {
            E e = iterator.next();

            if(o == null ? e == null : o.equals(e)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == size() - 1) {
            return tail.getData();
        } else if(index == 0) {
            return head.getData();
        } else {
            Node<E> current = head;

            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }

            return current.getData();
        }
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index < size() - 1) {
            Node<E> current = head;

            for(int i = 0; i < index; i++) {
                current = current.getNext();
            }

            current.setData(element);

            return current.getData();
        }

        tail.setData(element);
        return tail.getData();
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == size()) {
            add(element);
            return;
        }

        if(index == 0) {
            head = new Node(element, head);
        } else {
            Node<E> current = head;

            for(int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            current.setNext(new Node(element, current.getNext()));
        }
        currentSize++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<E> iterator = this.iterator();

        for(int i = 0; i < index; i++) {
            iterator.next();
        }

        E e = iterator.next();
        iterator.remove();
        return e;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
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

            tail.setNext(new Node(e, null));
            tail = tail.getNext();
            currentSize++;
        }
    }

    public void reverse() {
        Node<E> current = head;
        for(int i = size() - 1; i >= size()/2; i--) {
            E temp1 = this.get(i);
            E temp2 = current.getData();
            current.setData(temp1);
            current = current.getNext();

            this.set(i, temp2);
        }
    }
}
