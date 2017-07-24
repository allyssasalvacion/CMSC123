package Stack;

import junit.framework.TestCase;

/**
 * Created by Allyssa Albores on 24/07/2017.
 */

public class LinkedListStackTest extends TestCase {
    private LinkedListStack<String> stack;

    public void setUp() {
        stack = new LinkedListStack<String>();
    }

    public void testPush() {
        stack.push("January");
        stack.push("February");
        stack.push("March");
        stack.push("April");
        stack.push("May");
        stack.push("June");
        stack.push("July");
        stack.pop();
        stack.pop();

        assertEquals("May", stack.peek());
    }

    public void testPop() {
        stack.push("January");
        stack.push("February");
        stack.push("March");
        stack.push("April");
        stack.push("May");
        stack.push("June");
        stack.push("July");

        assertEquals("July", stack.pop());
        assertEquals("June", stack.pop());
    }

    public void testPeek() {
        stack.push("January");
        assertEquals("January", stack.peek());
        stack.push("February");
        assertEquals("February", stack.peek());
        stack.push("March");
        assertEquals("March", stack.peek());
        stack.push("April");
        assertEquals("April", stack.peek());
        stack.push("May");
        assertEquals("May", stack.peek());
        stack.push("June");
        assertEquals("June", stack.peek());
        stack.push("July");
        assertEquals("July", stack.peek());
    }

    public void testSize() {
        stack.push("January");
        stack.push("February");
        stack.push("March");
        stack.push("April");
        stack.push("May");
        stack.push("June");
        stack.push("July");

        assertEquals(7, stack.size());
    }

    public void testIsEmptyTrue() {
        assertEquals(true, stack.isEmpty());
    }

    public void testIsEmptyFalse() {
        stack.push("July");
        assertEquals(false, stack.isEmpty());
    }
}
