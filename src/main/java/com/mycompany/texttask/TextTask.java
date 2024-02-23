/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.texttask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextTask {
    
    private static String flagO;
    private static String flagP;
    private static boolean flagA;
    private static boolean flagS;
    private static boolean flagF;
    public static ControllingClass control;
    
    public static void main(String[] args) {
        Options(args);
        try {
            control = new ControllingClass(flagO, flagP, flagA);
            control.readFiles(NameFiles(args));
            control.serializationObj();
            control.printInfo(flagS, flagF);
        } catch (IOException ex) {
            Logger.getLogger(TextTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<String> NameFiles(String[] args) {
        List<String> files = new ArrayList<>();
        String workingDir = System.getProperty("user.dir"); 
        for (String arg : args) {
            if (arg.endsWith(".txt")) {
                String filePath = arg.startsWith("C:\\") ? arg : workingDir + File.separator + arg;
                files.add(filePath);
            }
        }
        return files;
    }
    
    public static void Options(String[] args) {
        String directory = System.getProperty("user.dir");
        flagO = directory;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-o" -> {
                    if (i < args.length - 1) {
                        flagO = args[++i];
                    } else {
                        System.out.println("Путь для параметра -o не указан");
                    }
                }
                case "-p" -> {
                    if (i < args.length - 1) {
                        flagP = args[++i];
                    } else {
                        System.out.println("Для параметра -p не указан префикс файла");
                    }
                }
                case "-a" -> flagA = true;
                case "-s" -> {
                    flagS = true;
                    flagF = false;
                }
                case "-f" -> {
                    flagS = true;
                    flagF = true;
                }
            }
        }
    }
}
