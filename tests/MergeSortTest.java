import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        int[] unsorted = new int[] {2, 1, -1, 4, 3};
        int[] sorted = MergeSort.sort(unsorted);
        System.out.println(Arrays.toString(sorted));
        Arrays.sort(unsorted);
        assertArrayEquals(unsorted, sorted);
    }
}