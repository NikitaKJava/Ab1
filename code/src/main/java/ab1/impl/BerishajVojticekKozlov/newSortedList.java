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
        list = new int[0];
        this.size = 0;
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        //if(size==this.list.length || this.list == null){
            int[] newList = new int[size + 1];
            for(int i=0; i<newList.length-1; i++){
                newList[i]=list[i];
            }
        //}
        for(int i=0; i<list.length; i++){
            if(key == list[i]){
                throw new IllegalArgumentException("key already exists");
            }
        }
        int i;
        for(i=0; i < list.length; i++){
            if(list[i] > key){
                break;
            }
        }
        for(int j=list.length-1; j>i; j--){
            list[j] = list[j-1];
        }
        newList[newList.length-1]=key;
        size++;
        list = newList;
    }

    @Override
    public boolean remove(int key) {
        boolean removed = false;
        for(int i=0; i<list.length; i++){
            if(key != list[i]){
                removed = false;
            }
            else if(key==list[i]){
                int[] newList = new int[list.length - 1];
                for(int j=0; j<i; j++){
                    newList[j] = list[j];
                }
                for(int k=i+1; k<list.length; k++){
                    newList[k] = list[k];
                }
                list = newList;
                removed = true;
            }
        }
        return removed;

    }

    @Override
    public int getLength() {
        return list.length;
    }

    @Override
    public int[] toArray() {
        return list;
    }
}

