/**
 * Created by zemoso on 4/7/17.
 */
public class ExceptionTest {
    /**
     * This is used to repeatedly take inputs from the main class and throw a null pointer exception when a =-1
     * @param a this is used to pass the value to Exception_Handling
     */
    public void tester(int a){
        try {
            if(a!=-1) {
                Exception_Handling.divide(a);
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Finally part always gets executed");
        }
    }
    public static void main(String args[])
    {
        ExceptionTest et=new ExceptionTest();
        et.tester(0);
        et.tester(1);
        et.tester(-3);
        et.tester(-1);
    }
}
