package dollar.src;

/**
 * Created by vergiliu on 11/11/13.
 */

public class Franc {
    private int theAmount;

    public Franc(int anAmount) {
        theAmount = anAmount;
    }

    public Franc times(int aMultiplyAmount) {
        return new Franc(theAmount * aMultiplyAmount);
    }

    public int getAmount() {
        return theAmount;
    }

    public boolean equals(Object anObject) {
        return theAmount == ((Franc)anObject).getAmount();
    }
}
