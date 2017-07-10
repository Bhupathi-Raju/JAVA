import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zemoso on 7/7/17.
 */
///This is to be run from command line
public class WordCount {
    public static void main(String[] args) throws IOException{
        Map<Character, Integer> m = new HashMap<>();
        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;
       try {
           Console q = System.console();
           if (q == null) {
               System.err.println("No console.");
               System.exit(0);
           }
           String inputFileName = q.readLine("Enter the  input file name: ");
           String outputFileName = q.readLine("Enter the output file name: ");
           File a = new File(inputFileName);
           File b = new File(outputFileName);
           inputStream = new BufferedReader(new FileReader(a));
           outputStream = new BufferedWriter(new FileWriter(b));
           int c;
           while((c=inputStream.read())!=-1)
           {
               int value;
               char ch = (char)c;
                if(m.containsKey(ch))
                {
                     value = m.get(ch)+1;
                }
                else
                     value=1;
                m.put(ch,value);
           }
           for(Map.Entry<Character,Integer> entry : m.entrySet())
           {
               char c1 = entry.getKey();
               int d = entry.getValue();
               System.out.println(d);
               if(c1 =='\n')
                   outputStream.write("New Line:");
               else
               outputStream.write(c1 );
               outputStream.write(" "+"=");
               outputStream.write(String.valueOf(d));
               outputStream.newLine();
           }
       }
       finally{
            if(inputStream!=null)
                inputStream.close();
            if(outputStream!=null)
                outputStream.close();
       }
    }
}
