package org.example;

import org.apache.commons.math3.stat.StatUtils;


public class ArithmeticMean {

    public static Double getArithmeticMean(double[] dataarray) {
        Double finalRes = StatUtils.mean(dataarray);
        return finalRes;
    }
}