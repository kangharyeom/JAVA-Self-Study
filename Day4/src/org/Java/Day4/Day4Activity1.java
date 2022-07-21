package org.Java.Day4;

import java.util.Scanner;

import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Day4Activity1 {

	public static void main(String[] args) {
// 제어문 = 조건문, 반복문
//		조건문 = if문 
		
//	x가 참인 경우
		int x = 30;
		if(x>25) {
			System.out.println("합격입니다.");
		}
		
//	x가 거짓인 경우
		if(x<25) {
			System.out.println("합격입니다.");
		}
		System.out.println("불합격입니다.");

//	또는 if else를 활용하여
		if(x<25) {
			System.out.println("합격입니다.");
		} else {
		System.out.println("불합격");
		}
		
// if else if문 = 경우의 수가 세가지 이상인 경우
		if(x<24) {
			System.out.println("합격입니다");
		} else if(x<26) {
			System.out.println("합격입니다");
		} else if(x<29) {
			System.out.println("합격입니다");
		} else {
			System.out.println("합격이 아닙니다.");
		}
		
// 학점 판독기를 만들어보자 
		int score = 0; //시험 점수
		char grade = ' '; //학점, 공백을 넣어 초기화한다.
		
		System.out.println("점수를 입력해주세요 =>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		if (score>=90) {
			grade = 'A';
		} else if (score>=80) {
			grade = 'B';				
		} else if (score>=70){
			grade = 'C';
		} else {
			grade = 'D';
		}
		System.out.println("학점은"+ grade + "입니다.");
	}		
}
