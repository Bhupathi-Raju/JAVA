/**
 * Created by zemoso on 3/7/17.
 */
class Cycle {
     public Cycle()
     {
         System.out.println("Hi, I am cycle");
     }
     public void balance()
     {
         System.out.println("Balancing cycle");
     }
}
class Unicycle extends Cycle
{
    public Unicycle()
    {
        System.out.println("I have one wheel");
    }
    public void balance()
    {
        System.out.println("Please help me balance");
    }
}
class Bicycle extends Cycle
{
    public Bicycle()
    {
        System.out.println("I have two wheels");
    }
    public void balance()
    {
        System.out.println("I need a stand to balance");
    }
}
class Tricycle extends Cycle
{
    public Tricycle()
    {
        System.out.println("I have three wheels");
    }
}
class Demo{
      public static void main(String args[])
      {
          Unicycle u = new Unicycle();
          Bicycle  b = new Bicycle();
          Tricycle t = new Tricycle();
          Cycle c[] = {u,b,t};  // upcasting
          System.out.println("\n After Upcasting: \n");
          for(Cycle i : c)
          {
              i.balance();
          }
          // Down-casting
          System.out.println("\n After Downcasting: \n");
           u = (Unicycle)c[0];
           b = (Bicycle) c[1];
           t= (Tricycle) c[2];
          u.balance();
          b.balance();
          t.balance();
      }
}