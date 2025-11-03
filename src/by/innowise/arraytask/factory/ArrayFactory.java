package by.innowise.arraytask.factory;


import by.innowise.arraytask.builder.ArrayIntegerBuilder;
import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.builder.ArrayStringBuilder;
import by.innowise.arraytask.exception.ArrayCreationException;
import by.innowise.arraytask.exception.DataValidationException;
import by.innowise.arraytask.exception.FileReadException;
import by.innowise.arraytask.io.impl.FileDataReaderImpl;
import by.innowise.arraytask.parser.IntegerDataParser;
import by.innowise.arraytask.parser.StringDataParser;

import java.util.List;

public class ArrayFactory {

    private final FileDataReaderImpl fileReader;
    private final IntegerDataParser integerDataParser;
    private final StringDataParser stringDataParser;
    private final ArrayIntegerBuilder arrayIntegerBuilder;
    private final ArrayStringBuilder arrayStringBuilder;

    public ArrayFactory() {
        this.fileReader = new FileDataReaderImpl();
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
            throw new ArrayCreationException("Error of reading a file: " + filePath);
        }
    }

    public ArrayStringEntity createStringArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            List<String> dataLines = fileReader.readAllLines(filePath);
            String[] strings = stringDataParser.parse(dataLines.getFirst());
            return arrayStringBuilder.create(strings);

        } catch (FileReadException e) {
            throw new ArrayCreationException("Error of reading a file: " + filePath);
        } catch (Exception e) {
            throw new ArrayCreationException("Error of creating an array: " + filePath);
        }
    }
}