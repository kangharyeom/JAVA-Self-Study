import java.text.DecimalFormat;
import java.util.Stack;

public class SalaryCalculator {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("###,###");


        int income = 3000000; // 월 급여
        int outcome = 0; // 월 지출
        int targetMoney = 30000000;

        int a = 100000; // 지출 내역 1
        int b = 0; // 지출 내역 2
        int c = 0; // 지출 내역 3
        int d = 0; // 지출 내역 4
        int e = 0; // 지출 내역 5
        int f = 0; // 지출 내역 6
        int g = 0; // 지출 내역 7
        int h = 0; // 지출 내역 8
        int l = 0; // 지출 내역 9


        // 지출 내역이 생길 때 마다 add 추가하기
        Stack<Integer> outcomes = new Stack<>();
        outcomes.add(a);
        outcomes.add(b);
        outcomes.add(c);
        outcomes.add(d);
        outcomes.add(e);
        outcomes.add(f);
        outcomes.add(g);
        outcomes.add(h);
        outcomes.add(l);

        for (int i=0; i<outcomes.size(); i++){
            outcome += outcomes.get(i);
        }

        int totalRate = income - outcome;

        System.out.println("순수익 : " + df.format(totalRate));
        System.out.println("남은 금액 : " + df.format(targetMoney-totalRate));


    }
}