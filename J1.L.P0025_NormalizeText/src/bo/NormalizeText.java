package bo;

import java.util.ArrayList;
import java.util.List;

public class NormalizeText {

    public static List<String> normalize(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> normalizedLines = new ArrayList<>();
        boolean isAfterDot = true; // Capitalize first letter of the text and after dots

        for (String line : lines) {
            line = line.trim();
            
            // 1. Only one space between words
            line = line.replaceAll("\\s+", " ");

            // 3. Handle quotes: trim inside, ensure space outside
            StringBuffer sbQuotes = new StringBuffer();
            java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(line);
            while (m.find()) {
                String inside = m.group(1).trim();
                m.appendReplacement(sbQuotes, " \"" + inside + "\" ");
            }
            m.appendTail(sbQuotes);
            line = sbQuotes.toString().trim();
            
            // Clean up extra spaces created by quotes replacement
            line = line.replaceAll("\\s+", " ");

            // 6. No space before comma or dot or colon
            line = line.replaceAll("\\s+,", ",");
            line = line.replaceAll("\\s+\\.", ".");
            line = line.replaceAll("\\s+:", ":");
            
            // 2. Only one space after comma, dot, colon
            line = line.replaceAll(",(?=\\S)", ", ");
            line = line.replaceAll("\\.(?=\\S)", ". ");
            line = line.replaceAll(":(?=\\S)", ": ");
            
            // Convert to lowercase to satisfy "other words are in lower case"
            line = line.toLowerCase();
            
            // 4. Capitalize first character and character after dot
            StringBuilder sb = new StringBuilder();
            boolean newSentence = isAfterDot;
            
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                
                if (Character.isLetter(c)) {
                    if (newSentence) {
                        sb.append(Character.toUpperCase(c));
                        newSentence = false;
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                    if (c == '.') {
                        newSentence = true;
                    }
                }
            }
            
            isAfterDot = newSentence;
            normalizedLines.add(sb.toString().trim());
        }

        // 7. Must have dot at the end of text
        if (!normalizedLines.isEmpty()) {
            int lastIndex = normalizedLines.size() - 1;
            String lastLine = normalizedLines.get(lastIndex);
            if (!lastLine.isEmpty() && !lastLine.endsWith(".")) {
                normalizedLines.set(lastIndex, lastLine + ".");
            }
        }

        return normalizedLines;
    }
}
