package org.Java.Day3;

class Day3Activity3 {
	public static void main(String[] args) {
// 산술 변환
		int a = 20000000;
		int b = 10000000;
		long c = a*b;
		System.out.println(c);
// long 범위를 벗어나면 원하는 값이 아닌 int의 최댓값이 출력된다.
		int d = 20000000;
		int e = 10000000;
		long f = (long)d*e;
		System.out.println(f);
// long타입으로 형변환을 해주어 제대로된 값을 출력한다.
	}
}
