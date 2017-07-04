package cycle;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by zemoso on 3/7/17.
 */
interface Cycle {
    void balance();
}
interface Type
{
    Cycle gettype();
}
class Bicycle implements Cycle
{
    public void balance()
    {
        System.out.println("I need a stand to balance");
    }

}
class Unicycle implements Cycle
{
    public void balance()
    {
        System.out.println("I dont know how to balance");
    }
}
class Tricycle implements Cycle
{
    public void balance()
    {
        System.out.println("I can balance myself");
    }
}
class Bicyclefactory implements Type{
    public Cycle gettype() {
        return new Bicycle();
    }
   }
   class Unicyclefactory implements Type
   {
       public Cycle gettype()
       {
           return new Unicycle();
       }
   }
   class Tricyclefactory implements Type
   {
       public Cycle gettype()
       {
           return new Tricycle();
       }
   }

   public class Cyclebalance
   {
      public static void get(Type g)
      {
          Cycle s = g.gettype();
          s.balance();
      }
       public static void main(String args[])
       {
           get(new Bicyclefactory());
           get(new Unicyclefactory());
           get(new Tricyclefactory());
       }
   }