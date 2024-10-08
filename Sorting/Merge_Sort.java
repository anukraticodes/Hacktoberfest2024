// Merge Sort is a divide-and-conquer algorithm that splits an array into two halves, recursively sorts each half, and merges them back together.
// Time Complexity: O(n log n)

// Merge Sort:
// Split the array:

// Recursively divide the array into two halves until each half has one element.
// Merge the sorted halves:

// Merge the two halves by comparing elements and arranging them in the correct order.
// Repeat:

// Repeat the process for every divided portion until the entire array is sorted.

// Code
public class MergeSort {
    
    // Function to perform merge sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two subarrays
    static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the values
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into the original array

        // Initial indices of leftArray, rightArray, and merged array
        int i = 0, j = 0;
        int k = left;

        // Compare and merge the arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Call mergeSort on the entire array
        mergeSort(arr, 0, arr.length - 1);

        // Output sorted array
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
