package list;

import java.util.List;

/**
 * Created by Allyssa Albores on 21/07/2017.
 */
public interface MyList<E> extends Iterable<E> {
    void append(E item); // done

    void add(int i, E item); // done

    void remove(int p); // done

    boolean remove(E p); // done

    void set(int i, E item); // done

    int size(); // done

    E get(int i); // done

    List<E> subList(int fromIndex, int toIndex); // done

    void merge(List l); // done

    void reverse(); // done

    boolean palindromic(); // done
}

