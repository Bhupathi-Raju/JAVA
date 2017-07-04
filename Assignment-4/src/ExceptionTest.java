/**
 * Created by zemoso on 4/7/17.
 */
public class ExceptionTest {
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
