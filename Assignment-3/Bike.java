/**
 * Created by zemoso on 3/7/17.
 */

interface Wheels
        {
            void getwheelsno();
            void checkair();
        }
interface Engine
    {
      void getenginesize();
      void startengine();
    }
interface Fuel
{
     void getfueltype();
     void getfuelamount();
}
interface Vehicle extends Wheels,Engine,Fuel
{
    void getvehicleno();
}
class Gears
{
    public void getgearsno()
    {
        System.out.println("The no.of gears are 4");
    }
}
public class Bike extends Gears implements Vehicle {
    public void getwheelsno() {
        System.out.println("2 Wheels");
    }

    public void checkair() {
        System.out.println("air is filled");
    }

    public void getenginesize() {
        System.out.println("100cc engine");
    }

    public void startengine() {
        System.out.println("engine is started");
    }

    public void getfueltype()
    {
        System.out.println("The fuel used is petrol");
    }
    public void getfuelamount()
    {
        System.out.println("6 liters of petrol");
    }
    public void getvehicleno() {
        System.out.println("Regno:178");
    }
    public void wheeldetails(Wheels w)
    {
        w.getwheelsno();
    }
    public void enginedetails(Engine e)
    {
        e.getenginesize();
    }
    public void fueldetails(Fuel f)
    {
        f.getfueltype();
    }
    public void vehiceldetails(Vehicle v)
    {
        v.getvehicleno();
    }
    public static void main(String args[])
    {
        Bike b = new Bike();
        b.wheeldetails(b);
        b.enginedetails(b);
        b.fueldetails(b);
        b.vehiceldetails(b);
    }
}
