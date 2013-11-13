package money;

/**
 * Created by vergiliu on 11/13/13.
 */
public class Bank {
    public Money reduce(Expression aSource, String toCurrency) {
        return aSource.reduce(toCurrency);
    }
}
