package Day13pkg2;
//	private 같은 클래스 내에서만 접근이 가능하다
//	default 같은 패키지 내에서만 접근 가능
//	protected 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근가능
//	public 접근 제한이 없다.

import Day13.Day13Activity1pk1;

class  MyChild extends Day13Activity1pk1 {
	public void printMenbers() {
//	System.out.println(prv);
//	System.out.println(dft); 다른 패키지
	System.out.println(prt);
	System.out.println(pub);
	}
}

public class Day13Activity2pk2 {
	public static void main(String[] args) {
		Day13Activity1pk1 p = new Day13Activity1pk1();
//		System.out.println(p.prv);
//		System.out.println(p.dft);
//		System.out.println(p.prt); 자손클래스 
		System.out.println(p.pub);
	}
}
