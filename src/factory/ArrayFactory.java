package factory;


import builder.ArrayIntegerBuilder;
import entity.ArrayIntegerEntity;
import entity.ArrayStringEntity;
import builder.ArrayIntegerBuilder;
import builder.ArrayStringBuilder;
import exception.ArrayCreationException;
import exception.DataValidationException;
import exception.FileReadException;
import io.FileDataReader;
import parser.IntegerDataParser;
import parser.StringDataParser;

import java.util.List;

public class ArrayFactory {

    private final FileDataReader fileReader;
    private final IntegerDataParser integerDataParser;
    private final StringDataParser stringDataParser;
    private final ArrayIntegerBuilder arrayIntegerBuilder;
    private final ArrayStringBuilder arrayStringBuilder;

    public ArrayFactory() {
        this.fileReader = new FileDataReader();
        integerDataParser = new IntegerDataParser();
        stringDataParser = new StringDataParser();
        arrayIntegerBuilder = new ArrayIntegerBuilder();
        arrayStringBuilder = new ArrayStringBuilder();
    }

    public ArrayIntegerEntity createIntegerArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            List<String> dataLines = fileReader.readAllLines(filePath);
            int[] integers = integerDataParser.parse(dataLines.getFirst());
            return arrayIntegerBuilder.create(integers);
        } catch (FileReadException | DataValidationException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath);
        }
    }

    public ArrayStringEntity createStringArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            List<String> dataLines = fileReader.readAllLines(filePath);
            String[] strings = stringDataParser.parse(dataLines.getFirst());
            return arrayStringBuilder.create(strings);

        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива строк из файла: " + filePath);
        }
    }
}