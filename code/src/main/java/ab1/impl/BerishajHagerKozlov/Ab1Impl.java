package ab1.impl.BerishajHagerKozlov;

import ab1.Ab1;
import ab1.Heap;
import ab1.SortedList;
import ab1.Sorter;

public class Ab1Impl implements Ab1 {

    @Override
    public SortedList newSortedList() {
        // Ihre Implementierung
        return null;
    }
//  Quicksort start
    @Override
    public Sorter newQuickSort(int[] testArray) {
        // Ihre Implementierung
        quicksort(testArray, 0, testArray.length - 1);
        return null;
    }

    private void quicksort(int[] data, int left, int right) {
        // End of recursion reached?
        if (left >= right) return;

        int pivotPos = partition(data, left, right);
        quicksort(data, left, pivotPos - 1);
        quicksort(data, pivotPos + 1, right);
    }

    public int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low;
        int j = high - 1;

        while (i < j) {
            // Find the first element >= pivot
            while (data[i] < pivot) {
                i++;
            }

            // Find the last element < pivot
            while (j > low && data[j] >= pivot) {
                j--;
            }

            // If the greater element is left of the lesser element, switch them
            if (i < j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }
        // i == j means we haven't checked this index yet.
        // Move i right if necessary so that i marks the start of the right array.
        if (i == j && data[i] < pivot) {
            i++;
        }

        // Move pivot element to its final position
        if (data[i] != pivot) {
            swap(data, i, high);
        }
        return i;
    }

    static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
//  Quicksort end
    @Override
    public Heap newHeap(int capacity) {
        // Ihre Implementierung
        return null;
    }

    @Override
    public Sorter newHeapSort(int capacity) {
        // Ihre Implementierung
        return null;
    }
}