package com.michalsadowski.giz.services;

import com.michalsadowski.giz.services.exception.InvalidFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanFileReader {
    public static String readFromFile(Path filePath) throws InvalidFileException {
        try {
            Stream<String> stringStream = Files.lines(filePath);
            return stringStream.reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InvalidFileException(SharedConst.GENERAL_ERROR_CODE);
    }
}
