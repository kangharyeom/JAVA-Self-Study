// 1. Java는 단일상속만 허용하고 있다.

// 2. 비중 높은 클래스 하나만 상속관계로 하고,
// 	  나머지는 포함관계로 한다.

// 3. 부모가 없는 클래스는 자동적으로 
// 	  Object클래스를 상속받게 된다.

// 4. 모든 클래스는 Object클래스에 정의된 11개의 메서드를
//    상속받는다

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
