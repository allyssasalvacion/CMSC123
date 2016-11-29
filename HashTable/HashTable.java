/**
 * Created by Allyssa Albores, Jun Neil Dionne Balite on 29/11/2016.
 */

import java.util.LinkedList;
import java.util.List;

public class HashTable<V> {

    private int capacity;
    private List<V>[] buckets;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
    }

    public void add(V value) {
        int index = getIndex(value);

        if(buckets[index] == null){
            buckets[index] = new LinkedList<V>();
        }

        buckets[index].add(value);

    }
    public void remove(V value) {
        int index = getIndex(value);

        if (buckets[index] == null) {
            throw new IllegalStateException("List doesn't exist");
        }

        List<V> list = buckets[index];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                list.remove(i);
            }
        }

    }

    public boolean contains(V value) {
        int index = getIndex(value);

        if (buckets[index] == null) {
            return false;
        }
        for (V x : buckets[index]) {
            if (value.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(V value) {
        int index = value.hashCode() % capacity;
        if(index < 0) {
            index *= -1;
        }
        return index;
    }
}
