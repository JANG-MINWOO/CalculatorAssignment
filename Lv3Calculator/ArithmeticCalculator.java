package Lv3Calculator;

import java.util.ArrayList;

public class ArithmeticCalculator <N>{ //N 타입 제네릭클래스
    private ArrayList<Double> results = new ArrayList<>();

    public double calculate(N num1, N num2,OperatorType operator){
        double result = operator.calculate()
    }

    public ArithmeticCalculator(ArrayList<Double> results) {
        this.results = results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public ArrayList<Double> getResults() {
        return results;
    }
}
