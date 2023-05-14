package ab1.impl.BerishajVojticekKozlov;

public class SortedList implements ab1.SortedList {

    private int[] list;
    private int size;

    public SortedList() {
        int capacity = 0;
        new SortedList(capacity);
    }

    public SortedList(int capacity) {
        list = new int[capacity];
        this.size = 0;
    }

    @Override
    public void clear() {
        this.list = new int[0];
        this.size = 0;
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        // new array with length + 1
        int[] newList = new int[size + 1];

        // copy exists elements in new array and checks for duplicates
        for (int i = 0; i < newList.length - 1; i++) {
            if (list != null && key == list[i]) {
                throw new IllegalArgumentException("key already exists");
            }
            if (list != null) {
                newList[i] = list[i];
            }
        }

        // inserting a new key
        newList[newList.length - 1] = key;

        //sort new element in array
        int i = 0;
        while (i < newList.length) {
            if (newList[i] > newList[newList.length - 1]) {
                int copy = newList[i];
                newList[i] = newList[newList.length - 1];
                newList[newList.length - 1] = copy;
            }
            i++;
        }
        list = newList;
        size++;
    }

    @Override
    public boolean remove(int key) {
        boolean removed = false;
        //create new array length-1
        int[] newList = new int[list.length - 1];
        //check if key exists in array, if yes copy elements in new array without key
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                int k = 0;
                for (int j = 0; j < list.length; j++) {
                    if (list[j] != key) {
                        newList[k] = list[j];
                        k++;
                    }
                    removed = true;
                }
            }
        }
        if (removed) {
            this.list = newList;
        }
        return removed;
    }

    @Override
    public int getLength() {
        return list.length;
    }

    //copy all elements in new array
    @Override
    public int[] toArray() {
        int[] array = new int[list.length];
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] = list[i];
        }
        return array;
    }
}

