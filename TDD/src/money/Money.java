/**
 * Created by vergiliu on 11/12/13.
 */
package money;

public class Money implements Expression {
    private String theCurrency;
    private int theAmount;

    public int getAmount() {
        return theAmount;
    }

    public Money(int anAmount, String aCurrency) {
        theAmount = anAmount;
        theCurrency = aCurrency;;
    }

    @Override
    public boolean equals(Object anObject) {
        Money myMoney = (Money)anObject;
        return theAmount == myMoney.theAmount && theCurrency.equals(myMoney.getCurrency());
    }

    public static Money dollar(int anAmount) {
        return new Money(anAmount, "USD");
    }

    public static Money franc(int anAmount) {
        return new Money(anAmount, "CHF");
    }

    public String getCurrency() {
        return theCurrency;
    }

    public Money times(int aMultiplier) {
        return new Money(theAmount * aMultiplier, theCurrency);
    }

    @Override
    public String toString() {
        return "Money{theCurrency=" + theCurrency + ", theAmount=" + theAmount + "}";
    }

    public Expression plus(Money aSecondArgument) {
        return new Sum(this, aSecondArgument);
    }

    public Money reduce(String toCurrency) {
        return this;
    }
}