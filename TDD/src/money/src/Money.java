/**
 * Created by vergiliu on 11/12/13.
 */

package money.src;

public class Money {
    protected int theAmount;

    public Money(int anAmount) {
        theAmount = anAmount;
    }

    public boolean equals(Object anObject) {
        Money myMoney = (Money)anObject;
        return theAmount == myMoney.theAmount;
    }
}
