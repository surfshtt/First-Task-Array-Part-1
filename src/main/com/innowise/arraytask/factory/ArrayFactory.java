package main.com.innowise.arraytask.factory;


import main.com.innowise.arraytask.builder.ArrayIntegerBuilder;
import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.entity.ArrayStringEntity;
import main.com.innowise.arraytask.builder.ArrayStringBuilder;
import main.com.innowise.arraytask.exception.ArrayCreationException;
import main.com.innowise.arraytask.exception.DataValidationException;
import main.com.innowise.arraytask.exception.FileReadException;
import main.com.innowise.arraytask.io.FileDataReader;
import main.com.innowise.arraytask.parser.IntegerDataParser;
import main.com.innowise.arraytask.parser.StringDataParser;

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