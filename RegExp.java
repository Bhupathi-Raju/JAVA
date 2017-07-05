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
        String pattern  = "^\\p{Upper}*$\\p{.}";
        Pattern p =Pattern.compile(pattern);
        Matcher m = p.matcher(input1);
        Matcher m1 = p.matcher(input2);
        System.out.println(m.find());
        System.out.println(m.find());
    }
}
