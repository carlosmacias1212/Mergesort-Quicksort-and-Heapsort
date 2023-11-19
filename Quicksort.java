
/*
Best Case: O(nlgn)
Average Case: O(nlgn)
Worst Case: O(n^2)

Quicksort is relatively efficient in most cases especially when elements are randomized, or most pivot elements
belong somewhere near the middle. The worst case occurs when elements are ordered such that the pivot element is
always the least or greatest element, causing quadratic time complexity. This can be seen when the array was
ordered since in smaller array sizes, comparisons were much larger than the randomized array, while in
larger array sizes, a stack overflow occured.
 */
public class Quicksort {

    private int comparisons = 0;

    private int partition(int[] arr, int low, int high) {

        // Left and right pointers for swapping
        int i = low;
        int j = high + 1;

        // We are partitioning on value of 'low'
        while (true) {


            // Find value that belongs on right side of partition element

            while (arr[++i] < arr[low]) {
                comparisons++;

                if (i == high) {
                    break;
                }
            }
            comparisons++;

            // Find value that belongs on left side of partition element

            while (arr[--j] > arr[low]) {
                comparisons++;

                if (j == low) {
                    break;
                }
            }
            comparisons++;

            // All elements compared
            if (i >= j) {
                break;
            }

            // Assuming no condition to break occurs, swap elements to the proper side (relative to partition)
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        // Swap partition element into its proper place, where all elements to its left are not greater than, and all elements to right are not less than
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        // Return index of partition element in its proper place
        return j;
    }

    // Initial call to sort, outside of Quicksort class
    public int sort(int[] arr) {

        sort(arr, 0, arr.length-1);
        return comparisons;
    }

    // Reconfigured call to sort, with necessary parameters
    private void sort(int[] arr, int low, int high) {

        // Exhausted partitions
        if (high <= low) {
            return;
        }

        // Partition array
        int p = partition(arr, low, high);

        // Sort values on the left of partition, recursively
        sort(arr, low, p-1);

        // Sort values on the right of partition, recursively
        sort(arr, p+1, high);
    }
}
