/**
 * Created by Allyssa Albores, Jun Neil Dionne Balite on 25/11/2016.
 */

public class HeapSorter {
    private int[] items;
    private int heapSize;
    //private final int ROOT = 0;

    public HeapSorter(int[] items) {
        this.items = items;
        this.heapSize = 0;
    }

    public void sort() {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }

        for (int i = items.length - 1; i >= 0; i--) {
            items[i] = remove();

        }
    }


    public void add(int x) {
        if(heapSize <= items.length - 1){
            items[heapSize++] = x;
        }
        for(int i = 0; i <= items.length - 1; i++){
            if(x == items[i]){
                bubbleUp(i);
            }
        }

    }

    public void bubbleUp(int i) {
        while(true){
            if(items[i] > items[parent(i)]){
                swap(i, parent(i));
            }if(items[i] <= items[parent(i)]){
                break;
            }
        }
    }

    public void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public int parent(int i) {
        return (i - 1)/2;
    }

    public int remove() {
        if(heapSize == 0) {
            throw new IllegalArgumentException("Heap is empty!");
        } else {
            items[0] = items[heapSize - 1];
            heapSize--;

            if(heapSize > 0) {
                trickleDown(0);
            }
            return items[0];
        }
    }

    public void trickleDown(int i) {
        while(true){
            if(items[i] < items[right(i)] && items[right(i)] > items[left(i)]){
                swap(i, right(i));
            }
            else if(items[i] < items[left(i)] && items[right(i)] < items[left(i)]){
                swap(i, left(i));
            }if(items[i] >= right(i) && items[i] >= left(i)){
                break;
            }
        }

    }

    public boolean hasLeft(int i) {
        if((2*i)+1 <= items.length - 1){
            return true;
        }
        return false;
    }

    public boolean hasRight(int i) {
        if((2*i)+2 <= items.length - 1){
            return true;
        }
        return false;
    }

    public int right(int i) {
        return (2*i) + 2;
    }

    public int left(int i) {
        return (2*i) + 1;
    }

}