import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zemoso on 13/7/17.
 */

public class AllLettersCheckerTest{
    @Test
    public void testingWhenStringContainsAllTypeOfCharactersAndAllLettersFromAToZ() {
        String input = "qwewrtyuiopasdfghjklzxcvbnm qwedsvfgesbdzawgerdbzvfsefhabccxb 1236854 hxbvuyf17ufe87u1bw";
        AllLettersChecker obj = new AllLettersChecker();
        assertEquals("Contain all letters",obj.checkingAllLetters(input));
    }
    @Test
    public void testingWhenStringSizeIsLessThan26()
    {
        String input = "akgsduqhwuifcj"; //it contains less that 26 letters
        AllLettersChecker obj = new AllLettersChecker();
        assertEquals("Doesn't Contain all letters",obj.checkingAllLetters(input));
    }
    @Test
    public void testingWhenStringDoesntContainAllLettersFromAToZ()
    {
        String input = "asdukashdgikhuvgujydaskjdgasydgyusagdausdygsyadgusagduyasgdasdgakwqgycb"; //it contains more
        // than 26 letters but not all.
        AllLettersChecker obj = new AllLettersChecker();
        assertEquals("Doesn't Contain all letters",obj.checkingAllLetters(input));

    }

}