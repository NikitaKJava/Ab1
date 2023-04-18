package ab1;

import ab1.Heap;
import ab1.SortedList;
import ab1.Sorter;

/**
 * Dient der Erzeugung von Implementierungen (Objekten) der vorgegebenen Interfaces.
 */
public interface Ab1 {

    /**
     * Erzeugt ein Objekt, das die Schnittstelle SortedList implementiert.
     */
    public SortedList newSortedList();

    /**
     * Erzeugt ein Objekt, das die Schnittstelle Sorter für den
     * QuickSort-Algorithmus implementiert.
     */
    public Sorter newQuickSort();

    /**
     * Erzeugt ein Objekt, das die Schnittstelle Heap implementiert.
     */
    public Heap newHeap(int capacity);

    /**
     * Erzeugt ein Objekt, das die Schnittstelle Sorter für den
     * HeapSort-Algorithmus implementiert.
     */
    public Sorter newHeapSort(int capacity);

}
