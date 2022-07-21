package org.Java.Day4;

class Day4Activity4 {

	public static void main(String[] args) {
// 반복문 = for문과 while문
// for문
// ex) for(int i=1; i<5; i++)
// =   for(  초기화; 조건식;증감식)
		for(int i=1; i<=10; i=i*2){
		System.out.println("hello"+i);}

// 반복 중첩문
//	구구단 
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
		
// 단순 중첩 반복
		for(int i=1; i<10; i++){
			for(int j=1; j<10; j++) {
				System.out.print("$");
			}
			System.out.println();
		}

// J값이 증가하는 중첩반복
		for(int i=1; i<=10; i++){
			for(int j=1; j<=i; j++) { //조건문에 i값을 대입
				System.out.print("$");
			}
			System.out.println();
		}

		
	}
}
