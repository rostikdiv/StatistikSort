package StatistikSort;

import java.util.Arrays;
import java.util.Random;

public class Statistics {
    public static void nth_element(int[] arr, int first, int last, int n) {
        for (;;) {
            Random random = new Random();
            int k = randomizedPartition(arr, first, last, random);
            if (n < k) {
                last = k;
            } else if (n > k) {
                first = k + 1;
            } else {
                return;
            }
        }
    }

    static int randomizedPartition(int[] arr, int first, int last, Random rnd) {
        swap(arr, first + rnd.nextInt(last - first), last - 1);

        int separator = arr[last - 1];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (arr[j] <= separator) {
                swap(arr, ++i, j);
            }
        }
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

}

