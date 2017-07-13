
/**
 * Created by zemoso on 4/7/17.
 */
public class Exception_Handling {
    /**
     * @param a a is used to throw exceptions here
     * @throws DividedByOne this exception is thrown when a =1
     * @throws DividedByZeroException this exception is thrown when a =0
     * @throws DividedByNegative this exception is thrown when a < 0
     */
        static void divide (int a) throws DividedByOne,DividedByZeroException,DividedByNegative
        {
            if(a==0)
                throw new DividedByZeroException();
           else if(a<0)
                throw new DividedByNegative();
            else if(a==1)
                throw new DividedByOne();
        }
    }
