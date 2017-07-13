import java.util.Scanner;

/**
 * Created by zemoso on 10/7/17.
 */
public class TestAllLettersChecker {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String:");
        String input = scan.nextLine();
        AllLettersChecker obj = new AllLettersChecker();
        System.out.println(obj.checkingAllLetters(input));
    }
}
