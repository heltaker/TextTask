/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.util.Collections;
import java.util.List;

public class RealNumbers<T extends Float> extends TemplateClass<T> {
    private static float min;
    private static float max;
    private static double mean;
    private static double sum;

    RealNumbers(List<T> list, String flagP) {
        super(list, flagP);
        float[] minMax = minMax();
        double[] sumMean = sumMean();
        this.min = minMax[0];
        this.max = minMax[1];
        this.sum = sumMean[0];
        this.mean = sumMean[1];
    }

    public float[] minMax() {
        List<T> tmp = this.getList();
        Collections.sort(tmp);
        float min = Collections.min(tmp);
        float max = Collections.max(tmp);
    
        float[] res = {min, max};
        return res;
    }

    public double[] sumMean(){
        List<T> list = getList();
        double sum = 0;
        for (T item : list) {
        sum += (double)item;
        }
        double mean = sum / list.size();
        double[] res = {sum, mean};
        return res;
    }

    public String statistic(){
        return super.toString();
    }

    /**
     * @return the min
     */
    public static float getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(float aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static float getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(float aMax) {
        max = aMax;
    }

    /**
     * @return the mean
     */
    public static double getMean() {
        return mean;
    }

    /**
     * @param aMean the mean to set
     */
    public static void setMean(double aMean) {
        mean = aMean;
    }

    /**
     * @return the sum
     */
    public static double getSum() {
        return sum;
    }

    /**
     * @param aSum the sum to set
     */
    public static void setSum(double aSum) {
        sum = aSum;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n минимальное значение: " + getMin() + "\n максимальное значение: " + getMax()
                + "\n среднее: " + getMean() + "\n сумма: " + getSum();
    }
}
