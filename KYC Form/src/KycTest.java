
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by zemoso on 11/7/17.
 */
public class KycTest {
    public static void main(String args[]) throws ParseException {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\s");
        String signUpDate = scan.next();
        String currentDate = scan.next();
        KycForm kyc = new KycForm();
        System.out.println(kyc.getRange(signUpDate,currentDate));
    }
}
