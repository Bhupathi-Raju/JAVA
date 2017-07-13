package raju.DefaultInitializationAssignment.data;

/**
 * Created by zemoso on 29/6/17.
 */
public class Data {
    private int a;  // This is a class field which gets initialised automatically
    private char b; // This is a class field which gets initialised automatically
    public void print()
    {
        System.out.println(a);
        System.out.println(b);
    }
    public void print2()
    {
         int c,d;  // These are method fields which does't get initialised automatically
         /*System.out.println(c);    //This code doesn't execute because fields c & d were not initialised
         System.out.println(d);*/     // Fields inside a class gets initialised automatically but not fields
                                       // fields in the methods.
    }
}
