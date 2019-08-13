package linter;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testLinterMessage_NoErrors() {
        String expected = "The file has no missing semicolons";
        String response = App.linterMessage("no-errors.js");

        assertEquals("NoErrors: No error messages should be produced", expected, response);
    }

    @Test
    public void testLinterMessage_GatesJS() {
        String expected = "Line 3: Missing semicolon\n" +
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
                              "Line 101: Missing semicolon\n"
            ;

        String response = App.linterMessage("gates.js");

        assertEquals("GatesJS: Incorrect error message", expected, response);
    }

    @Test
    public void testLinterMessage_EmptyJS() {
        String expected = "The file has no missing semicolons";
        String response = App.linterMessage("empty.js");

        assertEquals("EmptyJS: no errors, empty file", expected, response);
    }
}
