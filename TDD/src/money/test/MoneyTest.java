/**
 * Created by vergiliu on 11/11/13.
 */

package money.test;

import money.src.Money;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {
    @Test
    public void testMultiply() {
        Money myFiver = Money.dollar(5);
        assertEquals(Money.dollar(10), myFiver.times(2));
        assertEquals(Money.dollar(15), myFiver.times(3));
    }

    @Test
    public void testDollarEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(10)));
    }

    @Test
    public void testFrancEquality() {
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(10)));
    }

    @Test
    public void testCurrenciesEquality() {
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testFrancMultiplications() {
        Money myFiveFranc = Money.franc(5);
        assertEquals(Money.franc(10), myFiveFranc.times(2));
        assertEquals(Money.franc(15), myFiveFranc.times(3));
    }
}
