package main.com.innowise.arraytask.parser;

import main.com.innowise.arraytask.exception.DataValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringDataParser {
    
    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");
    private static final Pattern COMMA_PATTERN = Pattern.compile(",\\s*");
    private static final Pattern DASH_PATTERN = Pattern.compile("\\s*-\\s*");
    
    public String[] parse(String line) throws DataValidationException {
        if (line == null || line.isBlank()) {
            throw new DataValidationException("String cannot be null or blank");
        }
        
        List<String> tokens = parseTokens(line.trim());
        List<String> result = new ArrayList<>();
        List<String> invalidTokens = new ArrayList<>();
        
        for (String token : tokens) {
            if (isValidString(token)) {
                result.add(token);
            } else {
                invalidTokens.add(token);
            }
        }
        
        if (!invalidTokens.isEmpty()) {
            throw new DataValidationException(
                "Incorrect data: " + String.join(", ", invalidTokens)
            );
        }
        
        if (result.isEmpty()) {
            throw new DataValidationException("There arent any correct data");
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    private List<String> parseTokens(String line) {
        List<String> tokens = new ArrayList<>();
        
        if (line.contains(",")) {
            String[] parts = COMMA_PATTERN.split(line);
            for (String part : parts) {
                if (!part.trim().isEmpty()) {
                    tokens.add(part.trim());
                }
            }
        }
        else if (line.contains("-")) {
            String[] parts = DASH_PATTERN.split(line);
            for (String part : parts) {
                if (!part.trim().isEmpty()) {
                    tokens.add(part.trim());
                }
            }
        }
        else {
            String[] parts = SPACE_PATTERN.split(line);
            for (String part : parts) {
                if (!part.trim().isEmpty()) {
                    tokens.add(part.trim());
                }
            }
        }
        
        return tokens;
    }
    
    private boolean isValidString(String token) {
        return token != null && !token.trim().isEmpty();
    }
}
