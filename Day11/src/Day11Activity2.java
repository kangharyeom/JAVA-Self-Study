// 상속과 포함
// 대부분 포함을 많이 사용하며
// 클래스의 재사용을 통해 코딩을 간결하게 할 수 있다.


class Myday20 {
	int x;
	int y;
	
}
class Myday30  {
	Myday20 m = new Myday20();
	int r;
}

public class Day11Activity2 {
	public static void main(String[] args) {
		Myday30 myday =new Myday30();
		myday.m.x=11;
		myday.m.y=13;
		myday.r=15;
		System.out.println(myday.m.x);
		System.out.println(myday.m.y);
		System.out.println(myday.r);
		
	}
}
