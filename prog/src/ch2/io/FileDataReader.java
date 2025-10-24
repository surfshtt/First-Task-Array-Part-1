package ch2.io;

import ch2.exceptions.FileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileDataReader {

    public List<String> readAllLines(String filePath) throws FileReadException {
        try {
            Path path = Paths.get(filePath);
            
            if (!Files.exists(path)) {
                throw new FileReadException("Файл не найден: " + filePath);
            }
            
            if (!Files.isReadable(path)) {
                throw new FileReadException("Файл недоступен для чтения: " + filePath);
            }
            
            // Используем Java 8 Stream API для чтения файла
            try (Stream<String> lines = Files.lines(path)) {
                return lines.collect(Collectors.toList());
            }
            
        } catch (IOException e) {
            throw new FileReadException("Ошибка при чтении файла: " + filePath, e);
        }
    }
    
    public String readFirstLine(String filePath) throws FileReadException {
        List<String> lines = readAllLines(filePath);
        
        if (lines.isEmpty()) {
            throw new FileReadException("Файл пустой: " + filePath);
        }
        
        return lines.get(0);
    }
    
    public List<String> readNonEmptyLines(String filePath) throws FileReadException {
        try {
            Path path = Paths.get(filePath);
            
            if (!Files.exists(path)) {
                throw new FileReadException("Файл не найден: " + filePath);
            }
            
            if (!Files.isReadable(path)) {
                throw new FileReadException("Файл недоступен для чтения: " + filePath);
            }
            
            // Используем Java 8 Stream API для чтения и фильтрации файла
            try (Stream<String> lines = Files.lines(path)) {
                return lines
                    .filter(line -> line != null && !line.trim().isEmpty())
                    .collect(Collectors.toList());
            }
            
        } catch (IOException e) {
            throw new FileReadException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}
