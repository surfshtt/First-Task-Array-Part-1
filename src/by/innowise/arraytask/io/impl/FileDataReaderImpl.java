package by.innowise.arraytask.io.impl;



import by.innowise.arraytask.exception.FileReadException;
import by.innowise.arraytask.io.FileDataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class FileDataReaderImpl implements FileDataReader {
    private static final Logger logger = Logger.getLogger(FileDataReaderImpl.class.getName());

    @Override
    public List<String> readAllLines(String filePath) throws FileReadException {
        logger.info("Reading all lines from file: " + filePath);
        try {
            Path path = Paths.get(filePath);
            
            if (!Files.exists(path)) {
                throw new FileReadException("File wasn't found: " + filePath);
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
