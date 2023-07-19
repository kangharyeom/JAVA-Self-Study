package org.Java.Self.Study.Day2;

class Day2Activity4 {
	public static void main(String[] args) {
		System.out.println(10/3);
//		정수/정수 이기 때문에 실수/정수로 바꿔줘야 한다.
		System.out.println(10.0/3);
		System.out.printf("%f\n", 10.0/3);
//		%b = boolean 형식으로 출력
//		%d = 10진 정수의 형식으로 출력
//		%o = 8진 정수의 형식으로 출력
//		%x, %X = 16진 정수의 형식으로 출력
//		%f = 부동 소수점(floating-point)의 형식으로 출력
//		%e, %E = 지수(exponent) 표현식의 형식으로 출력
//		%c = 문자로 출력
//		%s = 문자열로 출력
//		%n = 줄바꿈 (=\n)
		System.out.printf("%d%n", 15); // 10진수
		System.out.printf("%o%n", 15); // 8진수
		System.out.printf("%x%n", 15); // 16진수
	}
}