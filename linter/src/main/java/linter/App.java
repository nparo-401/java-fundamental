package linter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static String linterMessage(String path) {
        Scanner scnr = null;
        String response = "";
        int lineNumber = 1;

        try {
            scnr = new Scanner(new BufferedReader(new FileReader("./src/main/resources/" + path)));
            String lines;
            while (scnr.hasNextLine()) {
                lines = scnr.nextLine();
                response += errorChecker(lines, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        } finally {
            if (scnr != null) {
                scnr.close();
            }
        }
        if (response.equals("")) return "The file has no missing semicolons";
        else return response;
    }

    private static String errorChecker(String line, int lineNumber) {
        char openCurly = '{';
        char closeCurly = '}';
        char semi = ';';
        char last = ' ';
        boolean ifCheck = line.contains("if");
        boolean elseCheck = line.contains("else");

        StringBuilder response = new StringBuilder();

        if (line.length() != 0) {
            last = line.charAt(line.length() - 1);
        }

        if (!ifCheck && !elseCheck && last != openCurly && last != closeCurly && line.length() != 0) {
            if (last != semi) {
                response.append("Line ").append(lineNumber).append(": Missing semicolon").append("\n");
            }
        }

        return response.toString();
    }

    public static void main(String[] args) {
        System.out.println(linterMessage("gates.js"));
        System.out.println();
        System.out.println(linterMessage("empty.js"));
        System.out.println();
        System.out.println(linterMessage("no-errors.js"));
    }
}
