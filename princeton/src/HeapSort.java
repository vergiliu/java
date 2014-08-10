
public class HeapSort {

    private static void heapSort(Comparable[] a) {
        // build heap using bottom up method
        int N = a.length;
        for (int k=N/2; k >= 1; k--) {
            sink(a, k, N);
        }

        while (N > 1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && a[j -1].compareTo(a[ j+1 -1]) < 0) j++; // -1 as it's 1 indexed instead of 0 indexed
            if (!(a[k -1].compareTo(a[j -1]) < 0 )) break; // -1 as it's 1 indexed instead of 0 indexed
            exchange(a, k, j);
            k = j;
        }
    }

    private static void exchange(Comparable[] a, int i, int j) {
        // -1 as it's 1 indexed instead of 0 indexed
        Comparable tmp = a[i -1];
        a[i -1] = a[j -1];
        a[j -1] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] A = {"H", "E", "A", "P", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickSort.displayArray(A);
        heapSort(A);
        QuickSort.displayArray(A);
    }
}
