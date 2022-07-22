package org.Java.Day6;

class Day6Activity2 {
	public static void main(String[] args) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		System.out.println("t1의 값"+t1.channel);
		System.out.println("t1의 값"+t2.channel);
		
		t1.channel = 6;
		System.out.println("t1의 값을 6으로 변경함");
		
		t2 = t1;
		System.out.println("t1의 값"+t1.channel);
		System.out.println("t1의 값"+t2.channel);
				
	}
}
