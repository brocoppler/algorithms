import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    private int inversions = 0;

    MergeSort() {}

    public int[] sort(int[] unsorted) {
        // split in half
        // call sort on each half
        int[] sorted = new int[unsorted.length];
        if (unsorted.length == 1)
            sorted = unsorted;
        else {
            int[] left = Arrays.copyOfRange(unsorted, 0, (unsorted.length) / 2);
            int[] right = Arrays.copyOfRange(unsorted, (unsorted.length) / 2, unsorted.length);
            sorted = merge(sort(left), sort(right));
        }

        return sorted;
    }

    /*
     * This should always be passed two *sorted* arrays
     * to merge together
     */
    private int[] merge(int[] left, int[] right) {
        int n = left.length + right.length;
        int[] merged = new int[n];
        int i = 0;
        int j = 0;
        for (int k = 0; k <= n; k++) {
            if (left[i] < right[j]) {
                merged[k] = left[i];
                i++;
            } else if (right[j] < left[i]) {
                merged[k] = right[j];
                j++;
                inversions = inversions + (left.length - i);
            } else {
                merged[k] = left[i];
                merged[k + 1] = right[j];
                i++;
                j++;
                k++;
            }

            if (i >= left.length) {
                System.arraycopy(right, j, merged, k + 1, n - k - 1);
                break;
            } else if (j >= right.length) {
                System.arraycopy(left, i, merged, k + 1, n - k - 1);
                break;
            }
        }

        return merged;
    }

    public int getInversions() {
        return inversions;
    }
}