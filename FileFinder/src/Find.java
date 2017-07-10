import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import java.util.*;
import java.util.regex.Pattern;

public class Find {
    public static class Finder
            extends SimpleFileVisitor<Path> {
        private Pattern p;

        Finder(String pattern) {
            p = Pattern.compile(pattern);

        }

        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attrs) {

            if (file != null) {
                if (p.matcher(file.toString()).matches())
                    System.out.println(file.toFile().getAbsoluteFile());
            }
            return CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                                                 BasicFileAttributes attrs) {
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file,
                                               IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
    }

    public static void main(String[] args)
            throws IOException {
        System.out.println("Enter the RegExp of the files you want to find or exit to terminate");
        Scanner scan = new Scanner(System.in);
        String regularExpression = scan.next();
        Path startingDir = Paths.get("/home/");
        while (!(regularExpression.equalsIgnoreCase("exit"))) {
            Finder finder = new Finder(regularExpression);
            Files.walkFileTree(startingDir, finder);
            System.out.println("Enter the RegExp of the files you want to find or exit to terminate");
            regularExpression = scan.next();
        }
        scan.close();
    }
}