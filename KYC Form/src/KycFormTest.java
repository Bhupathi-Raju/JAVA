
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class KycFormTest {
    private KycForm kyc = new KycForm();
    @Test
    public void Test1() throws ParseException
    {
        assertEquals("16-06-2017 27-06-2017",kyc.getRange("16-07-1998","27-06-2017"));
    }
    @Test
    public void Test2() throws ParseException
    {
        assertEquals("14-01-2017 15-03-2017",kyc.getRange("13-02-1998","27-06-2017"));
    }
    @Test
    public void Test3() throws ParseException
    {
        assertEquals("05-01-2017 06-03-2017",kyc.getRange("04-02-2016","04-04-2017"));
    }
    @Test
    public void Test4() throws ParseException
    {
        assertEquals("No range",kyc.getRange("04-05-2017","04-04-2017"));
    }
    @Test
    public void Test5() throws ParseException
    {
        assertEquals("05-03-2016 04-04-2016",kyc.getRange("04-04-2015","04-04-2016"));
    }
    @Test
    public void Test6() throws ParseException
    {
        assertEquals("05-03-2016 15-03-2016",kyc.getRange("04-04-2015","15-03-2016"));
    }
}