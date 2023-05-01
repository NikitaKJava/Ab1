package ab1.impl.BerishajVojticekKozlov;

import ab1.Sorter;
/**
 * Implementation of the Sorter interface using the quicksort algorithm.
 */
public class QuickSort implements Sorter {
    /**
     * Sorts the given integer array in ascending order using the quicksort algorithm.
     *
     * @param array the integer array to sort
     */
    @Override
    public void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    /**
     * Recursively partitions and sorts the given subarray using the quicksort algorithm.
     *
     * @param array the integer array to sort
     * @param left  the index of the leftmost element in the subarray to sort
     * @param right the index of the rightmost element in the subarray to sort
     */
    private void quicksort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quicksort(array, left, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, right);
        }
    }
    /**
     * Partitions the given subarray around a pivot element, and returns the index of the pivot.
     *
     * @param array the integer array to partition
     * @param left  the index of the leftmost element in the subarray to partition
     * @param right the index of the rightmost element in the subarray to partition
     * @return the index of the pivot element after partitioning
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // swap
        int temp = array[i+1];
        array[i+1] = array[right];
        array[right] = temp;
        return i + 1;
    }
}