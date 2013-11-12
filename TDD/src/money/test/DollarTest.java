/**
 * Created by vergiliu on 11/11/13.
 */

package money.test;

import money.src.Dollar;
import money.src.Franc;
import org.junit.Test;

import static org.junit.Assert.*;

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

        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(10)));
    }

    @Test
    public void testFrancMultiplications() {
        Franc myFiveFranc = new Franc(5);
        assertEquals(new Franc(10), myFiveFranc.times(2));
        assertEquals(new Franc(15), myFiveFranc.times(3));
    }
}
