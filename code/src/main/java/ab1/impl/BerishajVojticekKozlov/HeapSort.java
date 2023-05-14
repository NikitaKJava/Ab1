package ab1.impl.BerishajVojticekKozlov;

import ab1.Sorter;

/**
 * Implementation of the Sorter interface using the Heapsort algorithm.
 */
public class HeapSort implements Sorter {
    /**
     * Sorts the given integer array in ascending order using the heapsort algorithm.
     *
     * @param array the integer array to sort
     */
    @Override
    public void sort(int[] array) {
        int size = array.length;
        // Build heap (rearrange array)
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);

        // One by one extract an element from heap
        for (int i = size - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }
    /**
     * Maintains the max heap property for the given subarray by recursively swapping elements.
     *
     * @param array the integer array to heapify
     * @param size     the size of the heap (i.e., the size of the subarray being heapified)
     * @param i     the index of the node to start heapifying from
     */
    private void heapify(int[] array, int size, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < size && array[left] > array[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < size && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(array, size, largest);
        }
    }
}