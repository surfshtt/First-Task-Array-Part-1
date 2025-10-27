package parser;


import exception.DataValidationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class IntegerDataParser {
    
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");
    private static final Pattern COMMA_PATTERN = Pattern.compile(",\\s*");
    private static final Pattern DASH_PATTERN = Pattern.compile("\\s*-\\s*");
    
    public int[] parse(String line) throws DataValidationException {
        if (line == null || line.trim().isEmpty()) {
            throw new DataValidationException("String cannot be null or empty");
        }
        
        List<String> tokens = parseTokens(line.trim());
        List<Integer> result = new ArrayList<>();
        List<String> invalidTokens = new ArrayList<>();
        
        for (String token : tokens) {
            if (isValidInteger(token)) {
                try {
                    result.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    invalidTokens.add(token);
                }
            } else {
                invalidTokens.add(token);
            }
        }

        if (!invalidTokens.isEmpty()) {
            throw new DataValidationException("Incorrect data");
        }
        
        if (result.isEmpty()) {
            throw new DataValidationException("There aren't any integers to ffind");
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
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
    
    private boolean isValidInteger(String token) {
        return INTEGER_PATTERN.matcher(token).matches();
    }
}
