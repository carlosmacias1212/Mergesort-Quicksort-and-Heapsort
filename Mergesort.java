
/*
Best Case: O(nlgn)
Average Case: O(nlgn)
Worst Case: O(nlgn)

Merge sort is consistent across all 3 types and sizes of arrays since the splitting and comparisons
when merging are happening regardless of the prior sorting of the array. Overall Mergesort seemed to have
lower comparisons than other sorting algorithms which is probably due to its lack of variability in time
complexity.
 */

public class Mergesort {

    private int comparisons = 0;

    private void merge(int[] arr, int[] aux, int low, int mid, int high) {

        // copy array into auxiliary array, for comparisons
        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }

        // initialize pointers for left and right halves (each half is sorted within itself)
        int i = low;
        int j = mid + 1;

        // sort entire array using aux for help
        for (int k = low; k <= high; k++) {

            // pointer for left half is exhausted, no more comparisons between halves needed
            if (i > mid) {
                arr[k] = aux[j++];
                comparisons++;

            } else if (j > high) { // pointer for right half is exhausted
                arr[k] = aux[i++];
                comparisons++;

            } else {


                // check which element next in line from each half is the lower of the two
                if (aux[i] <= aux[j]) {
                    arr[k] = aux[i++];

                } else {
                    arr[k] = aux[j++];

                }
                comparisons++;


            }
        }

    }

    // Initial call to sort, outside of Mergesort class
    public int sort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, (arr.length - 1));
        return comparisons;
    }

    //Reconfigured call to sort with all necessary parameters
    private void sort(int[] arr, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        // find splitting point of array
        int mid = low + (high - low) / 2;

        // recursively sort left and right half
        sort(arr, aux, low, mid);
        sort(arr, aux, mid+1, high);

        // merge left and right half
        merge(arr, aux, low, mid, high);
    }
}
