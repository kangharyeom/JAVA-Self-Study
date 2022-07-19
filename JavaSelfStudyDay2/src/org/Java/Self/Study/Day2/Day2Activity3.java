package org.Java.Self.Study.Day2;

class Day2Activity3 {
	public static void main(String[] args) {
// 변수 (ex: int = 100 ) = 하나의 값을 저장하기 위한 공간
// 상수 (ex: final int = 100) = 한 번만 값을 저장 가능한 변수 
// 리터럴	= 값을 의미하는 것
		final int Max = 20;
		int Score = 100;
		Score = 200;
		
		System.out.println(Score+Max);
// 변수를 선언한 이후에 재 선언을 하면 후기값으로 처리된다
// final(상수)을 선언 한 이후에 값을 변경하면 에러가 발생한다.
		
	}
}