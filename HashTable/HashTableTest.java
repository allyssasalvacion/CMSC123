/**
 * Created by Allyssa Albores, Jun Neil Dionne Balite on 29/11/2016.
 */

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class HashTableTest {
    HashTable<String> t;
    @Before
    public void setUp() throws Exception {
        t = new HashTable<>(10);
    }

    @Test
    public void add() throws Exception {
        t.add("CMSC123");
        t.add("CMSC22");
        t.add("CMSC57");
        t.add("0123456789");
        t.add("<3");
        t.add("CMSC21");
        assertTrue(t.contains("CMSC123"));          //index: 0
        assertTrue(t.contains("CMSC22"));           //index: 4
        assertTrue(t.contains("CMSC57"));           //index: 2
        assertTrue(t.contains("0123456789"));       //index: 3
        assertTrue(t.contains("<3"));               //index: 1
        assertTrue(t.contains("CMSC21"));           //index: 3
    }

    @Test
    public void remove() throws Exception {
        t.add("0123456789");
        t.add("CMSC21");

        assertTrue(t.contains("0123456789"));
        assertTrue(t.contains("CMSC21"));

        t.remove("0123456789");

        assertTrue(t.contains("CMSC21"));
        assertFalse(t.contains("0123456789"));
    }


    @Test
    public void contains() throws Exception {
        t.add("Allyssa");
        t.add("Seares");
        t.add("Albores");

        assertTrue(t.contains("Allyssa"));
        assertTrue(t.contains("Seares"));
        assertTrue(t.contains("Albores"));
        assertEquals(t.getIndex("Allyssa"), 5);
        assertEquals(t.getIndex("Seares"), 5);
        assertEquals(t.getIndex("Albores"), 8);

    }

    @Test
    public void getIndex() throws Exception {
        t.add("Jun");
        t.add("Neil");
        t.add("Dionne");
        t.add("Autentico");
        t.add("Balite");

        assertEquals(t.getIndex("Jun"), 1);
        assertEquals(t.getIndex("Neil"), 2);
        assertEquals(t.getIndex("Dionne"), 5);
        assertEquals(t.getIndex("Autentico"), 2);
        assertEquals(t.getIndex("Balite"), 3);
    }

}
