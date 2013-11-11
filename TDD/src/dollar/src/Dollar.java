package dollar.src;
/**
 * Created by vergiliu on 11/11/13.
 */
public class Dollar {
    private int theAmount;

    public Dollar(int anAmount) {
        theAmount = anAmount;
    }

    public Dollar times(int aMultiplyAmount) {
        return new Dollar(theAmount * aMultiplyAmount);
    }

    public int getAmount() {
        return theAmount;
    }

    public boolean equals(Object anObject) {
        return theAmount == ((Dollar)anObject).getAmount();
    }
}
