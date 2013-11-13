/**
 * Created by vergiliu on 11/11/13.
 */
package money.test;

import money.Bank;
import money.Expression;
import money.Money;
import money.Sum;
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
    public void testCurrenciesEquality() {
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testFrancMultiplications() {
        Money myFiveFranc = Money.franc(5);
        assertEquals(Money.franc(10), myFiveFranc.times(2));
        assertEquals(Money.franc(15), myFiveFranc.times(3));
    }

    @Test
    public void testCurrencies() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.franc(1).getCurrency());
    }

    @Test
    public void testSimpleAddition() {
        Money myFive = Money.dollar(5);
        Expression result = myFive.plus(myFive);
        Sum sum = (Sum) result;
        Bank bank = new Bank();
        Money myReduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), myReduced);
    }

    @Test
    public void reduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void reduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
}
