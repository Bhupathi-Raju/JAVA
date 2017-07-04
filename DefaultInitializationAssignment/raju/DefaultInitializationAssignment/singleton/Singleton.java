package raju.DefaultInitializationAssignment.singleton;

/**
 * Created by zemoso on 29/6/17.
 */
public class Singleton {
     private String s;
     public static Singleton getstring(String str)
     {
         Singleton obj1= new Singleton();
         obj1.s = str;
         return obj1;
     }
     public void printstr()
     {
         System.out.println(s);
     }
}
