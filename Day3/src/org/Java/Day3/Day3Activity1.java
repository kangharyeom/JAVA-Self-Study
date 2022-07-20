package org.Java.Day3;

public class Day3Activity1 {
	public static void main(String[] args) {
// 형변환 실습
		String str = "5";
		System.out.println(str.charAt(0)- '0');
//		문자열 "5"를 문자형으로 변환 
		System.out.println('5' - '0'+1);
		System.out.println('5' - '1');
//		문자형 '5'와 문자형 '1'이 결합 
		System.out.println(1+"5");
//		숫자 1과 문자열 5를 결합 => 1과 5가 출력
		System.out.println(Integer.parseInt("5")+1);
//		문자열 "5"를 int(정수)타입으로 형변환 이후 숫자 1을 더함 6출력
		System.out.println("5"+1);
//		문자열 "5"와 숫자 1이 결합 => 5와 1이 출력되어 51
		System.out.println(5+ '0');
//		숫자 5와 문자 0의 고유번호 48이 결합되어 53 출력
		
		
	}
}
