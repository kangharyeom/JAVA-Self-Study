package dataStructure;

import java.util.Scanner;

public class ItWillBeOver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt(); // 테스트 케이스 수 입력

        for (int i = 0; i < test_case; i++) {
            int stu_Num = sc.nextInt(); // 학생 수
            int count = 0; // 평균을 넘는 학생 수
            double avg = 0; // 평균 점수.
            double avg_Over; // 평균을 넘는 학생 비율 구할 때 사용
            int[] score_arr = new int[stu_Num]; // 각 점수를 저장할 배열 생성
            for (int j = 0; j < stu_Num; j++) {
                int score = sc.nextInt();
                score_arr[j] = score; // 각 점수를 배열에 저장
                avg += score; // 점수의 합 구하기.
            }
            avg = avg / stu_Num; // 평균 점수 구하기.
            for (int k = 0; k < score_arr.length; k++) {
                if (score_arr[k] > avg) {
                    count++;
                }
            }
            avg_Over = (double) count / stu_Num * 100; // count를 double로 강제형 변환 시켜서 원하는 백분율 계산하기.
            //  std_Num은double / int이므로 자동 형변환이 일어나서 따로 안바꿔줘도 괜찮은듯.
            System.out.printf("%.3f", avg_Over);
            System.out.println("%");
        }
    }
}