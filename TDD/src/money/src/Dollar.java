/**
 * Created by vergiliu on 11/11/13.
 */
package money.src;

public class Dollar extends Money {
    public Dollar(int anAmount, String aCurrency) {
        super(anAmount, aCurrency);
    }

    public int getAmount() {
        return theAmount;
    }
}
