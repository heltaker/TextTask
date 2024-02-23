/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Strings<T extends String> extends TemplateClass<T> {
    
    private static String min;
    private static String max;

    Strings(List<T> list, String flagP) {
        super(list, flagP);
        String[] minMax = minMax();
        this.min = minMax[0];
        this.max = minMax[1];
    }

    public String[] minMax() {
        List<T> tmp = this.getList();
        String shortest = Collections.min(tmp, Comparator.comparing(String::length));
        String longest = Collections.max(tmp, Comparator.comparing(String::length));
    
        String[] res = {shortest, longest};
        return res;
    }

    public String statistic(){
        return super.toString();
    }

    /**
     * @return the min
     */
    public static String getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(String aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static String getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(String aMax) {
        max = aMax;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n короткая строка: " + getMin() + "\n длинная строка: " + getMax();
    }
}
