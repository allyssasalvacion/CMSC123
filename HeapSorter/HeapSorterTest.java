/**
 * Created by Allyssa Albores, Jun Neil Dionne Balite on 25/11/2016.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSorterTest {

    int[] items;
    HeapSorter hs;

    @Before
    public void setUp() throws Exception {
        items = new int[]{8, 12, 2, 10, 6, 4};
        hs = new HeapSorter(items);
    }

    @Test
    public void add() throws Exception {
        hs.add(8);
        assertEquals(
                Arrays.toString(new int[]{8, 12, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
        hs.add(12);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void bubbleUp() throws Exception {
        hs.bubbleUp(1);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void parent() throws Exception {
        assertEquals(0, hs.parent(1));
    }

    @Test
    public void sort() throws Exception {
        hs.sort();
        assertEquals(
                Arrays.toString(new int[]{2, 4, 6, 8, 10, 12}),
                Arrays.toString(items)
        );
    }

    @Test
    public void swap() throws Exception {
        hs.swap(0,1);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void remove() throws Exception {
        hs.remove();
        assertEquals(
                Arrays.toString(new int[]{4, 6, 8, 10, 12}),
                Arrays.toString(items)
        );

        hs.remove();
        assertEquals(
                Arrays.toString(new int[]{6, 8, 10, 12}),
                Arrays.toString(items)
        );

        hs.remove();
        assertEquals(
                Arrays.toString(new int[]{8, 10, 12}),
                Arrays.toString(items)
        );
    }

    @Test
    public void trickleDown() {
        hs.trickleDown(0);
        assertEquals(
                Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
                Arrays.toString(items)
        );
    }

    @Test
    public void hasLeft() throws Exception {

        assertTrue(hs.hasLeft(0));
    }

    @Test
    public void hasRight() throws Exception {
        assertTrue(hs.hasRight(0));
    }

    @Test
    public void right() throws Exception {
        assertEquals("2", 2, hs.right(0));
    }

    @Test
    public void left() throws Exception {
        assertEquals("1",  1, hs.left(0));
    }

}
