package raju.DefaultInitializationAssignment.main;

import raju.DefaultInitializationAssignment.data.*;
import raju.DefaultInitializationAssignment.singleton.*;

import static raju.DefaultInitializationAssignment.singleton.Singleton.*;

/**
 * Created by zemoso on 29/6/17.
 */
public class Main {
    public static void main(String[] args)
    {
        Data obj2 = new Data();
        obj2.print();
        obj2.print2();
        Singleton obj3 = getString("l");
        obj3.printStr();
    }
}
