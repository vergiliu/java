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
        Dollar myTen = myFiver.times(2);
        assertEquals(10, myTen.getAmount());
        Dollar myFifteen = myFiver.times(3);
        assertEquals(15, myFifteen.getAmount());
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(10)));
    }
}
