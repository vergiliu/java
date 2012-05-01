package org.matrix.test;

import org.junit.Test;
import org.matrix.BiPolarUtil;

import static org.junit.Assert.assertEquals;

public class BiPolarUtilTest {
    private static final double EPSILON = 0.0001;
    @Test
    public void testConversionToDoubleTrue() {
        double myTrue = BiPolarUtil.bipolar2double(true);
        assertEquals(myTrue, 1.0, EPSILON);
    }
    @Test
    public void testConversionToDoubleFalse() {
        double myFalse = BiPolarUtil.bipolar2double(false);
        assertEquals(myFalse, -1.0, EPSILON);
    }
    @Test
    public void testConversionOfArray() {
        double []myInputArray={1.0, -1.0, 1.0, -1.0};
        boolean []myRefArray = {true, false, true, false};
        boolean []myOutputArray = BiPolarUtil.double2bipolar(myInputArray);
        for (int i=0; i<myInputArray.length; i++)
            assertEquals(myRefArray[i], myOutputArray[i]);
    }
    @Test
    public void testConversionMatrix() {
        double [][]myInoutMatrix = {{1.0, 1.0, 1.0}, {-1.0, -1.0, -1.0}};
        boolean [][]myRefBooleanMatrix = {{true, true, true}, {false, false, false}};
        boolean [][]myOutputMatrix = BiPolarUtil.double2bipolar(myInoutMatrix);
        for (int i=0;i < myInoutMatrix.length; i++)
            for (int j=0;j < myInoutMatrix[0].length; j++)
                assertEquals(myRefBooleanMatrix[i][j], myOutputMatrix[i][j]);
    }
    @Test
    public void testConversionToBoolPositive() {
        boolean myOne = BiPolarUtil.double2bipolar(1.0);
        assertEquals(myOne, true);
    }
    @Test
    public void testConversionToBoolNegative() {
        boolean myMinusOne = BiPolarUtil.double2bipolar(-1.0);
        assertEquals(myMinusOne, false);
    }
    @Test
    public void testConversionBoolArray() {
        boolean []myInputArray = {true, false, true, false};
        double []myRefArray={1.0, -1.0, 1.0, -1.0};
        double []myOutputArray = BiPolarUtil.bipolar2double(myInputArray);
        for (int i=0; i<myInputArray.length; i++)
            assertEquals(myRefArray[i], myOutputArray[i], EPSILON);
    }
    @Test
    public void testConversionBoolMatrix() {
        boolean [][]myInputMatrix = {{true, true, true}, {false, false, false}};
        double [][]myRefMatrix = {{1.0, 1.0, 1.0}, {-1.0, -1.0, -1.0}};
        double [][]myOutputMatrix = BiPolarUtil.bipolar2double(myInputMatrix);
        for (int i=0;i < myInputMatrix.length; i++)
            for (int j=0;j < myInputMatrix[0].length; j++)
                assertEquals(myRefMatrix[i][j], myOutputMatrix[i][j], EPSILON);
    }
}
