package ab1;

import ab1.impl.BerishajVojticekKozlov.Ab1Impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.NoSuchElementException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Ab1Tests {

    public final static Random rand = new Random(System.currentTimeMillis());

    private static Ab1 impl = new Ab1Impl();

    public final static int ARRAY_SIZE = 1000000;
    public final static int REPEATS = 10;

    private void test_Sorter_small(Sorter s) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        s.sort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);

        a = new int[]{4, 4, 1, 2, 2};
        s.sort(a);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, a);

        a = new int[]{4, 1, 5, 2, 3};
        s.sort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);

        a = new int[]{1, 2, 3, 4};
        s.sort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4}, a);

        a = new int[]{2, 1, 2, 1};
        s.sort(a);
        assertArrayEquals(new int[]{1, 1, 2, 2}, a);

        a = new int[]{1, 1, 1};
        s.sort(a);
        assertArrayEquals(new int[]{1, 1, 1}, a);

        a = new int[]{2, 1};
        s.sort(a);
        assertArrayEquals(new int[]{1, 2}, a);
    }

    private void test_Sorter_large(Sorter s) {
        int[] a = new int[ARRAY_SIZE];
        int[] b = new int[ARRAY_SIZE];

        for (int rep = 0; rep < REPEATS; rep++) {
            for (int i = 0; i < ARRAY_SIZE; i++)
                a[i] = b[i] = rand.nextInt();
            s.sort(a);
            Arrays.sort(b);
            assertArrayEquals(b, a);
        }
    }

    @Test
    public void SortedList_insert() {
        SortedList l = impl.newSortedList();

        l.insert(1);
        assertEquals(1, l.getLength());
        assertArrayEquals(new int[]{1}, l.toArray());

        l.clear();
        assertEquals(0, l.getLength());
        assertArrayEquals(new int[]{}, l.toArray());

        l.insert(3);
        l.insert(1);
        assertEquals(2, l.getLength());
        assertArrayEquals(new int[]{1, 3}, l.toArray());

        l.clear();
        l.insert(0);
        l.insert(2);
        l.insert(3);
        l.insert(1);
        assertEquals(4, l.getLength());
        assertArrayEquals(new int[]{0, 1, 2, 3}, l.toArray());
    }

    @Test
    public void SortedList_insert_exception() {
        SortedList l = impl.newSortedList();

        l.insert(1);
        l.insert(2);

        assertThrows(IllegalArgumentException.class, () -> {
            l.insert(2);
        });
    }
    // TODO
    @Test
    public void SortedList_remove() {
        SortedList l = impl.newSortedList();

        l.insert(4);
        l.insert(1);
        l.insert(7);
        l.insert(2);
        l.insert(3);
        l.insert(5);
        l.insert(6);

        l.remove(3);
        assertEquals(6, l.getLength());
        assertArrayEquals(new int[]{1, 2, 4, 5, 6, 7}, l.toArray());

        l.remove(1);
        assertEquals(5, l.getLength());
        assertArrayEquals(new int[]{2, 4, 5, 6, 7}, l.toArray());

        l.remove(7);
        assertEquals(4, l.getLength());
        assertArrayEquals(new int[]{2, 4, 5, 6}, l.toArray());
    }
    // test passed
    @Test
    public void QuickSort_small() {
        test_Sorter_small(impl.newQuickSort());
    }
    // test passed
    @Test
    public void QuickSort_large() {
        test_Sorter_large(impl.newQuickSort());
    }

    private void test_Heap_add(int[] values) {
        Heap h = impl.newHeap(values.length);
        int max = Integer.MIN_VALUE;
        h.clear();
        assertEquals(0, h.size());
        for (int i = 0; i < values.length; i++) {
            h.add(values[i]);
            if (values[i] > max)
                max = values[i];
            assertEquals(max, h.max());
            assertEquals(i + 1, h.size());
        }
    }
    // test passed
    @Test
    public void Heap_add() {
        test_Heap_add(new int[]{1, 2, 3, 7, 4, 7, 6});
        test_Heap_add(new int[]{2, 2, 3, 7, 4, 6, 8, 5});
    }

    private void test_Heap_remove(int[] values) {
        Heap h = impl.newHeap(values.length);
        for (int v : values)
            h.add(v);
        assertEquals(values.length, h.size());
        int[] sorted = Arrays.copyOf(values, values.length);
        Arrays.sort(sorted);
        for (int i = sorted.length - 1; i >= 0; i--) {
            assertEquals(sorted[i], h.max());
            assertEquals(sorted[i], h.removeMax());
            assertEquals(i, h.size());
        }
    }
    // test passed
    @Test
    public void Heap_remove() {
        test_Heap_remove(new int[]{5, 2, 3, 5, 4, 7, 6});
        test_Heap_remove(new int[]{2, 2, 3, 7, 4, 6, 8, 5});
    }
    // test passed
    @Test
    public void Heap_add_exception() {
        Heap h = impl.newHeap(3);
        h.add(1);
        h.add(2);
        h.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            h.add(4);
        });
    }
    // test passed
    @Test
    public void Heap_remove_exception() {
        Heap h = impl.newHeap(3);

        assertThrows(NoSuchElementException.class, () -> {
            h.removeMax();
        });
    }
    // test passed
    @Test
    public void Heap_max_exception() {
        Heap h = impl.newHeap(3);

        h.add(1);
        h.clear();

        assertThrows(NoSuchElementException.class, () -> {
            h.max();
        });
    }
    // test passed
    @Test
    public void HeapSort_small() {
        test_Sorter_small(impl.newHeapSort(5));
    }
    // test passed
    @Test
    public void HeapSort_large() {
        test_Sorter_large(impl.newHeapSort(ARRAY_SIZE));
    }
}
