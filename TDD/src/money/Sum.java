/**
 * Created by vergiliu on 11/13/13.
 */
package money;

public class Sum implements Expression {
    Expression theFirstElement;
    Expression theSecondElement;

    public Sum(Expression aFirstArgument, Expression aSecondArgument) {
        this.theFirstElement = aFirstArgument;
        this.theSecondElement = aSecondArgument;
    }

    @Override
    public Expression plus(Expression aSecondArgument){
        return new Sum(this, aSecondArgument);
    }

    @Override
    public Expression times(int anAmount) {
        return new Sum(theFirstElement.times(anAmount), theSecondElement.times(anAmount));
    }

    public Money reduce(Bank bank, String toCurrency) {
        int amount = theFirstElement.reduce(bank, toCurrency).getAmount() +
                theSecondElement.reduce(bank, toCurrency).getAmount();
        return new Money(amount, toCurrency);
    }
}
