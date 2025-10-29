package test.com.innowise.arraytask.parser;


import main.com.innowise.arraytask.exception.DataValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.com.innowise.arraytask.parser.IntegerDataParser;

public class IntegerDataValidatorTest {

    private IntegerDataParser validator;

    @BeforeEach
    void setUp() {
        validator = new IntegerDataParser();
    }

    @Test
    void testParseWithSpaces() throws DataValidationException {
        String input = "1 2 3 4 5";
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testParseWithCommas() throws DataValidationException {
        String input = "1, 2, 3, 4, 5";
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testParseWithTire() throws DataValidationException {
        String input = "1 - 2 - 3 - 4 - 5";
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testVParseWithNegativeNumbers() throws DataValidationException {
        String input = "-1, -2, 3, -4, 5";
        int[] expected = {-1, -2, 3, -4, 5};

        int[] actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }
}
