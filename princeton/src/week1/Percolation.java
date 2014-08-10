package week1;/* Created by vergiliu on 7/24/14
 */

public class Percolation {
    private int [][]matrix;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++) {
                matrix[i][j] = 0;
            }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (matrix[i][j] != 0)
            matrix[i][j] = 1;
    }

    public boolean isOpen(int i, int j) {
        if (matrix[i][j] == 0) return false;
        else return true;
    }    // is site (row i, column j) open?

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (matrix[i][j] == 1) return false;
        else return true;
    }

    public boolean percolates() {
        return true;
    }           // does the system percolate?
/*    Also, include a main() method that takes two command-line arguments N and T, performs T independent computational experiments (discussed above) on an N-by-N grid, and prints out the mean, standard deviation, and the 95% confidence interval for the percolation threshold. Use standard random from our standard libraries to generate random numbers; use standard statistics to compute the sample mean and standard deviation.
*/
    public static void main(String []args) {

    }
    /*
    % java PercolationStats 200 100
    mean                    = 0.5929934999999997
    stddev                  = 0.00876990421552567
            95% confidence interval = 0.5912745987737567, 0.5947124012262428

            % java PercolationStats 200 100
    mean                    = 0.592877
    stddev                  = 0.009990523717073799
            95% confidence interval = 0.5909188573514536, 0.5948351426485464


            % java PercolationStats 2 10000
    mean                    = 0.666925
    stddev                  = 0.11776536521033558
            95% confidence interval = 0.6646167988418774, 0.6692332011581226

            % java PercolationStats 2 100000
    mean                    = 0.6669475
    stddev                  = 0.11775205263262094
            95% confidence interval = 0.666217665216461, 0.6676773347835391
*/
    /*
    Deliverables. Submit only Percolation.java (using the weighted quick-union algorithm as implemented in the WeightedQuickUnionUF class) and PercolationStats.java. We will supply stdlib.jar and WeightedQuickUnionUF. Your submission may not call any library functions other than those in java.lang, stdlib.jar, and WeightedQuickUnionUF.
     */
}
