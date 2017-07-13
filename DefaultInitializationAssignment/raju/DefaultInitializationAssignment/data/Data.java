package raju.DefaultInitializationAssignment.data;

/**
 * Created by zemoso on 29/6/17.
 */
public class Data {
    private int a;
    private char b;
    public void print()
    {
        System.out.println(a);
        System.out.println(b);
    }
    public void print2()
    {
         int c,d;
         /*System.out.println(c);    //This code doesn't execute because fields c & d were not initialised
         System.out.println(d);*/     // Fields inside a class gets initialised automatically but not fields
                                       // fields in the methods.
    }
}
