package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import jdk.nashorn.internal.ir.IfNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e) ;
        }
        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
      }


        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);




        }

        printDirectoryDeeply(dir, "");



    }



    public static void printDirectoryDeeply(File dir, String offset) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file  : files){
                if (file.isFile()) {
                    System.out.println(offset+"File:" + " " +file.getName());
                }

                if (file.isDirectory()) {
                    System.out.println(offset+"Directory:" + file.getName());
                    printDirectoryDeeply(file,  offset+"   ");
                }
            }
        }

    }



}












