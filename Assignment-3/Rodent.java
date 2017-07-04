/**
 * Created by zemoso on 3/7/17.
 */
abstract class Rodent {
    public Rodent()
    {
         System.out.println("The things below u see belong to me The Rodent");
    }
    public abstract void eat();
    public abstract void run();
}

 class Mouse extends Rodent{
    Mouse()
    {
        System.out.println("This class explains how Mouse behaves");
    }
    public void eat()
    {
        System.out.println("Mouse is eating");
    }
    public void run()
    {
        System.out.println("Mouse is running");
    }
}
class Gerbil extends Rodent{
    Gerbil()
    {
        System.out.println("This class explains how Gerbil behaves");
    }
    public void eat()
    {
        System.out.println("Gerbil is eating");
    }
    public void run()
    {
        System.out.println("Gerbil is running");
    }
}
class Hamster extends Rodent{
    Hamster()
    {
        System.out.println("This class explains how Hamster behaves");
    }
    public void eat()
    {
        System.out.println("Hamster is eating");
    }
    public void run()
    {
        System.out.println("Hamster is running");
    }
}
class Test{
    public static void main(String args[])
    {
       Rodent rod[] = {new Mouse(),new Hamster(),new Gerbil()};
       rod[0].eat();
       rod[0].run();
       rod[1].eat();
       rod[1].run();
       rod[2].eat();
       rod[2].run();
    }
}
