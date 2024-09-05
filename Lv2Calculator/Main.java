package Lv2Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String end = "exit";
        String endCheck = "";//끝내기 확일
        String operator = "";//연산자 미리선언해서

        Calculator calculator = new Calculator(new AddOperation()); //계산기를 반복문 바깥으로 꺼냄
        while (!end.equals(endCheck)) {
            System.out.println("첫 번째 숫자를 입력: ");
            int firstNumber = sc.nextInt();
            System.out.println("두 번째 숫자를 입력: ");
            int secondNumber = sc.nextInt();
            System.out.println("연산자를 입력: ");
            operator = sc.next(); //여기까지 input

            calculator.setOperation(getOperation(operator));

            if (operator.equals("/") && secondNumber == 0) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                continue;
            }
            if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
                System.out.println("결과: " + calculator.calculate(firstNumber, secondNumber));
            } else {
                System.out.println("결과: " + "몫 " + calculator.calculate(firstNumber, secondNumber)
                        + " 나머지 " + firstNumber % secondNumber);
            }
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");
            System.out.println("저장 사이즈: " + calculator.getSize());
            endCheck = sc.next();
            sc.nextLine();

            System.out.print("저장된 결과값: ");
            for (Double result : calculator.getResults()) {
                System.out.println(result);
            }
        }
    }

    //    private static Calculator getCalculator(String operator) {
//        Calculator calculator = new Calculator(new AddOperation());
//        switch (operator) {
//            case "+" -> calculator.setOperation(new AddOperation());
//            case "-" -> calculator.setOperation(new SubsOperation());
//            case "*" -> calculator.setOperation(new MultiOperation());
//            case "/" -> calculator.setOperation(new DivideOperation());
//        }
//        return calculator;
//    } //연산자에 맞는 Calculator의 기능을 이곳에서 조건으로 정한뒤
//    //getter로 main메서드에 보냄

    private static AbsOperation getOperation(String operator) {
        return switch (operator) {
            case "+" -> new AddOperation();
            case "-" -> new SubsOperation();
            case "*" -> new MultiOperation();
            case "/" -> new DivideOperation();
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}