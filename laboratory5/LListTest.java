/**
 * Allyssa Albores
 * Cristina Dayuday
 *
 */
/**
 * Allyssa Albores
 * Cristina Dayuday
 */
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class LListTest extends TestCase {
  
  
  private MyList lst;
  private final String[] things = {"Shampoo", "Soap", "Deodorant"};
  private int count;
  
  public void setUp() {
    lst = new LList();
    count = 0;
  }
  
  private void add(int howMany) {
    for (int i = 0; i < howMany; i++) {
      lst.add(things[count++]);
    }
  }
  
  
  public void testAddOne() {
    add(1);
    assertEquals("added one item", "Shampoo", lst.get(0));
  }
  
  
  public void testAddTwo() {
    add(2);
    assertEquals("added two items and first was Shampoo", "Shampoo", lst.get(0));
    assertEquals("added two items and second was Soap", "Soap", lst.get(1));
  }
  
  public void testAddBetween() {
    add(2);
    lst.add(1, "Deodorant");
    assertEquals("added two items and first was Shampoo", "Shampoo", lst.get(0));
    assertEquals("added two items and second was Deodorant", "Deodorant", lst.get(1));
    assertEquals("added two items and third was Soap", "Soap", lst.get(2));
  }
  
  
  public void testAddStart() {
    add(2);
    lst.add(0, "Deodorant");
    assertEquals("added two items and first was Deodorant", "Deodorant", lst.get(0));
    assertEquals("added two items and second was Shampoo", "Shampoo", lst.get(1));
    assertEquals("added two items and third was Soap", "Soap", lst.get(2));
  }
  
  public void testAddIndexEmpty() {
    lst.add(0, "Deodorant");
    assertEquals("added one item and first was Deodorant", "Deodorant", lst.get(0));
  }
  
  public void testAddindexOutOfBounds() {
    lst.add(0, "Deodorant");
    try {
      lst.add(3, "Soap");
      lst.get(3);
      fail(); // should have thrown error
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  public void testGetOutOfBoundsWhenEmpty() {
    LList l = new LList();
    try {
      l.get(0);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  
  public void testGetOutOfBounds() {
    LList l = new LList();
    l.add("Shampoo");
    try {
      l.get(1);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  public void testRemoveLast() {
    LList l = new LList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(2);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    }
  }
  
  
  public void testRemoveMid() {
    LList l = new LList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(1);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
  
  
  public void testSet() {
    LList l = new LList();
    l.add("Shampoo");
    l.set(0, "Deodorant");
    assertEquals("added two items and first was Deodorant", "Deodorant", l.get(0));
  }
  
}