package org.matrix;

public class BiPolarUtil {
    public static double bipolar2double(final boolean bipolarValue) {
        if (true == bipolarValue ) return 1.0;
        else return -1.0;
    }
    public static double[] bipolar2double(final boolean bipolarArray[]) {
        double doubleArray[] = new double[bipolarArray.length];
        for (int i=0; i < bipolarArray.length; i++) {
            doubleArray[i] = bipolar2double(bipolarArray[i]);
        }
        return doubleArray;
    }
    public static double[][] bipolar2double(final boolean bipolarMatrix[][]) {
        double [][]doubleMatrix = new double[bipolarMatrix.length][bipolarMatrix[0].length]; /*is this wrong? :D*/
        for (int i=0;i < bipolarMatrix.length;i++)
            for (int j=0;j < bipolarMatrix[i].length; j++)
                doubleMatrix[i][j] = bipolar2double(bipolarMatrix[i][j]);
        return doubleMatrix;
    }
    public static boolean double2bipolar(final double doubleValue) {
        if ( doubleValue == 1) return true;
        else return false;
    }
    public static boolean[] double2bipolar(final double d[]) {
        boolean []booleanArray = new boolean[d.length];
        for (int i=0; i < d.length; i++)
            booleanArray[i] = double2bipolar(d[i]);
        return booleanArray;
    }
    public static boolean[][] double2bipolar(final double d[][]) {
        boolean [][]booleanMatrix = new boolean[d.length][d[0].length];
        for (int i=0; i < d.length; i++)
            for (int j=0; j < d[i].length; j++)
                booleanMatrix[i][j] = double2bipolar(d[i][j]);
        return booleanMatrix;
    }
}
