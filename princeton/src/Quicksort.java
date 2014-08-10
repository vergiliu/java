
public class Quicksort {

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i].compareTo(a[lo]) < 0) {
                if (i == hi) break;
            }
            while (a[lo].compareTo(a[--j]) < 0) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);

        return j;
    }

    public static void sort(Comparable[] a) {
        // in order to get better performance
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int k = partition(a, lo, hi);
        sort(a, lo, k-1);
        sort(a, k+1, hi);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] A = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        displayArray(A);
        sort(A);
        displayArray(A);
    }

    private static void displayArray(Comparable[] anArray) {
        for (Comparable a : anArray) {
            System.err.print(a + " ");
        }
        System.err.println("\n");
    }
}
