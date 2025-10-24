package ch2.factory;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.array.impl.ArrayStringEntity;
import ch1.builder.impl.IntegerArrayBuilder;
import ch1.builder.impl.StringArrayBuilder;
import ch2.exceptions.ArrayCreationException;
import ch2.exceptions.DataValidationException;
import ch2.exceptions.FileReadException;
import ch2.io.FileDataReader;
import ch2.validation.IntegerDataValidator;
import ch2.validation.StringDataValidator;

import java.util.List;

public class ArrayFactory {

    private final FileDataReader fileReader;
    private final IntegerDataValidator integerValidator;
    private final StringDataValidator stringValidator;

    public ArrayFactory() {
        this.fileReader = new FileDataReader();
        this.integerValidator = new IntegerDataValidator();
        this.stringValidator = new StringDataValidator();
    }

    public ArrayIntegerEntity createIntegerArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            List<String> dataLines = fileReader.readAllLines(filePath);
            List<Integer> integers = integerValidator.validateAndParse(dataLines.getFirst());
            return IntegerArrayBuilder.create(integers).build();
        } catch (FileReadException | DataValidationException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath);
        }
    }

    public ArrayStringEntity createStringArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            List<String> dataLines = fileReader.readAllLines(filePath);
            List<String> strings = stringValidator.validateAndParse(dataLines.getFirst());
            return StringArrayBuilder.create(strings).build();

        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива строк из файла: " + filePath);
        }
    }
}