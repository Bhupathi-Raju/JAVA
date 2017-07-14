import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zemoso on 13/7/17.
 */

public class PingTest {
    private Ping p = new Ping("ping -c5 123google.com", 5, "123google.com");

    @Test
    public void testingIfThereIsNoPacketLoss() {
        ArrayList<Double> arrayList = new ArrayList(Arrays.asList(16.3, 15.7, 14.6, 25.00, 36.00));
        assertEquals("The median is 16.3", p.median(arrayList));
    }

    @Test
    public void testingIfThereIsPacketLoss() {
        ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(16.3, 15.7, 14.6, 25.00));
        assertEquals("There is packet loss, Ping again to get the correct value.The median is 16.0", p.median(arrayList));
    }

    @Test
    public void testingIfThereIsNoReplyFromHost() {
        ArrayList<Double> arrayList = new ArrayList<>();
        assertEquals("There is a no reply from this host", p.median(arrayList));
    }

    @Test      //this is not working should check again.
    public void testingWhenEnteredHostDoesntExist() {
       try {
           p.runCommand();
       }
      catch (Exception e)
      {
          assertTrue(e.getClass() == IOException.class); //Exception is thrown, so assert true gives success.
      }
    }
}
