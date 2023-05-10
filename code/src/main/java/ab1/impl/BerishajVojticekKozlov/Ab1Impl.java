package ab1.impl.BerishajVojticekKozlov;

import ab1.Ab1;
import ab1.Heap;
import ab1.SortedList;
import ab1.Sorter;

public class Ab1Impl implements Ab1 {

    @Override
    public SortedList newSortedList() {
        return new newSortedList();
    }

    @Override
    public Sorter newQuickSort() {
        // Ihre Implementierung
        return new QuickSort();
    }

    @Override
    public Heap newHeap(int capacity) {
        // Ihre Implementierung
        return new BinaryHeap(capacity);
    }

    @Override
    public Sorter newHeapSort(int capacity) {
        // Ihre Implementierung
        return new HeapSort();
    }
}
