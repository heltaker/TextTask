/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllingClass{
    public static Serializator serializator;
    private static WholeNumbers<Long> wholeNumb;
    private static RealNumbers<Float> realNumb;
    private static Strings<String> Str;
    private static List<Long> listInt;
    private static List<Float> listFloat;
    private static List<String> listStr;
    public static String fileName;
    private static String flagO;
    private static String flagP;
    private static boolean flagA;
    
    
    
    ControllingClass(String flagO, String flagP, boolean flagA) {
        serializator = new Serializator();
        this.listInt = new ArrayList<>();
        this.listFloat = new ArrayList<>();
        this.listStr = new ArrayList<>();
        this.flagO = flagO;
        this.flagP = flagP;
        this.flagA = flagA;
    }
    
    public static void readFiles(List files) throws IOException {
        try {
            for (int i = 0; i < files.size(); i++){
            serializator.deserialization(files.get(i).toString());
            }
        } 
        catch (IOException e) {
            throw new IOException("Не удается прочитать файл", e);
        }
    }
    
    public static void serializationObj() {
        if (!listInt.isEmpty()){
            TextTask.control.wholeNumb = new WholeNumbers(listInt, getFlagP());
            fileName = getFlagO() + "\\" + getFlagP() + "integer" + ".txt";
            try {
                serializator.serialization(listInt, fileName, isFlagA());
            } catch (IOException ex) {
                Logger.getLogger(ControllingClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!listFloat.isEmpty()){
            TextTask.control.realNumb = new RealNumbers(listFloat, getFlagP());
            fileName = getFlagO() + "\\" + getFlagP() + listFloat.get(0).getClass().getSimpleName().toLowerCase()+ ".txt";
            try {
                serializator.serialization(listFloat, fileName, isFlagA());
            } catch (IOException ex) {
                Logger.getLogger(ControllingClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!listStr.isEmpty()){
            TextTask.control.Str = new Strings(listStr, getFlagP());
            fileName = getFlagO() + "\\" + getFlagP() + listStr.get(0).getClass().getSimpleName().toLowerCase() + ".txt";
            try {
                serializator.serialization(listStr, fileName, isFlagA());
            } catch (IOException ex) {
                Logger.getLogger(ControllingClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void printInfo(boolean flagS, boolean flagF){
        if (flagS) {
            if (flagF) {
                if (!listInt.isEmpty()) {
                    System.out.println(wholeNumb.toString()+ "\n");
                }
                if (!listFloat.isEmpty()) {
                    System.out.println(realNumb.toString()+ "\n");
                }
                if (!listStr.isEmpty()){
                    System.out.println(Str.toString()+ "\n");
                }
            } else {
                if (!listInt.isEmpty()) {
                    System.out.println(wholeNumb.statistic()+"\n");
                }
                if (!listFloat.isEmpty()) {
                    System.out.println(realNumb.statistic()+"\n");
                }
                if (!listStr.isEmpty()){
                    System.out.println(Str.statistic()+"\n");
                }
            }
            
        }
    }
    
    public List getListInt(){
        return this.listInt;
    }
    
    public List getListFloat(){
        return this.listFloat;
    }
    
    public List getListStr(){
        return this.listStr;
    }

    /**
     * @return the flagO
     */
    public static String getFlagO() {
        return flagO;
    }

    /**
     * @param aFlagO the flagO to set
     */
    public static void setFlagO(String aFlagO) {
        flagO = aFlagO;
    }

    /**
     * @return the flagP
     */
    public static String getFlagP() {
        return flagP;
    }

    /**
     * @param aFlagP the flagP to set
     */
    public static void setFlagP(String aFlagP) {
        flagP = aFlagP;
    }

    /**
     * @return the flagA
     */
    public static boolean isFlagA() {
        return flagA;
    }

    /**
     * @param aFlagA the flagA to set
     */
    public static void setFlagA(boolean aFlagA) {
        flagA = aFlagA;
    }
}
