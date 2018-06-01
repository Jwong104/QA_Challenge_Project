package com.company.DistanceCalculator;

public class DistanceCalculator {
    private DistanceCalculatorStrategy strategy;

    public DistanceCalculator(DistanceCalculatorStrategy strategy){
        this.strategy = strategy;
    }

    public double[] calc(String str_lat1, String str_lon1, String str_lat2, String str_lon2) throws Exception{
        return this.strategy.calc(str_lat1, str_lon1, str_lat2, str_lon2);
    }

    public void setStrategy(DistanceCalculatorStrategy strategy) {
        this.strategy = strategy;
    }
}
