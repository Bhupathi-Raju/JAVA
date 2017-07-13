import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 */
public class FindFile {
    static int count = 0;

    /**
     * This class contains method visitFile which gets called when walkFileTree passes through a file. So for every
     * file it gets called and then we can check whether this path name is equal to the RegExp entered.
     */
    public static class Finder
            extends SimpleFileVisitor<Path> {
        private Pattern p;
        Finder(String pattern) {
            p = Pattern.compile(pattern);
        }

        /**
         * This method takes file name as a string and checks whether it matches with our specified RegExp pattern.
         * @param file takes file name as a string.
         * @return returns the absolute path of the file as a string
         */
     protected String checkFile(String file)
     {
         if (p.matcher(file).matches()) {
             count = 1;
             Path path = Paths.get(file);
             return (path.toFile().getAbsoluteFile()).toString();
         }
         return "";
     }

        /**
         * This method gets invoked for every file and call CheckFile method.
         * @param file It takes a path of file
         * @param attrs it takes the BasicFileAttributes, here these are not necessary.
         * @return returns FileVisitResult, here it returns FileVisitResult Continue
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file != null)
            {
               String fileName = file.getFileName().toString();
                String filePath = checkFile(fileName);
                if(filePath != "")
                    System.out.println(filePath);
            }
            return CONTINUE;
        }

        /**
         * This method gets invoked when a file visit is failed due to some reasons like no access to read.
         * @param file This takes path of the file
         * @param exc This takes the exception argument
         * @return returns SKIP_SUBTREE which skips the subtree of the file tree.
         */
        @Override
        public FileVisitResult visitFileFailed(Path file,
                                               IOException exc) {
            System.err.println("You don't have access to this file/directory: "+file.getFileName());
            return SKIP_SUBTREE;
        }
    }

    public static void main(String[] args)
            throws IOException {
        System.out.println("Enter the RegExp of the files you want to find or exit to terminate");
        Scanner scan = new Scanner(System.in);
        String regularExpression = scan.next();
        Path startingDir = Paths.get(System.getProperty("user.home"));
        try {
            while (!(regularExpression.equalsIgnoreCase("exit"))) {
                count = 0;
                Finder finder = new Finder(regularExpression);
                Files.walkFileTree(startingDir, finder);
                if (count == 0)
                    System.out.println("No file Found containing the regular expression");
                System.out.println("Enter the RegExp of the files you want to find or exit to terminate");
                regularExpression = scan.next();
            }
        } catch (PatternSyntaxException e)
        {
            System.out.println("Please enter a valid RegEx");
        }
        scan.close();
    }
}