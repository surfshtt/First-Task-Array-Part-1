package main.com.innowise.arraytask.io;

import main.com.innowise.arraytask.exception.FileReadException;

import java.util.List;

public interface FileDataReader {
     List<String> readAllLines(String filePath) throws FileReadException;
}
