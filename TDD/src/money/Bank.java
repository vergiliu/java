package money;

import java.util.Hashtable;

/**
 * Created by vergiliu on 11/13/13.
 */
public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression aSource, String toCurrency) {
        return aSource.reduce(this, toCurrency);
    }

    public void addRate(String fromCurrency, String toCurrency, int exchangeRate) {
        rates.put(new Pair(fromCurrency, toCurrency), new Integer(exchangeRate));
    }

    public int rate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) return 1; // same currency conversion
        Integer rate = (Integer) rates.get(new Pair(fromCurrency, toCurrency));
        return rate;
    }
}
