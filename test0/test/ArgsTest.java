import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;

import static junit.framework.Assert.*;

/**
 * boolean - 1
 * integer - d*
 * string  - p#
 */
public class ArgsTest {

    @Test
    public void createEmptySchema() throws ParseException {
        String []input = {};
        Args a = new Args("", input);
        assertTrue(a.isValid());
    }

    @Ignore
    @Test
    public void createStringSchema() throws ParseException {
        String []input = {"d1", "x2"};
        Args a = new Args("d#,x#", input);
        assertTrue(a.isValid());
        assertEquals(2, a.getInt('x'));
        assertEquals(1, a.getInt('d'));
    }

    @Test
    public void createBooleanFalseSchema() throws ParseException {
        String []input = {"afalse"};
        Args a = new Args("a", input);
        assertFalse(a.getBoolean('a'));
    }

    @Test
    public void createBooleanTrueSchema() throws ParseException {
        String []input = {"atrue"};
        Args a = new Args("a", input);
        assertTrue(a.getBoolean('a'));
    }
}
