import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zemoso on 7/7/17.
 */
public class WordCount {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> m = new HashMap<>();
        BufferedReader inputStream;
       try {
            String inputFileName = args[0];  //This takes input from the command line arguments as the input file name
            String outputFileName = args[1];  // taking input form the command line arguments as output file name
            PrintWriter writer = new PrintWriter(outputFileName);
            File a = new File(inputFileName);
            inputStream = new BufferedReader(new FileReader(a));
            int c;
            // Mapping Characters with keys,Here keys are the values how many times they are repeated.
            while ((c = inputStream.read()) != -1) {
                int value;
                char ch = (char) c;
                if (m.containsKey(ch)) {
                    value = m.get(ch) + 1;
                } else value = 1;
                m.put(ch, value);
            }
            //writing out the output to the file "output.txt" by iterating through the entire map
            for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                char c1 = entry.getKey();
                int d = entry.getValue();
                if (c1 == '\n') writer.write("New Line:");
                else writer.write(c1);
                writer.write(" " + "=");
                writer.println(String.valueOf(d));
            }
               writer.close();
               inputStream.close();
        }
        catch (Exception e)
        {
            System.out.println("Entered file doesn't exist or u don't have access to it");
        }
    }
}
