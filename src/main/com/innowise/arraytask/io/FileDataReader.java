package main.com.innowise.arraytask.io;



import main.com.innowise.arraytask.exception.FileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileDataReader {

    public List<String> readAllLines(String filePath) throws FileReadException {
        try {
            Path path = Paths.get(filePath);
            
            if (!Files.exists(path)) {
                throw new FileReadException("File not found: " + filePath);
            }
            
            if (!Files.isReadable(path)) {
                throw new FileReadException("File is unreadable: " + filePath);
            }

            return Files.readAllLines(path);
            
        } catch (IOException e) {
            throw new FileReadException("Error of reading a file: " + filePath);
        }
    }
}
