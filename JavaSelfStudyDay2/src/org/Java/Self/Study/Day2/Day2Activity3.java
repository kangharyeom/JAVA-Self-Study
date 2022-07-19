package org.Java.Self.Study.Day2;

class Day2Activity3 {
	public static void main(String[] args) {
// 1. 변수 상수 리터럴		
// 변수 (ex: int = 100 ) = 하나의 값을 저장하기 위한 공간
// 상수 (ex: final int = 100) = 한 번만 값을 저장 가능한 변수 
// 리터럴	= 값을 의미하는 것
		final int Max = 20;
		int Score = 100;
		Score = 200;
		
		System.out.println(Score+Max);
// 변수를 선언한 이후에 재 선언을 하면 후기값으로 처리된다
// final(상수)을 선언 한 이후에 값을 변경하면 에러가 발생한다.
	
//  2.  리터럴의 접두사와 접미사
//	정수형 = L
			long Long = 100L;
			System.out.println(Long);
//  실수형 = f,d
			double Double = 3.141592d;
			float Float = 1.1345f;
			System.out.println(Double);
			System.out.println(Float);
//	문자형 = ''(작은 따옴표)
			char ch = 'A';
			System.out.println(ch);
//	문자열 = ""(큰 따옴표)
			String str = "ABC";
			System.out.println(str);
			
//	논리형 = false, true
			boolean kang = true;
			System.out.println(kang);
			
		int oct = 010; //접두사가 0이면 8진수로 처리됨
		int hex = 0x10; //접두사다 0x면 16진수로 처리됨
			System.out.println(oct);
			System.out.println(hex);
	}
}