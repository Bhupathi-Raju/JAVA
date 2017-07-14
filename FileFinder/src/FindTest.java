

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.nio.file.Path;
import java.util.regex.PatternSyntaxException;

/**
 * Created by zemoso on 13/7/17.
 */
public class FindTest {
    @Test(expected = PatternSyntaxException.class) //this fails when the mentioned expectation is not thrown
    public void testingIfExceptionIsThrownWhenUserEntersIncorrectRegExp() {
        String RegExp = "*.txt";  //This is a wrong Regexp.So, it should throw PatternSyntaxException.
        FindFile.Finder f = new FindFile.Finder(RegExp);
    }
   @Test
     public void testingIfTheDesiredFileIsBeingFound()
    {
        File testFile =new File("testfile.txt");  //creating a new file in this directory
        String RegExp = "testfile.txt";      //giving a RegExp of the created file
        FindFile.Finder f = new FindFile.Finder(RegExp);
        Path p = testFile.toPath();
        Assert.assertEquals(testFile.getAbsolutePath(),f.checkFile(p));
    }
}