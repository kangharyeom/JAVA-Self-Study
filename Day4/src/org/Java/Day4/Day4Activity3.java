package org.Java.Day4;

import java.text.BreakIterator;
import java.util.Scanner;

class Day4Activity3 {

	public static void main(String[] args) {
// switch 조건식  
//	= 처리해야 하는 경우의 수가 많을 때 유용한 조건문
//	#1 조건식을 계산한다.
//	#2 조건식 결과와 일치하는 case문으로 이동한다.
//	#3 break문이 나오면 switch문을 벗어난다.	
//	#4 break문이나 switch문의 끝이 나오면 switch문을 벗어난다
	
// switch문의 제약조건
//  #결과가 정수 또는 문자열이어야 한다.
//  case문의 값은 정수 상수(문자 포함), 문자열만 가능하며
//	중복되지 않아야 한다.
		
// switch문 예제
//	분기 계산기
		System.out.println("현재 월을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		switch(month) {
		case 1,2,3: 
			System.out.println("1분기 입니다.");
		break;
		case 4,5,6: 
			System.out.println("2분기 입니다.");
		break;
		case 7,8,9: 
			System.out.println("3분기 입니다.");
		break;
		default:
			System.out.println("4분기 입니다.");
		
		}
	}
}
