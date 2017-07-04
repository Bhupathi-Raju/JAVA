/**
 * Created by zemoso on 3/7/17.
 */
class Outerclass {
     class In1
    {
        public In1(String s)
        {
            System.out.println("This is called with object of "+s);
        }
    }
}
class Outerclas2{
    class In2 extends Outerclass.In1
    {
        public In2(String s) {
            new Outerclass().super(s);
        }
    }
}

public class Run
{
    public static void main(String args[])
    {
        Outerclas2 o2 =new Outerclas2();
        Outerclas2.In2 in2 = o2.new In2("Innerclass 2");
        Outerclass o1 = new Outerclass();
        Outerclass.In1 in1 = o1.new In1("Innerclasss 1");
    }
}
