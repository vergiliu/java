/**
 * Created by vergiliu on 11/12/13.
 */

package money.src;

abstract public class Money {
    protected int theAmount;

    abstract public Money times(int aMultiplier);

    public Money(int anAmount) {
        theAmount = anAmount;
    }
    public boolean equals(Object anObject) {
        Money myMoney = (Money)anObject;
        return theAmount == myMoney.theAmount && getClass().equals(myMoney.getClass());
    }

    public static Money dollar(int anAmount) {
        return new Dollar(anAmount);
    }

    public static Money franc(int anAmount) {
        return new Franc(anAmount);
    }
}
