package com.xn.sdhh.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountUtil {
    public static Long mul(double rate1, double rate2) {
        BigDecimal a = new BigDecimal(Double.toString(rate1));
        BigDecimal b = new BigDecimal(Double.toString(rate2));
        return a.multiply(b).longValue();
    }

    public static Long mul(Long amount, double rate) {
        BigDecimal a = new BigDecimal(Double.toString(amount));
        BigDecimal b = new BigDecimal(Double.toString(rate));
        return a.multiply(b).longValue();
    }

    public static double div(Long amount, double number) {
        BigDecimal a = new BigDecimal(Double.toString(amount));
        BigDecimal b = new BigDecimal(Double.toString(number));
        return a.divide(b, 8, RoundingMode.DOWN).doubleValue();
    }

    public static double div(double rate1, double rate2) {
        BigDecimal a = new BigDecimal(Double.toString(rate1));
        BigDecimal b = new BigDecimal(Double.toString(rate2));
        return a.divide(b, 8, RoundingMode.DOWN).doubleValue();
    }

    // 保留两位小数，末尾数不管是几，前一位都加1
    public static Long eraseLiUp(Long amount) {
        String amountString = CalculationUtil.diviUp(amount);
        return Long.valueOf(CalculationUtil.multUp(amountString));
    }

    // 保留两位小数，末尾数不管是几，前一位都加1
    public static Long eraseLiDown(Long amount) {
        String amountString = CalculationUtil.diviDown(amount);
        return Long.valueOf(CalculationUtil.multDown(amountString));
    }

    public static void main(String[] args) {
        System.out.println(mul(100L, 2.0));
    }
}
