/**
 * Allyssa Albores
 * Cristina Dayuday
 */

//NOT CORRECT
public class LList implements MyList {
  private Object[] items;
  private int count;
   
  public LList() {
    items = new Object[10];
    count = 0;
  }
   public void add(Object item) {
    items[count++] = item; 
  }
  
  public void add(int i, Object item) {
      for(int j = count; j > i; j--) {
         items[j] = items[j-1]; 
      }
    items[i] = item;
    count++;
  }
  
  
  public Object get(int i) {
    if (count == 0 || i >= count) {
      throw new IndexOutOfBoundsException();
    }
    return items[i];
  }
  
  public void remove(int i) {
    for(int j = i; j < count - 1; j++) {
       items[j] = items[j+1];
    }
    count--;
  }
  
  public void remove(Object item) {
    //item.clear();
    item = "";
  }
  
  public void set(int i, Object item) {
  items[i]  = item; 
  }
}
