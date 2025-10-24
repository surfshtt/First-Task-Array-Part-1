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

            return Files.readAllLines(path);
            
        } catch (IOException e) {
            throw new FileReadException("Ошибка при чтении файла: " + filePath);
        }
    }
}
