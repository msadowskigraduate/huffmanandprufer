package com.michalsadowski.giz.services;

import com.michalsadowski.giz.prufer.domain.PruferCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sadowsm3 on 21.05.2018
 */
public class PruferFileReader {
    public static PruferCode readFromFile(Path filePath) {
        PruferCode pruferCode = new PruferCode();
        try {
            List<String> stringStream = Files.lines(filePath).collect(Collectors.toList());
            if (stringStream.size() == 3) {
                pruferCode.setRootNode(stringStream.get(0));
                pruferCode.setNodeList(stringStream.get(1).split(" "));
                pruferCode.setIdentifierList(stringStream.get(2).split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pruferCode;
    }
}
