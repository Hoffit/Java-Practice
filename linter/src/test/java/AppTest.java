import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testjavaScriptLinterMethod() {
        //handle OS newline character differences in the expected system output
        //only supporting mac or os for now. Anything else may not pass tests
        String OS = System.getProperty("os.name");

        //Test the linter on a file that contains no errors.
        String expected = "";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Path aPath = Paths.get("resources/gates_no_errors.js");
        App.javaScriptLinter(aPath);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        //Test the linter on a file that contains one error.
        expected = (OS.contains("Windows")) ? ("Line 84: Missing semicolon\r\n") : ("Line 84: Missing semicolon\n");
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        aPath = Paths.get("resources/gates_one_errors.js");
        App.javaScriptLinter(aPath);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        //Test the linter on a file that contains several errors.
        if (OS.contains("Windows")) {
            expected = "Line 3: Missing semicolon\r\n" +
                    "Line 15: Missing semicolon\r\n" +
                    "Line 97: Missing semicolon\r\n";
        }
        else {
            expected = "Line 3: Missing semicolon\n" +
                "Line 15: Missing semicolon\n" +
                    "Line 97: Missing semicolon\n";
        }
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        aPath = Paths.get("resources/gates_several_errors.js");
        App.javaScriptLinter(aPath);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        //Test the linter on a file that contains many errors.
        if (OS.contains("Windows")) {
            expected = "Line 3: Missing semicolon\r\n" +
                    "Line 5: Missing semicolon\r\n" +
                    "Line 11: Missing semicolon\r\n" +
                    "Line 13: Missing semicolon\r\n" +
                    "Line 15: Missing semicolon\r\n" +
                    "Line 26: Missing semicolon\r\n" +
                    "Line 28: Missing semicolon\r\n" +
                    "Line 32: Missing semicolon\r\n" +
                    "Line 36: Missing semicolon\r\n" +
                    "Line 40: Missing semicolon\r\n" +
                    "Line 41: Missing semicolon\r\n" +
                    "Line 50: Missing semicolon\r\n" +
                    "Line 51: Missing semicolon\r\n" +
                    "Line 59: Missing semicolon\r\n" +
                    "Line 60: Missing semicolon\r\n" +
                    "Line 61: Missing semicolon\r\n" +
                    "Line 62: Missing semicolon\r\n" +
                    "Line 64: Missing semicolon\r\n" +
                    "Line 70: Missing semicolon\r\n" +
                    "Line 71: Missing semicolon\r\n" +
                    "Line 72: Missing semicolon\r\n" +
                    "Line 73: Missing semicolon\r\n" +
                    "Line 74: Missing semicolon\r\n" +
                    "Line 76: Missing semicolon\r\n" +
                    "Line 77: Missing semicolon\r\n" +
                    "Line 78: Missing semicolon\r\n" +
                    "Line 79: Missing semicolon\r\n" +
                    "Line 80: Missing semicolon\r\n" +
                    "Line 82: Missing semicolon\r\n" +
                    "Line 83: Missing semicolon\r\n" +
                    "Line 84: Missing semicolon\r\n" +
                    "Line 85: Missing semicolon\r\n" +
                    "Line 86: Missing semicolon\r\n" +
                    "Line 88: Missing semicolon\r\n" +
                    "Line 89: Missing semicolon\r\n" +
                    "Line 90: Missing semicolon\r\n" +
                    "Line 91: Missing semicolon\r\n" +
                    "Line 92: Missing semicolon\r\n" +
                    "Line 94: Missing semicolon\r\n" +
                    "Line 95: Missing semicolon\r\n" +
                    "Line 96: Missing semicolon\r\n" +
                    "Line 97: Missing semicolon\r\n" +
                    "Line 98: Missing semicolon\r\n" +
                    "Line 99: Missing semicolon\r\n" +
                    "Line 100: Missing semicolon\r\n" +
                    "Line 101: Missing semicolon\r\n";
        }
        else {
            expected = "Line 3: Missing semicolon\n" +
                    "Line 5: Missing semicolon\n" +
                    "Line 11: Missing semicolon\n" +
                    "Line 13: Missing semicolon\n" +
                    "Line 15: Missing semicolon\n" +
                    "Line 26: Missing semicolon\n" +
                    "Line 28: Missing semicolon\n" +
                    "Line 32: Missing semicolon\n" +
                    "Line 36: Missing semicolon\n" +
                    "Line 40: Missing semicolon\n" +
                    "Line 41: Missing semicolon\n" +
                    "Line 50: Missing semicolon\n" +
                    "Line 51: Missing semicolon\n" +
                    "Line 59: Missing semicolon\n" +
                    "Line 60: Missing semicolon\n" +
                    "Line 61: Missing semicolon\n" +
                    "Line 62: Missing semicolon\n" +
                    "Line 64: Missing semicolon\n" +
                    "Line 70: Missing semicolon\n" +
                    "Line 71: Missing semicolon\n" +
                    "Line 72: Missing semicolon\n" +
                    "Line 73: Missing semicolon\n" +
                    "Line 74: Missing semicolon\n" +
                    "Line 76: Missing semicolon\n" +
                    "Line 77: Missing semicolon\n" +
                    "Line 78: Missing semicolon\n" +
                    "Line 79: Missing semicolon\n" +
                    "Line 80: Missing semicolon\n" +
                    "Line 82: Missing semicolon\n" +
                    "Line 83: Missing semicolon\n" +
                    "Line 84: Missing semicolon\n" +
                    "Line 85: Missing semicolon\n" +
                    "Line 86: Missing semicolon\n" +
                    "Line 88: Missing semicolon\n" +
                    "Line 89: Missing semicolon\n" +
                    "Line 90: Missing semicolon\n" +
                    "Line 91: Missing semicolon\n" +
                    "Line 92: Missing semicolon\n" +
                    "Line 94: Missing semicolon\n" +
                    "Line 95: Missing semicolon\n" +
                    "Line 96: Missing semicolon\n" +
                    "Line 97: Missing semicolon\n" +
                    "Line 98: Missing semicolon\n" +
                    "Line 99: Missing semicolon\n" +
                    "Line 100: Missing semicolon\n" +
                    "Line 101: Missing semicolon\n";
        }
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        aPath = Paths.get("resources/gates_many_errors.js");
        App.javaScriptLinter(aPath);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        //Test the linter on an empty file.
        expected = "";
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        aPath = Paths.get("resources/empty.js");
        App.javaScriptLinter(aPath);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));
    }
}
