package ab1.impl.BerishajVojticekKozlov;

import ab1.SortedList;


public class newSortedList implements SortedList {

    private int[] list;
    private int size;

    public newSortedList(){
        list = new int[1];
        size = 0;
    }

    @Override
    public void clear() {
        list = new int[list.length];
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        if(size==list.length){
            int[] newList = new int[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
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
        list[i]=key;
        size++;
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

