package money.src;
/**
 * Created by vergiliu on 11/11/13.
 */
public class Dollar extends Money {

    public Dollar(int anAmount) {
        super(anAmount);
    }

    public Dollar times(int aMultiplyAmount) {
        return new Dollar(theAmount * aMultiplyAmount);
    }

    public int getAmount() {
        return theAmount;
    }
}
