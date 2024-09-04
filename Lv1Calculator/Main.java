package Lv1Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber, secondNumber;
        String end = "exit";
        String endCheck = "";
        String operator;
        int answer = 0;
        int remainder = 0; //나머지
        int quotient = 0; // 몫

        while (!end.equals(endCheck)) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNumber = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNumber = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요(ex. + - * /): ");
            operator = sc.next();
            if (operator.equals("+")) {
                answer = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                answer = firstNumber - secondNumber;
            } else if (operator.equals("*")) {
                answer = firstNumber * secondNumber;
            } else if (operator.equals("/")) {
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌수 없습니다.");
                    continue;
                } else {
                    quotient = firstNumber / secondNumber;
                    remainder = firstNumber % secondNumber;
                }
            } //여기까지 계산
            if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
                System.out.println("결과 :" + answer);
            } else {
                System.out.println("결과 :" + "몫은 " + quotient + " " + "나머지는 " + remainder);
            } //나누기는 몫과 나머지 각각 표현
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");
            endCheck = sc.next();
        }
    }
}
