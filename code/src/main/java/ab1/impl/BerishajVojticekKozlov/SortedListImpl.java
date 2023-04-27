package ab1.impl.BerishajVojticekKozlov;

import ab1.SortedList;
import java.util.ArrayList;
import java.util.Collections;

public class SortedListImpl implements SortedList {

    private ArrayList<Integer> list;

    public SortedListImpl(){
        list = new ArrayList<Integer>();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        if(list.contains(key)){
            throw new IllegalArgumentException("Duplicate key: " + key);
        }
        list.add(key);
        Collections.sort(list);
    }

    @Override
    public boolean remove(int key) {
        boolean removed = false;

        if(list.contains(key)){
            list.remove(key);
            removed = true;
        }

        return removed;
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
