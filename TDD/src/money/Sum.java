/**
 * Created by vergiliu on 11/13/13.
 */
package money;

public class Sum implements Expression {
    Money theFirstElement;
    Money theSecondElement;

    public Sum(Money aFirstArgument, Money aSecondArgument) {
        this.theFirstElement = aFirstArgument;
        this.theSecondElement = aSecondArgument;
    }

    public Money reduce(Bank bank, String toCurrency) {
        int amount = theFirstElement.getAmount() + theSecondElement.getAmount();
        return new Money(amount, toCurrency);
    }
}
