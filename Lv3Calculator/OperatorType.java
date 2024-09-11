package Lv3Calculator;


import java.util.function.BiFunction;

public enum OperatorType {
    //람다식을 활용해서
    PLUS("+", Double::sum),
    MINUS("-", (num1, num2) -> (double) (num1 - num2)),
    MULTIPLY("*", (num1, num2) -> (double) (num1 * num2)),
    DIVIDE("/", (num1, num2) -> (double) (num1 / num2));

    private String operator;
    private BiFunction<Integer, Integer, Double> expression;

    OperatorType(String operator, BiFunction<Integer, Integer, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Double calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
