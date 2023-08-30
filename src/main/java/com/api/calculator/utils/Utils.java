package com.api.calculator.utils;

import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Utils {
    private static int index = 0;
    public static String writeToFile (List<Double> results) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results" + index + ".txt", true))) {
            index++;
            for (Double result : results) {
                writer.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "results" + (index - 1) + ".txt";
    }

    private static String readResultsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            return result.toString();
        }
    }

    public static List<String> readFromFile (String fileName) {
        List<String> results = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            results = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
