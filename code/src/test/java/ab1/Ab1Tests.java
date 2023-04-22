package ab1;

import ab1.impl.BerishajVojticekKozlov.Ab1Impl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Ab1Tests {
    private final Random random = new Random(System.currentTimeMillis());

    private static final Ab1 ab1Impl = new Ab1Impl();

    private static final int NUM_TESTS = 100;
    private static final int NUM_TESTS_MIDDLE = 200000;
    private static final int ARRAY_SIZE_SMALL = 7500;
    private static final int ARRAY_SIZE_MIDDLE = 5000000;
    private static final int ARRAY_SIZE_LARGE = 25_000_000;

    @Test
    public void testQuickSortSmall() {
        for (int i = 0; i < NUM_TESTS; ++i) {
            int[] testArray = getRandomArray(ARRAY_SIZE_SMALL);
            int[] copy = Arrays.copyOf(testArray, testArray.length);
            ab1Impl.newQuickSort();
            Arrays.sort(copy);
            assertArrayEquals(copy, testArray);
        }
    } //OK

    private int[] getRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; ++i)
            array[i] = Math.abs(random.nextInt(2 * size));
        return array;
    }
}