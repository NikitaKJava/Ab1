package ab1.impl.BerishajVojticekKozlov;


public class SortedListImpl implements ab1.SortedList {
    private int[] data;
    private int size;

    public SortedListImpl() {
        data = new int[0];
        size = 0;
    }

    /**
     * +
     * Removes all keys from SortedList
     */
    @Override
    public void clear() {
        this.data = new int[0];
        this.size = 0;
    }

    /**
     * Inserts the specified element at the specified position in this SortedList.
     * Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param key is a new value
     * @throws IllegalArgumentException, if the key in the list already exists
     */
    @Override
    public void insert(int key) throws IllegalArgumentException {
        // check capacity
        checkCapacity(size + 1);
        // check duplicate
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == key) {
                throw new IllegalArgumentException("The key " + key + " is already exists");
            }
        }

        int index = size;
        while (index > 0 && data[index - 1] > key) {
            data[index] = data[index - 1];
            index--;
        }

        data[index] = key;
        size++;
    }

    /**
     * Removes the element at the specified position in this SortedList.
     * Returns true if the key was removes and false if it wasn't.
     *
     * @param key is the value, that has to be removed.
     */
    @Override
    public boolean remove(int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                removeLastElement(key);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getLength() {
        return size;
    }

    /**
     * Gives a SortedList as a new array back
     *
     * @return new array with SortedList values
     */
    @Override
    public int[] toArray() {
        int[] array = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            array[i] = data[i];
        }
        return array;
    }

    /**
     * Searches index for the key
     * @param key searched key
     * @return index of a key
     */
    private int binarySearch(int key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param minCapacity is the capacity that will be checked
     */
    private void checkCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length + 1;
            int[] newData = new int[newCapacity];

            System.arraycopy(data, 0, newData, 0, size);
            for (int i = 0; i < newData.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    /**
     * Swapping selected key to the end of the removes last element and reduces array length
     *
     * @param key key to be swapped to the end of an array
     */
    private void removeLastElement(int key) {
        int[] newData = new int[data.length - 1];
        for (int i = 0; i < newData.length; i++) {
            if (data[i] != key) {
                newData[i] = data[i];
            }
        }
        data = newData;
    }
}
