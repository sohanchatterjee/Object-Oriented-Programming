
//Sohan Chatterjee
//SSW 315 Lab 8 Rectangle Test
//October 21, 2022
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class CodeValidatorTest {
    @Test
    public void testCorrectFile() throws FileNotFoundException {
        assertTrue("There is an error in the file.", CodeValidator.checkFile(
                "C:/Users/sohan/Documents/Stevens/2022 Fall/SSW 315/Code Validator/resources/MaxCounter.java"));

    }

    @Test
    public void testIncorrectFile() throws FileNotFoundException {
        assertFalse("There are no errors in the file.", CodeValidator.checkFile(
                "C:/Users/sohan/Documents/Stevens/2022 Fall/SSW 315/Code Validator/resources/MaxCounterIncorrect.java"));

    }
}
