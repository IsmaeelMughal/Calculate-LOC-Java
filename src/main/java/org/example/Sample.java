package org.example;// Sample Java File

/*
 * This is a multiline comment.
 * It spans multiple lines.
 */

public class Sample {

    // This is a single-line comment

    public static void main(String[] args) {
        // Single-line comment within a method

        String singleLineString = "This is a single-line string.";

        /*
         * Multiline comment within a method.
         * It spans multiple lines.
         */

        String multilineString = "This is a " +
                "multiline " +
                "string.";

        int x = 5; // Single-line comment at the end of a line
        int y = 10;

        // This is an empty line

        int result = add(x, y);

        System.out.println("Result: " + result);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
