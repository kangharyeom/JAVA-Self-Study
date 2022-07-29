// 상속과 포함
// 대부분 포함을 많이 사용하며
// 클래스의 재사용을 통해 코딩을 간결하게 할 수 있다.


class Myday11 {
	int x;
	int y;
	
}
class Myday12 extends Myday11 {
	int r;
}

public class Day11Activity1 {
	public static void main(String[] args) {
		Myday12 myday =new Myday12();
		myday.x=11;
		myday.y=13;
		myday.r=15;
		System.out.println(myday.x);
		System.out.println(myday.y);
		System.out.println(myday.r);
		
	}
}
