import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zemoso on 5/7/17.
 */
public class RegExp {
    static String pattern = "^\\p{Upper}.*\\.$"; //pattern to match the sentence starting with capital letter
    static Pattern p = Pattern.compile(pattern);

    /**
     * This method checks if the given string matches with our specified pattern and returns true or false.
     * @param input takes string read from a file as input
     * @return returns a Boolean value
     */
    public static Boolean checkString(String input)
    {
        Matcher m = p.matcher(input);
        return  m.find();
    }
    public static void main(String args[]) throws IOException {
        try {
            //Reading Input From a file input.txt.
            BufferedReader inputStream = new BufferedReader(new FileReader("input.txt"));
            String input;
            while ((input = inputStream.readLine()) != null) {
                System.out.println("Does the string " + input + " matches the given pattern?\n" + checkString(input));
            }
        }
        catch (Exception e)
        {
            System.out.println("file not found, please create a file named input.txt in the current working directory");
        }
    }
}
