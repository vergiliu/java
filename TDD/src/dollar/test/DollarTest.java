package dollar.test;

import dollar.src.Dollar;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vergiliu on 11/11/13.
 */

public class DollarTest {
    @Test
    public void testMultiply() {
        Dollar myFiver = new Dollar(5);
        assertEquals(new Dollar(10), myFiver.times(2));
        assertEquals(new Dollar(15), myFiver.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(10)));
    }
}
