
/*
Best Case: O(n)
Average Case: O(nlgn)
Worst Case: O(nlgn)

Heapsort is consistent in terms of the given arrays, since the only type of array that
would provide a noticeable difference in time complexity would be one with identical elements
since there is minimal exchanging and sinking. The nlgn time complexity occurs because
every element (n) may have to be exchanged across the heap's height (lgn)

 */

public class Heapsort {

    private int comparisons = 0;

    public int sort(int[] arr) {
        int n = arr.length;

        // Use the bottom up method to build heap from given array
        for (int i = n/2; i >= 0; i--) {
            sink(arr, i, n);
        }

        // exchange root of heap with last node, then ignore last node until sorted
        while (n > 0) {
            exch(arr, 0, (n - 1));
            sink(arr, 0, --n);
        }

        return comparisons;
    }

    private void sink(int[] arr, int i, int n) {

        // Outer while look ensures that children indices are within bounds of array length
        while (2*i + 1 < n) {

            // j initialized to index of left child off arr[i]
            int j = 2*i + 1;

            // If there exists a right child greater than the left child, increment j to be the index of the greatest child
            comparisons++;
            if (j < n && j+1 < n && (arr[j] < arr[j+1])) {
                j++;
            }

            // arr[i] is greater than both children so no need to exchange
            comparisons++;
            if (arr[i] > arr[j]) {
                break;
            }

            // exchange parent with greater child and continue heap construction
            exch(arr, i, j);
            i = j;
        }
    }

    private void exch(int[] arr, int j, int k) {

        int temp = arr[k];
        arr[k] = arr[j];
        arr[j] = temp;
    }
}
