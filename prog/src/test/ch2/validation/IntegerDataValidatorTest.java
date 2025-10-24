package test.ch2.validation;

import ch2.exceptions.DataValidationException;
import ch2.validation.IntegerDataValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IntegerDataValidatorTest {

    private IntegerDataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new IntegerDataValidator();
    }

    @Test
    void testValidateAndParseWithSpaces() throws DataValidationException {
        String input = "1 2 3 4 5";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWithCommas() throws DataValidationException {
        String input = "1, 2, 3, 4, 5";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWithTire() throws DataValidationException {
        String input = "1 - 2 - 3 - 4 - 5";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateAndParseWithNegativeNumbers() throws DataValidationException {
        String input = "-1, -2, 3, -4, 5";
        List<Integer> expected = Arrays.asList(-1, -2, 3, -4, 5);

        List<Integer> actual = validator.validateAndParse(input);

        Assertions.assertEquals(expected, actual);
    }
}
