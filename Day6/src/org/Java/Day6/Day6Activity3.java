package org.Java.Day6;

class Day6Activity3 {
	public static void main(String[] args) {
//클래스 변수와 인스턴스
//	iv = 개별적인 특성을 갖는 인스턴스 
//	cv = 공통적인 특성을 갖는 인스턴스 
//		(클래스 이름을 사용해서 코딩하는걸 권장)
		
// 카드게임을 만든다고 가정해보자
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);

		Card c1 = new Card();
		c1.kind = "Heart"; //iv
		c1.number = 7; // 개별적인 특징을 갖기 때문에 iv

		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;

		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		c1.width = 50;
		c1.height = 80;

		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
	}
}

class Card {
	String kind;
	int number;
	static int width = 100; //카드의 폭은 공통적이어야 하므로 cv변수 
	static int height = 250; // cv변수
		
}
// 예제를 그대로 따라한 것 객체지향에 대해서 좀 더 심고 깊게 고민해봐야겠다.
