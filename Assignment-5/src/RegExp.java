import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zemoso on 5/7/17.
 */
public class RegExp{
    public static void main(String args[])
    {
        String input1 = "How are you?";
        String input2 = "I am fine.";
        String pattern  = "^\\p{Upper}.*\\.$"; //pattern to match the sentence starting with capital letter
        // and ending with a period.
        Pattern p =Pattern.compile(pattern);
        Matcher m = p.matcher(input1);
        Matcher m1 = p.matcher(input2);
        System.out.println("Does the string "+input1+" matches the given pattern?\n"+m.find());
        System.out.println("Does the string "+input2+" matches the given pattern?\n"+m1.find());
    }
}
