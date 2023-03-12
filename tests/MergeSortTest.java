import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        int[] unsorted = new int[] {2, 1, 0, -1, -2};
        MergeSort ms = new MergeSort();
        int[] sorted = ms.sort(unsorted);
        Arrays.sort(unsorted);
        assertArrayEquals(unsorted, sorted);
        assertEquals(10, ms.getInversions());
    }
}