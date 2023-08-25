package com.tests_divers;

import java.io.File;
import java.io.IOException;

public class TestsDivers {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/roomJobfinished.txt");
        if(file.createNewFile()) {
            System.err.println("Fichier de check créé avec succès");
        }
    }
}
