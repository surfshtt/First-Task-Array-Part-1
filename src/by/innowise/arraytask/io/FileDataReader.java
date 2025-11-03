package by.innowise.arraytask.io;

import by.innowise.arraytask.exception.FileReadException;

import java.util.List;

public interface FileDataReader {
     List<String> readAllLines(String filePath) throws FileReadException;
}
