package org.Java.Day3;

import javax.naming.spi.DirStateFactory.Result;

class Day3Activity4 {
	public static void main(String[] args) {
// 반올림 - Math.round()
// ex)	long result = Math.round(4.52);
		double pi = 3.141592;
		double shortPi = Math.round(pi*10000)/10000.0;
		System.out.println(shortPi);
// 3.141만 출력하게 해보자
		double piTwo = 3.141592;
		System.out.println((int)(piTwo*1000) /1000.0);

// 나머지 연산자 
		int x = 10, y = 8;
		System.out.println(x%y);

// 비교연산자 (문자열의 비교는 equals()를 사용한다.)
		String str1 = "Aaron";
		String str2 = "Aaron";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
// 논리연산자 
//	조건식을 연결할 때 사용하는 연산자
		
// 조건 연산자 
// 조건식의 결과에 따라 연산결과를 달리한다. 
	int result = (x>y) ? x : y;
	System.out.println(result);
	
// 복합 대입 연산자
//		(i +=3;) = (i = i +3;)
	}
}
