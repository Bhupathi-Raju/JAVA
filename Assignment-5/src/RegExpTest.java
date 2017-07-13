import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 13/7/17.
 */
public class RegExpTest {
    @Test
    public void testingWhenTrue() throws Exception {
        String input = "I am fine.";

        assertEquals(true,RegExp.checkString(input));
    }
    @Test
    public void testingWhenFalse() throws Exception{
        String input = "How are You?";
        assertEquals(false,RegExp.checkString(input));
    }
    @Test
    public void testingWhenStringStartsWithSpace() throws Exception
    {
        String input = " How are you.";
        assertEquals(false,RegExp.checkString(input));
    }
    @Test
    public void testingWhenStringStartsWithLowerCaseLetter() throws Exception
    {
        String input = "i am fine.";
        assertEquals(false,RegExp.checkString(input));
    }
    @Test(expected = NullPointerException.class)
    public void testingWhenStringEqualsNull() throws Exception
    {
        String input = null;
        assertEquals(false,RegExp.checkString(input));
    }
}