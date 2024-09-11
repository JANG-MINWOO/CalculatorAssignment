package Lv3Calculator;


import java.util.function.BiFunction;

public enum OperatorType {
    //람다식을 활용해서 열거
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);


    private String operator;
    private BiFunction<Double, Double, Double> operation;

    OperatorType(String operator, BiFunction<Double, Double, Double> operation) {
        this.operator = operator;
        this.operation = operation;
    } //생성자

    public String getOperator() {
        return operator;
    }

    public BiFunction<Double, Double, Double> getOperation() {
        return operation;
    }
    public static OperatorType fromOperator(String operator) {
        for(OperatorType type : OperatorType.values()) {
            if(type.getOperator().equals(operator)) {
                return type;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자: " + operator);
    }
}
