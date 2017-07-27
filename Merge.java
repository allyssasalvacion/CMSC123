package FirstLongExam;

/**
 * Created by Allyssa Albores on 18/07/2017.
 */
public class Merge {
    public static void mergeArrays(int[] A, int[] B, int n, int[] C) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < n && j < n) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        // Store remaining elements of first array
        while (i < n) {
            C[k++] = A[i++];
        }

        // Store remaining elements of second array
        while (j < n) {
            C[k++] = B[j++];
        }
    }

    public static void main (String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int n = arr1.length;

        int[] arr3 = new int[2*n];

        mergeArrays(arr1, arr2, n, arr3);

        System.out.println("Array after merging");

        for (int i = 0; i < n * 2; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}

