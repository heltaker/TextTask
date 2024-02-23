/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.util.Collections;
import java.util.List;

public class WholeNumbers<T extends Long> extends TemplateClass<T> {
    private static long min;
    private static long max;
    private static long mean;
    private static long sum;
    
    WholeNumbers(List<T> list, String flagP) {
        super(list, flagP);
        long[] minMax = minMax();
        long[] sumMean = sumMean();
        this.min = minMax[0];
        this.max = minMax[1];
        this.sum = sumMean[0];
        this.mean = sumMean[1];
    }

    public long[] minMax() {
        List<T> tmp = this.getList();
        Collections.sort(tmp);
        long min = Collections.min(tmp);
        long max = Collections.max(tmp);
    
        long[] res = {min, max};
        return res;
    }

    public long[] sumMean(){
        List<T> list = getList();
        long sum = 0;
        for (T item : list) {
        sum += (long)item;
        }
        long mean = sum / list.size();
        long[] res = {sum, mean};
        return res;
    }

    public String statistic(){
        return super.toString();
    }

    /**
     * @return the min
     */
    public static long getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(int aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static long getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(int aMax) {
        max = aMax;
    }

    /**
     * @return the mean
     */
    public static Long getMean() {
        return mean;
    }

    /**
     * @param aMean the mean to set
     */
    public static void setMean(Long aMean) {
        mean = aMean;
    }

    /**
     * @return the sum
     */
    public static Long getSum() {
        return sum;
    }

    /**
     * @param aSum the sum to set
     */
    public static void setSum(Long aSum) {
        sum = aSum;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n минимальное значение: " + getMin() + "\n максимальное значение: " + getMax()
                + "\n среднее: " + getMean() + "\n сумма: " + getSum();
    }
}
