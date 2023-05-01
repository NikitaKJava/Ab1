package ab1.impl.BerishajVojticekKozlov;

import ab1.Sorter;

/**
 * Implementation of the Sorter interface using the heapsort algorithm.
 */
public class HeapSort implements Sorter {
    /**
     * Sorts the given integer array in ascending order using the heapsort algorithm.
     *
     * @param array the integer array to sort
     */
    @Override
    public void sort(int[] array) {
        heapsort(array, 0, array.length - 1);
    }

    private void heapsort(int[] array, int i, int i1) {
    }
}