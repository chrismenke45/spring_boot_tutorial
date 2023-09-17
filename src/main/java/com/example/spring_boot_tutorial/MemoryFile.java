package com.example.spring_boot_tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MemoryFile {
    public static final Path currentRelativePath = Paths.get("");
    public static final String currentPath = currentRelativePath.toAbsolutePath().toString();
    private String filePath;

    public MemoryFile(String fileName) {
        this.filePath = currentPath + fileName;
    }

    public boolean addLineToFile(String text) {
        try {
            FileWriter fWriter = new FileWriter(this.filePath, true);
            fWriter.write(text);
            fWriter.write("\n");
            fWriter.close();
            return true;
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    public String readFileLine(int lineNumber) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            sc.useDelimiter("\n");
            int count = 0;
            while (sc.hasNext()) {
                count++;
                String currentLine = sc.next();
                if (count == lineNumber) {
                    return currentLine;
                }
            }
            sc.close();
            return "";
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }

}