package test.java.parser;

import exception.DataValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.StringDataParser;

import java.util.Arrays;
import java.util.List;

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
