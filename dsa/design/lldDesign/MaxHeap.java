package dsa.design.lldDesign;

import java.util.ArrayList;
import java.util.Map;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    ArrayList<T> list;

    public MaxHeap() {
        list = new ArrayList<>();
        list.add(null);

    }

    public int left(int index) {
        return 2 * index;
    }

    public int right(int index) {
        return 2 * index + 1;
    }

    public int parent(int index) {
        return index / 2;
    }

    public

    @Override
     void add(T element) {
        list.add(element);
        upInsertHeapifyCheck(list.size()-1);

    }
    public void swap(int newIndex, int parentIndex){
        T temp = list.get(newIndex);
        list.set(newIndex, list.get(parentIndex));
        list.set(parentIndex,temp);
    }

    private void upInsertHeapifyCheck(int newIndex) {
        if(newIndex==1) return;
        int parentIndex = parent(newIndex) ;

        if(list.get(newIndex).compareTo(list.get(parentIndex))>0){
            swap(newIndex,parentIndex);
            upInsertHeapifyCheck(parentIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return list.size()==1? true : false;
    }

    @Override
    public T peek() {
        return list.get(1);
    }


}
