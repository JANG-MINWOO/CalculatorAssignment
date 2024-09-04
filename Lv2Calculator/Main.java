package Lv2Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
//        int firstNumber, secondNumber;
        String end = "exit";
        String endCheck = "";
        String operator="";
//        int answer = 0;
//        int remainder = 0; //나머지
//        int quotient = 0; // 몫

        while (!end.equals(endCheck)) {
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");
            endCheck = sc.next();
        }
    }
}
