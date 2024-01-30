import java.util.Scanner;

public class LoanCalculator {
    static double creditInterestRate = 0.067; // 신용대출 이자율
    static double rate7 = 0.7; // 비율
    static double rate8 = 0.8; // 비율
    static double rate9 = 0.9; // 비율

    // 중기청
    static double j = 10000 * (10000.d); // 중기청 (1.5)/ 비율 (80%)
    static double loanInterestRateJ = 0.015; // 중기청 이자율

    // 버팀목
    static double b = 12000 * (10000.d); // 버팀목 (2.1~2.9) / 비율 (70%)
    static double loanInterestRateB = 0.029; // 중기청 이자율

    // 청년 버팀목
    static double cB = 20000 * (10000.d); // 청년 버팀목 (1.8~2.7) / 비율 (80%)
    static double loanInterestRateCb = 0.027; // 중기청 이자율

    // 신혼부부
    static double s = 30000 * (10000.d); // 신혼부부 전용 전세자금 (1.5 ~2.7) / 비율 (80%)
    static double loanInterestRateS = 0.027; // 중기청 이자율

    // 카뱅
    static double kJ = 22000 * (10000.d); // 카뱅 전월세자금 (4.057 ~4.963) / 비율 (80%)
    static double loanInterestRateKj = 0.05849; // 카뱅 이자율

    // 카뱅 청년 전월세
    static double kCj = 10000 * (10000.d); // 카뱅 청년전월세자금 (3.869 ~4.172) / 비율 (90%)
    static double loanInterestRateKcj = 0.04717; // 카뱅 청년 이자율


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("보증금을 입력하시오 : ");
        double totalCost = sc.nextInt() * 10000.d;
        System.out.print("월세를 입력하시오 : ");
        double monthCost = sc.nextInt() * 10000.d;
        System.out.print("관리비를 입력하시오 : ");
        double managementCost = sc.nextInt() * 10000.d;
        System.out.print("자본금을 입력하시오 : ");
        double budget = sc.nextInt() * 10000.d;

        calculator("중기청",j, rate8, loanInterestRateJ, creditInterestRate, totalCost, monthCost, budget, managementCost);
        calculator("버팀목",b, rate7, loanInterestRateB, creditInterestRate, totalCost, monthCost, budget, managementCost);
        calculator("청년 버팀목",cB, rate8, loanInterestRateCb, creditInterestRate, totalCost, monthCost, budget, managementCost);
        calculator("신혼부부",cB, rate8, loanInterestRateS, creditInterestRate, totalCost, monthCost, budget, managementCost);
        calculator("카카오뱅크",kJ, rate8, loanInterestRateKj, creditInterestRate, totalCost, monthCost, budget, managementCost);
        calculator("카카오뱅크 청년",kCj, rate9, loanInterestRateKcj, creditInterestRate, totalCost, monthCost, budget, managementCost);

    }

    private static void calculator(String loanName, double loanCost , double rate, double loanInterest, double creditInterestRate,
                                   double totalCost, double monthCost, double budget, double managementCost) {
        double loan ; // 대출금
        double creditInterestCost ; // 신용대출 이자 비용

        System.out.println("#####"+loanName+" 분석 시작"+"#####");

        // 대출금 계산
        if ((totalCost * rate) >= loanCost) {
            loan = loanCost;
        } else {
            loan = totalCost * rate;
        }

        // 대출 이자 계산
        double loanInterestCost = (loan * loanInterest)/12;

        // 신용 대출 이자 비용 계산
        if (totalCost - loan - budget <= 0) {
            creditInterestCost = 0.d;
        } else {
            creditInterestCost = ((totalCost - loan - budget) * creditInterestRate) /12;
        }

        // 월 비용 총액 계산
        double totalMonthCost = loanInterestCost + creditInterestCost + monthCost + managementCost;

        double totalLoan = totalCost - loan - budget;
        System.out.println("신용대출 필요 금액 : "+(int)(totalLoan/10000)+"만원");
        System.out.println("월세 총액:"+ (int)(totalMonthCost/10000)+"만 "+((int)(totalMonthCost%10000)+"원"));
        System.out.println("########################");
    }
}
