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
     * Quicksort method checks from both sides and sorts the given subarray using the quicksort algorithm.
     *
     * @param array the integer array to sort
     * @param m  the index of the leftmost element in the initial array and subarray to sort
     * @param M the index of the rightmost element in the initial array and subarray to sort
     */
    private void quicksort(int[] array, int m, int M) {
        if (M > m) {
            int i = m - 1; // left pointer
            int j = M; // right pointer
            int pivot = array[M]; // Pivot element at the right end
            while (true) {
                do {
                    i++; // until array[i] >= p
                } while (array[i] < pivot);
                do {
                    j--; // until array[i] <= p
                } while (array[j] > pivot && j > 0);
                if (i >= j) { // if both pointer reach it other, it stops
                    break;
                }
                swap(array, i, j); // swap array[i] and array[j]
            }
            swap(array, i, M); // Pivot element to the correct position
            quicksort(array, m, i - 1); //
            quicksort(array, i + 1, M);
        }
    }

    /**
     * swap method is a helper to replace two elements in the array
     *
     * @param array the integer array
     * @param i  the index of the first element
     * @param j the index of the second element
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}