package Lv3Calculator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(); //계산기 인스턴스화

        System.out.print("첫번째 수?");
        double num1 = sc.nextDouble();
        System.out.print("연산자?");
        String operatorSymbol = sc.next();
        System.out.print("두번째 수?");
        double num2 = sc.nextDouble();

        try {
            OperatorType operator = OperatorType.fromOperator(operatorSymbol); //operator인스턴스에 연산자넣음
            Double result = calculator.calculate(num1, num2, operator);
            System.out.print(result);

            System.out.print("원하는 값을 입력하시면, 그 값보다 더 큰 계산결과들을 볼 수 있습니다.");
            double results = sc.nextDouble();
            List<Double> greaterResults = calculator.getResults(results);

            System.out.println("입력한 값보다 큰 결과값들: "+greaterResults);
            for(Double a : greaterResults){
                System.out.println(a+" ");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
