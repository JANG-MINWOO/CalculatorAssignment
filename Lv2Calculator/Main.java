package Lv2Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String end = "exit";
        String endCheck = "";//끝내기 확일
        while (!end.equals(endCheck)) {
            System.out.println("첫 번째 숫자를 입력: ");
            int firstNumber = sc.nextInt();
            System.out.println("두 번째 숫자를 입력: ");
            int secondNumber = sc.nextInt();
            System.out.println("연산자를 입력: ");
            String operator = sc.next(); //여기까지 input

            Calculator calculator = getCalculator(operator);
            System.out.println("결과: " + calculator.calculate(firstNumber, secondNumber));
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");
            endCheck = sc.next();
        }
    }

    private static Calculator getCalculator(String operator) {
        Calculator calculator = new Calculator(new AddOperation());
        if (operator.equals("+")) {
            calculator.setOperation(new AddOperation());
        } else if (operator.equals("-")) {
            calculator.setOperation(new SubsOperation());
        } else if (operator.equals("*")) {
            calculator.setOperation(new MultiOperation());
        } else if (operator.equals("/")) {
            calculator.setOperation(new DivideOperation());
        }
        return calculator;
    } //연산자에 맞는 Calculator의 기능을 이곳에서 조건으로 정한뒤
      //getter로 main메서드에 보냄
}
//        int remainder = 0; //나머지
//        int quotient = 0; // 몫