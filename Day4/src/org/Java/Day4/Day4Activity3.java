package org.Java.Day4;

class Day4Activity3 {

	public static void main(String[] args) {
// 난수 만들기 = Math.random()
//  게임이나 섞기에 많이 사용됨
// 1~30 사이의 난수를 20개 출력하시오
		int num = 0;
		for (int i=0; i<=20; i++) {
			System.out.println((int)(Math.random()*30)+1);
		}
	
	}
}
