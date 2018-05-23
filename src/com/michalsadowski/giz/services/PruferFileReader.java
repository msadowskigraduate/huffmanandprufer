package com.michalsadowski.giz.services;

import com.michalsadowski.giz.prufer.domain.PruferCode;
import com.michalsadowski.giz.services.exception.InvalidFileException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sadowsm3 on 21.05.2018
 */
public class PruferFileReader {
    public static PruferCode readFromFile(Path filePath) throws InvalidFileException {
        try {
            List<String> stringStream = Files.lines(filePath).collect(Collectors.toList());
            if (stringStream.size() == 3) {
                String[] identifierList = stringStream.get(1).split(" ");
                String[] nodeListList = stringStream.get(2).split(" ");
                if(validateArray(identifierList) && validateArray(nodeListList)) {
                    PruferCode pruferCode = new PruferCode();
                    pruferCode.setRootNode(stringStream.get(0));
                    pruferCode.setIdentifierList(identifierList);
                    pruferCode.setNodeList(nodeListList);
                    return pruferCode;
                }
            }
            throw new InvalidFileException(SharedConst.GENERAL_ERROR_CODE);
        } catch (Exception e) {
            throw new InvalidFileException(SharedConst.GENERAL_ERROR_CODE);
        }
    }

    private static boolean validateArray(String[] array) {
        return Arrays.stream(array).anyMatch(String::isEmpty);
    }
}
