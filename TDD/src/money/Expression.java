/**
 * Created by vergiliu on 11/13/13.
 */

package money;

public interface Expression {
    Money reduce(String toCurrency);
}
