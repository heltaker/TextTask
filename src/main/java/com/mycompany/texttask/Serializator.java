/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

public class Serializator {
    public String serialization(List list, String fileName, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        try {
            for (Object element : list) {
                writer.write(element.toString());
                writer.newLine(); 
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        } finally{
            if (writer != null){
                try {
                    writer.close();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
        }
        return "Сериализация завершена";
    }

    public String deserialization(String fileName) throws IOException{ 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (Pattern.matches("-?\\d+", line.trim())) {
                    TextTask.control.getListInt().add(Long.valueOf(line.trim()));
                } else if (Pattern.matches("-?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?", line.trim())) {
                    TextTask.control.getListFloat().add(Float.valueOf(line.trim()));
                } else if (Pattern.matches("\\s*[a-zA-Z\\u0400-\\u04FF ]+\\s*", line.trim())) {
                    TextTask.control.getListStr().add(line.trim());
                } else {
                    System.out.println("Не удалось определить тип строки");
                }
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при чтении файла", e);
        }
        return "Десериализация завершена";
    }
}
