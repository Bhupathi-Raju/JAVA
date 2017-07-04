
/**
 * Created by zemoso on 4/7/17.
 */
public class Exception_Handling {
       public static void divide (int a) throws Divideby1,DividebyZeroException,DividebyNeagtive
        {
            int x = 10;
            if(a==0)
                throw new DividebyZeroException();
            else if(a<0)
                throw new DividebyNeagtive();
            else if(a==1)
                throw new Divideby1();
        }
    }
