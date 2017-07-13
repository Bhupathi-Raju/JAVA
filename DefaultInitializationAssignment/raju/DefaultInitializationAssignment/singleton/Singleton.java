package raju.DefaultInitializationAssignment.singleton;

/**
 * Created by zemoso on 29/6/17.
 */
public class Singleton {
     private Singleton(){}
     private String s;
     public static Singleton getString(String str)
     {
         Singleton obj1= new Singleton();   // if object of the class is not created, we cannot access Non-static fields from
          //Static fields.  
         obj1.s = str;
         return obj1;
     }
     public void printStr()
     {
         System.out.println(s);
     }
}
