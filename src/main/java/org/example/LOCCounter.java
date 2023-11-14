package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LOCCounter {

    public static void main(String[] args) {
        String fileName = "org/example/Sample.java";
        int locCount = countLOC(fileName);
        System.out.println("Lines of Code: " + locCount);
    }

    private static int countLOC(String fileName) {
        int locCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder multilineString = new StringBuilder();
            String line;
            boolean insideMultilineComment = false;
            boolean insideMultilineString = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("//")) {
                    // Skip empty lines and single-line comments
                    continue;
                }

                if (line.startsWith("/*")) {
                    insideMultilineComment = true;
                    if (line.endsWith("*/")) {
                        insideMultilineComment = false;
                    }
                    continue;
                }

                if (insideMultilineComment) {
                    if (line.endsWith("*/")) {
                        insideMultilineComment = false;
                    }
                    continue;
                }

                if (line.startsWith("\"\"\"")) {
                    insideMultilineString = !insideMultilineString;
                    if (insideMultilineString) {
                        multilineString.setLength(0);
                    }
                    continue;
                }

                if (insideMultilineString) {
                    multilineString.append(line);
                    if (line.endsWith("\"\"\"")) {
                        insideMultilineString = false;
                    }
                    continue;
                }

                locCount++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return locCount;
    }
}
