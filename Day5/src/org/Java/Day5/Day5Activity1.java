package org.Java.Day5;

import java.util.Arrays;

public class Day5Activity1 {
 public static void main(String[] args) {
// 배열 
//	 =같은 타입의 변수를 하나의 묶음으로 다루는 것
	 
// 배열의 선언 - 배열을 다루기 위한 참조변수의 선언
// 배열을 선언하기 위한 방법
//	 타입[] 변수이름 = ex) int[] score;
//	 					String[] name;
//OR 타입 변수이름[] = ex) int score[];
//	 					String name[];
	 
	 int[] score; // 1. 배열을 선언한다.
	 score = new int[5]; // 2. 배열을 생성한다. 
//	= int[] score = new int[5];
	 score[3] = 100;
	 System.out.println(score[3]);
	 int value = score[3];
	 System.out.println(value);

// 배열의 인덱스 = 각 요소에 자동으로 붙는 일련번호

// 배열의 길이	 
//	 = 배열이름.length => int형 상수임
//	 배열은 한번 생성하면 
//	 실행하는 동안 그 길이를 바꿀 수 없다.
//	 따라서 배열은 상수이다.
	 
	 int[] arr = new int[10];
	 arr[3] = 100;
	 System.out.println(arr.length);
	 for(int i=0; i<arr.length; i++) {
		 System.out.println("arr["+i+"]"+"="+arr[i]);
	 }
		 
// 배열의 초기화
//	 배열을 중괄호로 처리하면 자동으로 초기화를 해줌 
	 int[] num = {50, 60, 70, 80, 90};
	 System.out.println(num[0]);
	 
// 배열의 출력
	 int[] number = {50, 60, 70, 80, 90};
//	 모든 값을 출력하려면?!
//	 배열의 모든 변수를 출력하려면 for문을 활용해야한다.
	 for(int i=0; i<number.length; i++) {
		 System.out.println(number[i]);
// 또는 Arrays.toString 클래스를 활용한다.
	 }
	 System.out.println(Arrays.toString(number));
	 
 }
}
