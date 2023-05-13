package ab1.impl.BerishajVojticekKozlov;

import ab1.SortedList;

public class newSortedList implements SortedList {

    private int[] list;
    private int size;
    int capacity=0;

    public newSortedList(){
        new newSortedList(this.capacity);
    }
    public newSortedList(int capacity){
        list = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    @Override
    public void clear() {
        this.list = new int[0];
        this.size = 0;
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        //new array length + 1
            int[] newList = new int[size + 1];

        //copy elements in new array
        for(int i=0; i<newList.length-1; i++){
            newList[i]=list[i];
        }

        //check if key already exists in list, if not insert key in last index
        if(newList.length!=1){
            for(int i=0; i<newList.length; i++) {
                if (key == newList[i]) {
                    throw new IllegalArgumentException("key already exists");
                }
            }
        }
        newList[newList.length - 1] = key;

        //sort new element in array
        int i= 0;
        while(i<newList.length){
            if(newList[i]>newList[newList.length-1]){
                int copy = newList[i];
                newList[i] = newList[newList.length-1];
                newList[newList.length-1] = copy;
            }
            i++;
        }
        size++;
        list = newList;
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
        if(removed == true) {
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
        for(int i = 0; i<array.length; i++){
            array[i] = list[i];
        }
        return array;
    }
}

