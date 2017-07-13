
import java.util.Scanner;

/**
 * Created by zemoso on 11/7/17.
 */
public class KycTest {
    public static void main(String args[]) throws Exception{
        try {
            Scanner scan = new Scanner(System.in);
            scan.useDelimiter("\\s");
            String signUpDate = scan.next();
            String currentDate = scan.next();
            if (signUpDate == null || currentDate == null) throw new Exception();
            KycForm kyc = new KycForm();
            System.out.println(kyc.getRange(signUpDate, currentDate));
        }
        catch (Exception e)
        {
            System.out.println("Please enter signUp date and current date in dd/mm/YYYY format");
        }
    }
}
