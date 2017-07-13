package raju.DefaultInitializationAssignment.singleton;

/**
 * Created by zemoso on 29/6/17.
 */
public class Singleton {
     private Singleton(){}  // as a singleton class should have only one object we make it's constructor private
     private static Singleton obj1= new Singleton(); // and its object static
     private String s;
     public static Singleton getString(String str)
     {
         // if object of the class is not created, we cannot access Non-static fields from
         //Static fields.
         obj1.s = str;
         return obj1;
     }
     public void printStr()
     {
         System.out.println(s);
     }
}
