package ch2.factory;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.array.impl.ArrayStringEntity;
import ch1.builder.impl.IntegerArrayBuilder;
import ch1.builder.impl.StringArrayBuilder;
import ch2.exceptions.ArrayCreationException;
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
            String dataLine = fileReader.readFirstLine(filePath);
            List<Integer> integers = integerValidator.validateAndParse(dataLine);
            return IntegerArrayBuilder.create(integers).build();
        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath, e);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива целых чисел из файла: " + filePath, e);
        }
    }
    
    public ArrayStringEntity createStringArrayFromFile(String filePath) throws ArrayCreationException {
        try {
            String dataLine = fileReader.readFirstLine(filePath);
            List<String> strings = stringValidator.validateAndParse(dataLine);
            return StringArrayBuilder.create(strings).build();
            
        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath, e);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива строк из файла: " + filePath, e);
        }
    }
    
    public ArrayIntegerEntity createIntegerArrayFromAllLines(String filePath) throws ArrayCreationException {
        try {
            List<String> lines = fileReader.readNonEmptyLines(filePath);
            
            if (lines.isEmpty()) {
                throw new ArrayCreationException("Файл не содержит данных: " + filePath);
            }
            
            String combinedData = String.join(" ", lines);
            List<Integer> integers = integerValidator.validateAndParse(combinedData);
            return IntegerArrayBuilder.create(integers).build();
            
        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath, e);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива целых чисел из всех строк файла: " + filePath, e);
        }
    }
    
    public ArrayStringEntity createStringArrayFromAllLines(String filePath) throws ArrayCreationException {
        try {
            List<String> lines = fileReader.readNonEmptyLines(filePath);
            
            if (lines.isEmpty()) {
                throw new ArrayCreationException("Файл не содержит данных: " + filePath);
            }
            
            String combinedData = String.join(" ", lines);
            List<String> strings = stringValidator.validateAndParse(combinedData);
            return StringArrayBuilder.create(strings).build();
            
        } catch (FileReadException e) {
            throw new ArrayCreationException("Ошибка чтения файла: " + filePath, e);
        } catch (Exception e) {
            throw new ArrayCreationException("Ошибка создания массива строк из всех строк файла: " + filePath, e);
        }
    }
}
