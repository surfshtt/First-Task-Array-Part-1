package test.innowise.arraytask.parser;

import by.innowise.arraytask.exception.DataValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import by.innowise.arraytask.parser.StringDataParser;

public class StringDataValidatorTest {

    private StringDataParser validator;

    @BeforeEach
    void setUp() {
        validator = new StringDataParser();
    }

    @Test
    void testValidateAndParseWithSpaces() throws DataValidationException {
        String input = "hello world java programming";
        String[] expected = {"hello", "world", "java", "programming"};

        String[]  actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWith() throws DataValidationException {
        String input = "hello, world, java, programming";
        String[]  expected = {"hello", "world", "java", "programming"};

        String[] actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWithTire() throws DataValidationException {
        String input = "hello - world - java - programming";
        String[]  expected = {"hello", "world", "java", "programming"};

        String[]  actual = validator.parse(input);

        Assertions.assertEquals(expected, actual);
    }
}
