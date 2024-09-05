package Lv2Calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Double> results = new ArrayList<>(); //접근제한
    //추상화
    private AbsOperation operation; //추상클래스 선언 및 캡슐화를 위해 private 접근제어자 사용

    //생성자
    public Calculator() {
        this.results = new ArrayList<>();
    }//pastResults() 생성자에서 resultList를 초기화

    public Calculator(AbsOperation operation) {
        this.operation = operation; //추상메서드 돌리기위해서 this로 자기선언
    }

    public ArrayList<Double> getResults() {
        return new ArrayList<>(results);
    }//getResultList()메서드는 resultList의 사본을 반환, 외부에서 리스트를 수정할 수 없게

    public void setResults(ArrayList<Double> results) {
        if (results != null) {
            this.results = new ArrayList<>(results);
        }
    }//이 메서드도 새로운 리스트를 resultList에 설정

    public void setOperation(AbsOperation operation) {
        this.operation = operation;
    } //setOperation 으로 연산자 바꾸는 "행위"만 하려고 함

    //아래는 계산부
    public double calculate(int firstNumber, int secondNumber) {
        double result = operation.operate(firstNumber, secondNumber);
        results.add(result);
        return result;
    }

    public int getSize() {
        return results.size();
    }
}