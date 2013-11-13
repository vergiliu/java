/* Created by vergiliu on 11/13/13
 */
package money;
public class Pair {
    private String theFromCurency;
    private String theToCurrency;

    Pair(String aFromCurrency, String aToCurrency) {
        this.theFromCurency = aFromCurrency;
        this.theToCurrency = aToCurrency;
    }

    @Override
    public boolean equals(Object anObject) {
        Pair pair = (Pair) anObject;
        if (!theFromCurency.equals(pair.theFromCurency)) return false;
        if (!theToCurrency.equals(pair.theToCurrency)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 0; // terrible idea, but easy to implement :)
    }
}
