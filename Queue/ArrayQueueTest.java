package Queue;

import junit.framework.TestCase;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public class ArrayQueueTest extends TestCase {

    private ArrayQueue<String> queue;

    public void setUp() {
        queue = new ArrayQueue<String>();
    }

    public void testEnqueue() {
        queue.enqueue("Allyssa");
        queue.enqueue("Albores");
        queue.enqueue("Gino");
        queue.enqueue("Hilongo");

        assertEquals("Allyssa", queue.dequeue());
        assertEquals("Albores", queue.dequeue());
        assertEquals("Gino", queue.dequeue());
        assertEquals("Hilongo", queue.dequeue());
    }

    public void testDequeue() {
        queue.enqueue("Allyssa");
        queue.enqueue("Albores");
        queue.enqueue("Gino");
        queue.enqueue("Hilongo");
        queue.dequeue();
        queue.dequeue();

        assertEquals("Gino", queue.front());
        assertEquals("Gino", queue.dequeue());
    }

    public void testSize() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");

        assertEquals(10, queue.size());
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
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");

        assertEquals(false, queue.isEmpty());
    }

    public void testIsFullTrue() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");

        assertEquals(true, queue.isFull());
    }

    public void testIsFullFalse() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");
        queue.dequeue();

        assertEquals(false, queue.isFull());
    }
}
