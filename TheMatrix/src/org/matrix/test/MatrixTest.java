package org.matrix.test;

import org.junit.Test;
import org.matrix.Matrix;

import static junit.framework.Assert.*;


public class MatrixTest{
    private static final double EPSILON = 0.0001;
    @Test
    public void createEmptyMatrix() {
        Matrix emptyMatrix = new Matrix();
        assertEquals(0, emptyMatrix.getRows());
        assertEquals(0, emptyMatrix.getColumns());
    }
    @Test
    public void createOneByOneMatrix() {
        Matrix myOneByOneMatrix = new Matrix(1, 1);
        assertEquals(1, myOneByOneMatrix.getColumns());
        assertEquals(1, myOneByOneMatrix.getRows());
        assertEquals(0.0, myOneByOneMatrix.get(0, 0), EPSILON);
        assertTrue(myOneByOneMatrix.isZero());
    }
    @Test
    public void createMatrixFromDoubles() {
        double [][]initMatrix = {{1, 2}, {3, 4}};
        Matrix myMatrix = new Matrix(initMatrix);
        assertEquals(1.0, myMatrix.get(0, 0), EPSILON);
        assertEquals(2.0, myMatrix.get(0, 1), EPSILON);
        assertEquals(3.0, myMatrix.get(1, 0), EPSILON);
        assertEquals(4.0, myMatrix.get(1, 1), EPSILON);
        assertEquals(2, myMatrix.getRows());
        assertEquals(2, myMatrix.getColumns());
    }
    @Test
    public void addOne() {
        Matrix myMatrix = new Matrix(1,1);
        myMatrix.add(1.0);
        assertFalse(myMatrix.isZero());
        assertEquals(1.0, myMatrix.get(0, 0), EPSILON);
        myMatrix.add(2.0);
        assertEquals(3.0, myMatrix.get(0, 0), EPSILON);
    }
    @Test
    public void createColumnMatrix() {
        double []myData ={1.0, 2.0};
        Matrix myMatrix = Matrix.createColumnMatrix(myData);
        assertEquals(2, myMatrix.getRows());
        assertEquals(1, myMatrix.getColumns());
        assertEquals(1.0, myMatrix.get(0, 0), EPSILON);
        assertEquals(2.0, myMatrix.get(1, 0), EPSILON);
    }
    @Test
    public void createRowMatrix() {
        double []myData ={1.0, 2.0};
        Matrix myMatrix = Matrix.createRowMatrix(myData);
        assertEquals(1, myMatrix.getRows());
        assertEquals(2, myMatrix.getColumns());
        assertEquals(1.0, myMatrix.get(0, 0), EPSILON);
        assertEquals(2.0, myMatrix.get(0, 1), EPSILON);
    }
    @Test
    public void matrixToArray() {
        Matrix myMatrix = new Matrix(2, 2);
        myMatrix.set(0, 0, 1.0);
        myMatrix.set(0, 1, 2.0);
        myMatrix.set(1, 0, 3.0);
        myMatrix.set(1, 1, 4.0);
        double []myArray = myMatrix.toPackedArray();
        assertEquals(4, myArray.length);
        assertEquals(myArray[0], 1.0);
        assertEquals(myArray[1], 2.0);
        assertEquals(myArray[2], 3.0);
        assertEquals(myArray[3], 4.0);
    }
    @Test
    public void columnMatrixToArray() {
        double []myinitMatrix = {1, 2, 3};
        Matrix myMatrix = Matrix.createColumnMatrix(myinitMatrix);
        double []myArrayFromMatrix = myMatrix.toPackedArray();
        assertEquals(3, myArrayFromMatrix.length);
        assertEquals(myinitMatrix[0], myArrayFromMatrix[0], EPSILON);
        assertEquals(myinitMatrix[1], myArrayFromMatrix[1], EPSILON);
        assertEquals(myinitMatrix[2], myArrayFromMatrix[2], EPSILON);
    }
    @Test
    public void rowMatrixToArray() {
        double []myinitMatrix = {1, 2, 3};
        Matrix myMatrix = Matrix.createRowMatrix(myinitMatrix);
        double []myArrayFromMatrix = myMatrix.toPackedArray();
        assertEquals(3, myArrayFromMatrix.length);
        assertEquals(myinitMatrix[0], myArrayFromMatrix[0], EPSILON);
        assertEquals(myinitMatrix[1], myArrayFromMatrix[1], EPSILON);
        assertEquals(myinitMatrix[2], myArrayFromMatrix[2], EPSILON);
    }
    @Test
    public void sumAllElements() {
        double []myData = {1.0, 2.0, 3.0};
        Matrix myMatrix = Matrix.createRowMatrix(myData);
        assertEquals(6.0, myMatrix.sum(), EPSILON);
    }
    @Test
    public void matrixIsVector() {
        double []myData = {1.0, 2.0, 3.0};
        Matrix myRowMatrix = Matrix.createRowMatrix(myData);
        Matrix myColMatrix = Matrix.createColumnMatrix(myData);
        assertTrue(myRowMatrix.isVector());
        assertTrue(myColMatrix.isVector());
    }
    @Test
    public void getRowAsMatrix() {
        Matrix myMatrix = new Matrix(2, 2);
        myMatrix.set(0, 0, 1.0);
        myMatrix.set(0, 1, 2.0);
        myMatrix.set(1, 0, 3.0);
        myMatrix.set(1, 1, 4.0);
        Matrix myRowMatrix = myMatrix.getRow(1);
        assertTrue(myRowMatrix.isVector());
        assertEquals(4.0, myRowMatrix.get(0, 1), EPSILON);
    }
    @Test
    public void getColAsMatrix() {
        Matrix myMatrix = new Matrix(2, 2);
        myMatrix.set(0, 0, 1.0);
        myMatrix.set(0, 1, 2.0);
        myMatrix.set(1, 0, 3.0);
        myMatrix.set(1, 1, 4.0);
        Matrix myColMatrix = myMatrix.getColumn(1);
        assertTrue(myColMatrix.isVector());
        assertEquals(2.0, myColMatrix.get(0, 0), EPSILON);
    }
    @Test
    public void clearMatrix() {
        Matrix myMatrix = new Matrix(1,1);
        myMatrix.set(0, 0, 1.0);
        assertFalse(myMatrix.isZero());
        myMatrix.clear();
        assertTrue(myMatrix.isZero());
    }
    @Test
    public void cloneAndEqualMatrixes() {
        Matrix myMatrix = new Matrix(2, 2);
        myMatrix.set(0, 0, 1.0);
        myMatrix.set(0, 1, 2.0);
        myMatrix.set(1, 0, 3.0);
        myMatrix.set(1, 1, 4.0);
        Matrix myClonedMatrix = myMatrix.clone();
        assertTrue(myMatrix.equals(myClonedMatrix));
        assertEquals(2, myClonedMatrix.getRows());
        assertEquals(2, myClonedMatrix.getColumns());
    }
    @Test
    public void testPrecisionEquals() {
        Matrix myMatrix = new Matrix(1,1);
        myMatrix.set(0, 0, 1.001);
        Matrix myWrongPrecisionMatrix = new Matrix(1,1);
        myWrongPrecisionMatrix.set(0, 0, 1.0);
        assertTrue(myMatrix.equals(myWrongPrecisionMatrix, 2));
        assertFalse(myMatrix.equals(myWrongPrecisionMatrix, 3));
    }
    @Test
    public void differentMatrixes() {
        Matrix myMatrix1 = new Matrix(1, 1);
        Matrix myMatrix2 = new Matrix(1, 1);
        myMatrix1.set(0, 0, 1.0);
        myMatrix2.set(0, 0, 2.0);
        assertFalse(myMatrix1.equals(myMatrix2));
    }
}
