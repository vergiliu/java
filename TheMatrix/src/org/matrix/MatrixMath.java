package org.matrix;

public class MatrixMath {
    public static Matrix add(final Matrix a, final Matrix b) {
        Matrix myMatrix = new Matrix(a.getRows(), a.getColumns());
        for (int i=0; i<myMatrix.getRows(); i++)
            for (int j=0; j<myMatrix.getColumns(); j++)
                myMatrix.set(i, j, a.get(i, j) + b.get(i, j));
        return myMatrix;
    }
    public static Matrix divide(final Matrix a, final double b) {
        Matrix myMatrix = new Matrix(a.getRows(), a.getColumns());
        for (int i=0; i<myMatrix.getRows(); i++)
            for (int j=0; j<myMatrix.getColumns(); j++)
                myMatrix.set(i, j, a.get(i, j) / b);
        return myMatrix;
    }
    public static double dotProduct(final Matrix a, final Matrix b) {
        double mySum = 0;
        final double []myRowArray = a.toPackedArray();
        final double []myColumnArray = b.toPackedArray();
        for (int i=0; i<myRowArray.length; i++)
            mySum += myRowArray[i] * myColumnArray[i];
        return mySum;
    }
    public static Matrix identity(final int size) {
        Matrix myMatrix = new Matrix(size, size);
        for (int i=0; i<size; i++)
            myMatrix.set(i, i, 1.0);
        return myMatrix;
    }
    public static Matrix multiply(final Matrix a, final double b) {
        Matrix myMatrix = new Matrix(a.getRows(), a.getColumns());
        for (int i=0; i<myMatrix.getRows(); i++)
            for (int j=0; j<myMatrix.getColumns(); j++)
                myMatrix.set(i, j, a.get(i, j) * b);
        return myMatrix;
    }
    public static Matrix multiply(final Matrix a, final Matrix b) {
        Matrix myMatrix = new Matrix(a.getRows(), b.getColumns());
        double computedValue;
        for (int i=0; i< myMatrix.getRows(); i++)
            for (int j=0; j<myMatrix.getColumns(); j++) {
                computedValue = dotProduct(a.getRow(i), b.getColumn(j));
                myMatrix.set(i, j, computedValue);
            }
        return myMatrix;
    }
    public static Matrix subtract(final Matrix a, final Matrix b) {
        Matrix myMatrix = new Matrix(a.getRows(), a.getColumns());
        for (int i=0; i<myMatrix.getRows(); i++)
            for (int j=0; j<myMatrix.getColumns(); j++)
                myMatrix.set(i, j, a.get(i, j) - b.get(i, j));
        return myMatrix;
    }
    public static Matrix transpose(final Matrix input) {
        Matrix myMatrix = new Matrix(input.getColumns(), input.getRows());
        for (int i=0; i<input.getRows(); i++)
            for (int j=0; j<input.getColumns(); j++)
                myMatrix.set(j, i, input.get(i, j));
        return myMatrix;
    }
    public static double vectorLength(final Matrix inputMatrix) {
        double []myVector = inputMatrix.toPackedArray();
        double sum = 0.0;
        for (double value:myVector)
            sum += Math.pow(value, 2.0);
        return Math.sqrt(sum);
    }
}
