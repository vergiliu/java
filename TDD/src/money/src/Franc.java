package money.src;

/**
 * Created by vergiliu on 11/11/13.
 */

public class Franc extends Money {
    public Franc(int anAmount) {
        super(anAmount);
    }

    public Franc times(int aMultiplyAmount) {
        return new Franc(theAmount * aMultiplyAmount);
    }

    public int getAmount() {
        return theAmount;
    }
}
