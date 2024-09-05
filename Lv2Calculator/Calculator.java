package Lv2Calculator;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Integer> resultList = new ArrayList<Integer>();

    private AbsOperation operation; //추상클래스 선언 및 캡슐화를 위해 private 접근제어자 사용

    public Calculator(AbsOperation operation) {
        this.operation = operation; //추상메서드 돌리기위해서 this로 자기선언
    }

    public void setOperation(AbsOperation operation) {
        this.operation = operation;
    }

//    int firstNumber, secondNumber;
//    String end = "exit";
//    String endCheck = "";
//    String operator;
//    int answer = 0;
//    int remainder = 0; //나머지
//    int quotient = 0; // 몫

    public double calculate(int firstNumber, int secondNumber) {
        double result = 0;
        result = operation.operate(firstNumber, secondNumber);
        return result;
    }

}