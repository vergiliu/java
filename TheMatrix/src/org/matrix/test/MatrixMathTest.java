package org.matrix.test;

import org.junit.Test;
import org.matrix.Matrix;
import org.matrix.MatrixMath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MatrixMathTest {
    private static final double EPSILON = 0.0001;
    @Test
    public void testAdd() {
        double [][]initMatrix = {{1, 2}, {3, 4}};
        double [][]sumMatrix = {{2, 4}, {6, 8}};
        Matrix myMatrix1 = new Matrix(initMatrix);
        Matrix myMatrix2 = new Matrix(initMatrix);
        Matrix myOutputMatrix = new Matrix(sumMatrix);
        Matrix mySumMatrix = MatrixMath.add(myMatrix1, myMatrix2);
        assertTrue(mySumMatrix.equals(myOutputMatrix));
    }
    @Test
    public void testSubtract() {
        double [][]initMatrix = {{1, 2}, {3, 4}};
        Matrix myMatrix1 = new Matrix(initMatrix);
        Matrix myMatrix2 = new Matrix(initMatrix);
        Matrix myOutputMatrix = new Matrix(2, 2);
        Matrix mySubtractMatrix = MatrixMath.subtract(myMatrix1, myMatrix2);
        assertTrue(mySubtractMatrix.equals(myOutputMatrix));
        assertTrue(mySubtractMatrix.isZero());
    }
    @Test
    public void testDivide() {
        double [][]initMatrix = {{2, 4}, {8, 16}};
        double [][]dividedMatrix = {{1, 2}, {4, 8}};
        Matrix myMatrix = new Matrix(initMatrix);
        Matrix myOutputMatrix = new Matrix(dividedMatrix);
        Matrix myDividedMatrix = MatrixMath.divide(myMatrix, 2.0);
        assertTrue(myDividedMatrix.equals(myOutputMatrix));
    }
    @Test
    public void createIdentityMatrix() {
        double [][]initMatrix = {{1, 0}, {0, 1}};
        Matrix myMatrix = new Matrix(initMatrix);
        Matrix identityMatrix = MatrixMath.identity(2);
        assertTrue(identityMatrix.equals(myMatrix));
    }
    @Test
    public void testDotProduct() {
        double []rowMatrix = {1, 2, 3, 4};
        double []columnMatrix = {5, 6, 7, 8};
        Matrix myRowMatrix = Matrix.createRowMatrix(rowMatrix);
        Matrix myColumnMatrix = Matrix.createColumnMatrix(columnMatrix);
        assertEquals(70.0, MatrixMath.dotProduct(myRowMatrix, myColumnMatrix), EPSILON);
    }
    @Test
    public void testTransposeMatrix() {
        double [][]initMatrix = {{1, 2}, {3, 4}, {5, 6}};
        double [][]outMatrix = {{1, 3, 5}, {2, 4, 6}};
        Matrix myMatrix = new Matrix(initMatrix);
        Matrix myOutputMatrix = new Matrix(outMatrix);
        Matrix myTransposedMatrix = MatrixMath.transpose(myMatrix);
        assertTrue(myTransposedMatrix.equals(myOutputMatrix));
    }
    @Test
    public void testTransposeVectorMatrix() {
        double []inputData = {1, 2, 3};
        Matrix myColMatrix = Matrix.createColumnMatrix(inputData);
        Matrix myRowMatrix = Matrix.createRowMatrix(inputData);
        Matrix myTransposedMatrix1 = MatrixMath.transpose(myColMatrix);
        Matrix myTransposedMatrix2 = MatrixMath.transpose(myRowMatrix);
        assertTrue(myTransposedMatrix1.equals(myRowMatrix));
        assertTrue(myTransposedMatrix2.equals(myColMatrix));
    }
    @Test
    public void multiplyWithScalar() {
        double [][]initMatrix = {{2, 4}, {8, 16}};
        double [][]multiplyMatrix = {{4, 8}, {16, 32}};
        Matrix myMatrix = new Matrix(initMatrix);
        Matrix myOutputMatrix = new Matrix(multiplyMatrix);
        Matrix mySumMatrix = MatrixMath.multiply(myMatrix, 2);
        assertTrue(mySumMatrix.equals(myOutputMatrix));
    }
    @Test
    public void testVectorLength() {
        double []initData = {3, 4};
        Matrix myMatrix = Matrix.createRowMatrix(initData);
        assertEquals(5.0, MatrixMath.vectorLength(myMatrix), EPSILON);
    }
    @Test
    public void multiplyMatrixes() {
        double [][]initData1 = {{1, 4}, {2, 5}, {3, 6}};
        double [][]initData2 = {{7, 8, 9}, {10, 11, 12}};
        double [][]outputData = {{47, 52, 57}, {64, 71, 78}, {81, 90, 99}};
        Matrix myMatrix1 = new Matrix(initData1);
        Matrix myMatrix2 = new Matrix(initData2);
        Matrix outputMatrix = new Matrix(outputData);
        Matrix multiplyMatrixResult = MatrixMath.multiply(myMatrix1, myMatrix2);
        assertTrue(multiplyMatrixResult.equals(outputMatrix));
    }
    @Test
    public void multiplyMatrixesWithIdentity() {
        double [][]initData = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix myMatrix = new Matrix(initData);
        Matrix multiplyMatrixResult = MatrixMath.multiply(myMatrix, MatrixMath.identity(3));
        assertTrue(multiplyMatrixResult.equals(myMatrix));
    }
}
