package org.Java.Day5;

import java.util.Arrays;
import java.util.Iterator;


class Day5Activity3 {
 public static void main(String[] args) {
// String 배열의 선언과 생성
//	 String은 참조형이며 기본값은 null이다
	 
//	 가위 바위 보 게임을 만들어보자
	 String[] name = {"가위", "바위", "보"};
	 for(int i=0; i<10; i++) {
		 int tmx = (int)(Math.random()*3);
		 System.out.println(name[tmx]);
	 }
	 
// 2차원 배열
//	 테이블 형태(다행X다열)의 데이터를 저장하기 위한 배열

// ex) int[][] score = new int[4][3]; 
//	                           행,열
	 
	int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},
			{40,40,40}	
	};
	int sum = 0;
	for (int i=0; i<score.length; i++) {
		for(int j=0; j<score[i].length; j++) {
			System.out.printf("score[%d][%d]=[%d]%n",i,j,score[i][j]);
		sum+=score[i][j];
		}
	}
	System.out.println(sum);
	
// 1학년 1반 분기별 수학 성적
	int[][] total = {
						{98,73,83,91},
						{54,56,78,81},
						{34,55,68,75},
						{12,45,32,76},
						{34,57,85,98}
	};
//	분기별 총점
	int first = 0, second = 0, third = 0, fourth = 0;
	System.out.println("번호   1분기  2분기  3분기  4분기  총점  평균");
	for(int i=0; i<total.length; i++) {
		int sum1 = 0;
		float avg = 0.0f;
			first += total[i][0];
			second += total[i][1];
			third += total[i][2];
			fourth += total[i][3];
			System.out.printf("%3d", i+1);

			for(int j=0; j< total[i].length;j++) {
				sum1 += total[i][j]; 
				System.out.printf("%6d", total[i][j]);
			}

			avg = sum1/(float)total[i].length;  // 평균계산
			System.out.printf("%5d %5.1f%n", sum1, avg);
		}

		System.out.println("=============================");
     	System.out.printf("총점:%5d %5d %5d %5d %n", first, second, third,fourth);
		}
	
}

