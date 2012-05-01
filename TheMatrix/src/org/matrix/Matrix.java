package org.matrix;

/**
 * Holds a matrix :)
 */

public class Matrix {
    private int theNumberOfColumns;
    private int theNumberOfRows;
    private double [][]theMatrix;

    public Matrix() {
        this.theNumberOfRows = 0;
        this.theNumberOfColumns = 0;
        this.theMatrix = null;
    }
    public Matrix(final int rows, final int columns) {
        this.theNumberOfRows = rows;
        this.theNumberOfColumns = columns;
        this.theMatrix = new double[rows][columns];
    }
    public Matrix(final double [][]initialMatrix) {
        this.theNumberOfRows = initialMatrix.length;
        this.theNumberOfColumns = initialMatrix[0].length;
        this.theMatrix = new double[this.theNumberOfRows][this.theNumberOfColumns];
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                this.theMatrix[i][j] = initialMatrix[i][j];
    }
    public Matrix clone() {
        Matrix myMatrix = new Matrix(this.theNumberOfRows, this.theNumberOfColumns);
        for (int i=0; i<this.theNumberOfRows; i++)
            for(int j=0; j<this.theNumberOfColumns; j++)
                myMatrix.set(i, j, this.get(i, j));
        return myMatrix;
    }
    public void add(final double value) {
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                this.theMatrix[i][j] += value;
    }
    public void clear() {
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                this.theMatrix[i][j] = 0;
    }
    public boolean equals(final Matrix matrix) {
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                if (this.theMatrix[i][j] != matrix.get(i, j))
                    return false;
        return true;
    }
    public boolean equals(final Matrix matrix, int precision) {
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                if (roundToDecimals(this.theMatrix[i][j], precision) != roundToDecimals(matrix.get(i, j), precision))
                    return false;
        return true;
    }
    public double get(final int row, final int column) {
        return this.theMatrix[row][column];
    }
    public int getRows() {
        return this.theNumberOfRows;
    }
    public int getColumns() {
        return this.theNumberOfColumns;
    }
    public Matrix getColumn(final int col) {
        Matrix myMatrix = new Matrix(this.theNumberOfRows, 1);
        for (int i=0; i<this.theNumberOfRows; i++)
            myMatrix.set(i, 0, this.theMatrix[i][col]);
        return myMatrix;
    }
    public Matrix getRow(final int row) {
        Matrix myMatrix = new Matrix(1, this.theNumberOfColumns);
        for (int i=0; i<this.theNumberOfColumns; i++)
            myMatrix.set(0, i, this.theMatrix[row][i]);
        return myMatrix;
    }
    public boolean isVector() {
        if (this.theNumberOfColumns == 1 || this.theNumberOfRows == 1)
            return true;
        else
            return false;
    }
    public boolean isZero() {
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                if (0 != this.theMatrix[i][j])
                    return false;
        return true;
    }
    public void set(final int row, final int col, final double value) {
        this.theMatrix[row][col] = value;
    }
    public double sum() {
        double mySum = 0.0;
        for (int i=0; i<this.theNumberOfRows; i++)
            for (int j=0; j<this.theNumberOfColumns; j++)
                mySum += this.theMatrix[i][j];
        return mySum;
    }
    public double[] toPackedArray() {
        double []myPackedArray = new double[this.theNumberOfRows*this.theNumberOfColumns];
        for (int i=0, z=0; i<this.theNumberOfRows; i++) {
            for (int j=0; j<this.theNumberOfColumns; j++)
                myPackedArray[i*this.theNumberOfColumns+j] = this.theMatrix[i][j];
        }
        return myPackedArray;
    }
    public static Matrix createColumnMatrix(final double input[]) {
        Matrix myMatrix = new Matrix(input.length, 1);
        for (int i=0; i<input.length; i++)
            myMatrix.set(i, 0, input[i]);
        return myMatrix;
    }
    public static Matrix createRowMatrix(final double input[]) {
        Matrix myMatrix = new Matrix(1, input.length);
        for (int i=0; i<input.length; i++)
            myMatrix.set(0, i, input[i]);
        return myMatrix;
    }
    private double roundToDecimals(double doubleValue, int decimals) {
        java.math.BigDecimal bigDecimalNumber;
        bigDecimalNumber = new java.math.BigDecimal(doubleValue);
        bigDecimalNumber = bigDecimalNumber.setScale(decimals,java.math.BigDecimal.ROUND_HALF_UP);
        return bigDecimalNumber.doubleValue();
    }
}
