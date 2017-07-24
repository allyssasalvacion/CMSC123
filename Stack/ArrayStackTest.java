package Stack;

import junit.framework.TestCase;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */
public class ArrayStackTest extends TestCase {
    private ArrayStack<String> stack;

    public void setUp() {
        stack = new ArrayStack<String>();
    }

    public void testPush() {
        stack.push("Sansa Stark");
        stack.push("Arya Stark");
        stack.push("Bran Stark");
        stack.push("Jon Snow");

        assertEquals("Jon Snow", stack.pop());
    }

    public void testPop() {
        stack.push("Sansa Stark");
        stack.push("Arya Stark");
        stack.push("Bran Stark");
        stack.push("Jon Snow");
        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals("Sansa Stark", stack.top());
    }

    public void testTop() {
        stack.push("Sansa Stark");
        assertEquals("Sansa Stark", stack.top());
        stack.push("Arya Stark");
        assertEquals("Arya Stark", stack.top());
        stack.push("Bran Stark");
        assertEquals("Bran Stark", stack.top());
        stack.push("Jon Snow");
        assertEquals("Jon Snow", stack.top());
    }

    public void testIsEmptyTrue() {
        assertEquals(true, stack.isEmpty());
    }

    public void testIsEmptyFalse() {
        stack.push("Sansa Stark");
        stack.push("Arya Stark");
        stack.push("Bran Stark");
        stack.push("Jon Snow");

        assertEquals(false, stack.isEmpty());
    }

    public void testIsFullTrue() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");

        assertEquals(true, stack.isFull());
    }

    public void testIsFullFalse() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");

        assertEquals(false, stack.isFull());
    }

    public void testSize() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");

        assertEquals(7, stack.size());
    }

    public void testClear() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");

        assertEquals("G", stack.top());
        stack.clear();
        assertEquals(true, stack.isEmpty());
    }
}
