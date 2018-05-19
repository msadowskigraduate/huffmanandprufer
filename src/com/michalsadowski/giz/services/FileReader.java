package com.michalsadowski.giz.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class FileReader {

    public static String readFromFile(Path filePath) {
        try {
            Stream<String> stringStream = Files.lines(filePath);
            return stringStream.reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
