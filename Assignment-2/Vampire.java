import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zemoso on 28/6/17.
 */
public class Vampire {
    public static void main (String args[])
    {
         int count =0;    // declaring count to know how many numbers have been found.
         int itr = 1,m=0; //used to increase the range of our search.
         ArrayList<Integer> c = new ArrayList<Integer>();  // to store the found vampire numbers.

         // Function to find the vampire numbers

        while(count<100)
        {
             for (int i = (int)(Math.pow(10, itr)); i < (int)Math.pow(10, itr + 1); i++)
             {
                 for (int j = i; j < (int)Math.pow(10, itr + 1); j++)
                 {
                     if(i%10==0 && j%10==0)  //To eliminate the trailing zeros.
                         continue;
                     int pro = i * j;
                     String k = Integer.toString(i) + Integer.toString(j);
                     String l = Integer.toString(pro);
                     char[] a = k.toCharArray();
                     char[] b = l.toCharArray();
                     Arrays.sort(a);
                     Arrays.sort(b);
                     if (Arrays.equals(a, b))
                     {
                         if(!c.contains(pro)) // to eliminate the repeated ones.
                         {
                             c.add(pro);
                             count++;
                         }
                     }
                 }
             }
             itr++;
                  }
        Collections.sort(c); // sorting the received array
        System.out.println(count);
        for(int i=0;i<100;i++)   //
            System.out.println(c.get(i)); //printing out the first 100 vampire numbers.
    }

}
