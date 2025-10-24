package test.ch2.validation;

import ch2.exception.DataValidationException;
import ch2.validation.StringDataValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringDataValidatorTest {

    private StringDataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new StringDataValidator();
    }

    @Test
    void testValidateAndParseWithSpaces() throws DataValidationException {
        String input = "hello world java programming";
        List<String> expected = Arrays.asList("hello", "world", "java", "programming");

        List<String> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWith() throws DataValidationException {
        String input = "hello, world, java, programming";
        List<String> expected = Arrays.asList("hello", "world", "java", "programming");

        List<String> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWithTire() throws DataValidationException {
        String input = "hello - world - java - programming";
        List<String> expected = Arrays.asList("hello", "world", "java", "programming");

        List<String> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }
}
