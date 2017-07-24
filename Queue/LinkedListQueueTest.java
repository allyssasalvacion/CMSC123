package Queue;

import junit.framework.TestCase;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public class LinkedListQueueTest extends TestCase {
    public LinkedListQueue<String> queue;

    public void setUp() {
        queue = new LinkedListQueue<String>();
    }

    public void testEnqueue() {
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Watermelon");

        assertEquals("Apple", queue.dequeue());
        assertEquals("Banana", queue.dequeue());
        assertEquals("Watermelon", queue.dequeue());
    }

    public void testDequeue() {
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Watermelon");
        queue.dequeue();
        queue.dequeue();

        assertEquals("Watermelon", queue.peek());
        assertEquals("Watermelon", queue.dequeue());
    }

    public void testSize() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");

        assertEquals(7, queue.size());
    }

    public void testIsEmptyTrue() {
        assertEquals(true, queue.isEmpty());
    }

    public void testIsEmptyFalse() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");

        assertEquals(false, queue.isEmpty());
    }
}
