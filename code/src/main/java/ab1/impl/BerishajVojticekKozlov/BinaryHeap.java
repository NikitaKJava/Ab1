package ab1.impl.BerishajVojticekKozlov;

import ab1.Heap;

import java.util.NoSuchElementException;

public class BinaryHeap implements Heap {

    private int[] heapArray;
    private int size;
    private int capacity;

    /**
     * method sets all elements of the array to zero and resets the size of the heap to zero.
     * @param capacity is the length of an Array
     */
    public BinaryHeap(int capacity) {
        this.heapArray = new int[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * method sets all elements of the array to zero and resets the size of the heap to zero.
     */
    @Override
    public void clear() {

        for (int i = 0; i < heapArray.length; i++) {
            heapArray[i] = 0;
        }
        size = 0;
    }

    /**
     * The add method adds an element to the heap by inserting it at the end of the array and then "bubbling it up" by repeatedly swapping
     * it with its parent if its key is greater than its parent's key. This ensures that the heap property is maintained.
     * If the heap is already at its maximum capacity, an IndexOutOfBoundsException is thrown.
     * @param key added element
     * @throws IndexOutOfBoundsException "Heap is full"
     */
    @Override
    public void add(int key) throws IndexOutOfBoundsException {
        if (size >= capacity) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heapArray[++size] = key;
        int i = size;
        while (i > 1 && heapArray[i] > heapArray[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    /**
     * The removeMax method removes and returns the maximum element of the heap by replacing it with the last element of the array,
     * decrementing (MaxHeap) the size of the heap, and then "heapifying" the heap by repeatedly (recursively) swapping the root with its largest child
     * until the heap property is restored. If the heap is empty, a NoSuchElementException is thrown.
     * @return removes max element
     * @throws NoSuchElementException "Heap is empty"
     */
    @Override
    public int removeMax() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int max = heapArray[1];
        heapArray[1] = heapArray[size--];
        heapify(1);
        return max;
    }

    /**
     * The max method returns the maximum element of the heap without removing it. If the heap is empty, a NoSuchElementException is thrown.
     * @return max element on the top of a Heap
     * @throws NoSuchElementException "Heap is empty"
     */
    @Override
    public int max() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heapArray[1];
    }

    /**
     * The size method simply returns the current size of the heap.
     * @return size of a Heap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * The heapify method is a helper method used by removeMax to restore the heap property after removing the root element.
     * It takes the index of a Node as an argument and recursively swaps it with its largest child until the heap property is restored.
     * @param key index of a Node
     */
    private void heapify(int key) {
        int largest = key; // Initialize largest as root
        int left = 2 * key; // left = 2*i + 1
        int right = 2 * key + 1; // right = 2*i + 2
        // If left child is larger than root
        if (left <= size && heapArray[left] > heapArray[largest]) {
            largest = left;
        }
        if (right <= size && heapArray[right] > heapArray[largest]) {
            largest = right;
        }
        if (largest != key) {
            swap(key, largest);
            heapify(largest);
        }
    }

    /**
     * The swap method is a helper method used to swap to values
     * @param i value 1
     * @param j value 2
     */
    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }
}

