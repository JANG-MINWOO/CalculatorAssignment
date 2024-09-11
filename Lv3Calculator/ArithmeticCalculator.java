package Lv3Calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number>{ //T 타입 제네릭클래스
                                                        //계산기 클래스를 매개변수 T를 선언하고 이것은
                                                        //Number의 서브타입만 허용한다는 의미(int,double 등)
    private List<Double> results = new ArrayList<>();

    public T calculate(T a, T b, OperatorType operator){ //피연산자두개와 연산자하나를 받아 result에 대입
//        double result = operator.getOperation().apply(a.doubleValue(), b.doubleValue());

        double result;
        switch (operator){
            case ADD:
            case SUBTRACT:
            case MULTIPLY: //위 세가지 계산은 예외 없음
                result=operator.getOperation().apply(a.doubleValue(),b.doubleValue());
                break;
            case DIVIDE:  //나누기는 두번째인자 0 불가능 예외가 있기때문에
                if(a.doubleValue() == 0){
                    throw new ArithmeticException("0으로 나눌 수 없음"); //예외날리기
                }
                result=operator.getOperation().apply(a.doubleValue(),b.doubleValue());
                break; //아니면 계산하고 break

            default: //다 해당안되면 사칙연산자가아니라 예외날리기
                throw new IllegalArgumentException("유효하지 않은 연산자"+operator.getOperator());
        }
                results.add(result); //result를 결과값들을 저장할 List results에 대입
        return (T) (Number) result; //Number에 해당하는녀석들을 T 타입 형변환후 return
    }

    public List<Double> getResults(double compare) {  //큰 결과값들을 불러올 getter
        List<Double> greaterResults = new ArrayList<>(); // 입력한 값보다 큰 과거결과값들을 저장할 리스트
        for(Double result : results){ //매개변수result, 과거결과값리스트results를 돌때
            if(result > compare){ //getter의 매개변수 compare보다 result가 클때 그 값을
                greaterResults.add(result); //greaterResults에 넣음
            }
        }
        return greaterResults; //완성한 큰 과거결과값리스트 return
    }


}
