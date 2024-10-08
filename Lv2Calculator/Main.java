package Lv2Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String end = "exit";
        String endCheck = "";//끝내기 확일
        String deleteResult;

        Calculator calculator = new Calculator(new AddOperation()); //계산기를 반복문 바깥으로 꺼냄
        while (!end.equals(endCheck)) {
            System.out.println("첫 번째 숫자를 입력: ");
            int firstNumber = sc.nextInt();
            System.out.println("두 번째 숫자를 입력: ");
            int secondNumber = sc.nextInt();
            System.out.println("연산자를 입력: ");
            String operator = sc.next(); //여기까지 input

            calculator.setOperation(getOperation(operator));

            if (operator.equals("/") && secondNumber == 0) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                continue;
            }
            if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
                System.out.println("결과: " + calculator.calculate(firstNumber, secondNumber));
            } else {
                System.out.println("결과: " + calculator.calculate(firstNumber, secondNumber)
                        + "나눴을 시 나머지 " + firstNumber % secondNumber);
            }
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)" + " 저장 사이즈: " + calculator.getSize());
            endCheck = sc.next();
            sc.nextLine();

            System.out.println("저장된 결과값: (확인 후 엔터)");
            for (Double result : calculator.getResults()) {
                System.out.print(result + " ");
            }

            sc.nextLine();
            System.out.println("가장 오래된 결과값을 지우시겠습니까?(yes or 아무키+엔터)");
            deleteResult = sc.next();
            if (deleteResult.equals("yes")) {
                calculator.setResults();
            }
        }
    }

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