public class MergeSort {
    private static void merge(Comparable []a, Comparable []aux, int lo, int mid, int hi) {
//        assert isSorted(a, lo, mid);
//        assert isSorted(a, mid+1, hi);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            System.err.println(i + " "+  j+" " + k);
            if      (i > mid)                a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[j++];
            // issue on next line
            else if (aux[j].compareTo(aux[i]) < 0)  a[k] = aux[j++];  //aux[j] < a[i]
            else                            a[k] = aux[j++];
        }
//        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable []a, Comparable []aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);

        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable []a) {
        Comparable []aux = new Comparable[a.length];
        assert aux.length == a.length;
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        String[] merge_array = "AAA BBB CCC DDD EEE FFF".split(" ");
        sort(merge_array);
        System.err.println(merge_array);
    }
}
