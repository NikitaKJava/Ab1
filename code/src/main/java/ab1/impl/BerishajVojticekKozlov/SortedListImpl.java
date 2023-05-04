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

//public class SortedList {
//
//    private int[] list;
//    private int size;
//
//    public SortedList(int capacity) {
//        list = new int[capacity];
//        size = 0;
//    }
//
//    public void add(int value) {
//        if (size == list.length) {
//            // If the list is full, we need to resize it
//            int[] newList = new int[list.length * 2];
//            System.arraycopy(list, 0, newList, 0, list.length);
//            list = newList;
//        }
//        int index = binarySearch(value);
//        // Shift all elements greater than value to the right
//        System.arraycopy(list, index, list, index + 1, size - index);
//        list[index] = value;
//        size++;
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }
//        return list[index];
//    }
//
//    public int size() {
//        return size;
//    }
//
//    private int binarySearch(int value) {
//        int low = 0;
//        int high = size - 1;
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (list[mid] == value) {
//                return mid;
//            } else if (list[mid] < value) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return low;
//    }
//}

