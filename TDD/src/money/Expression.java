/**
 * Created by vergiliu on 11/13/13.
 */

package money;

public interface Expression {
    Money reduce(Bank bank, String toCurrency);
    Expression plus(Expression anAmount);
    Expression times(int anAmount);
}
