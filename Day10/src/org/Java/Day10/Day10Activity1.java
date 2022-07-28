package org.Java.Day10;

import java.sql.Time;



public class Day10Activity1 {
	public static void main(String[] args) {
// 인스턴트 메서드 = 참조변수.매서드이름 = 
// 클래스 매서드 = 클래스이름.매서드이름 = static  
	
// 오버로딩(과적)이란?
//	한 클래스 안에 같은 이름의 매서드를 여러 개 정의하는 것
//	= 과적하는 것
//	조건  = 
//		1. 매서드 이름이 갇아야 한다.
//		2. 매개변수의 개수 또는 타입이 달라야한다.
//		3. 반환 타입은 영향이 없다.
	
// 생성자란?
//	인스턴스가 생설될 깨마다 호출되는 '인스턴스 초기화 매서드'
	Time t = new Time();
	t.hour = 12;
	t.minute = 15;
	t.second = 11;
	System.out.println(t);
	
	
		
	}
}
	class Time {
		int hour = 12;
		int minute = 12;
		int second = 12;
		
	}