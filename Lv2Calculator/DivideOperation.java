package Lv2Calculator;

public class DivideOperation extends AbsOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }
}
