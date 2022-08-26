package FirstStudy.src;// 1. Java�� ���ϻ�Ӹ� ����ϰ� �ִ�.

// 2. ���� ���� Ŭ���� �ϳ��� ��Ӱ���� �ϰ�,
// 	  �������� ���԰���� �Ѵ�.

// 3. �θ� ���� Ŭ������ �ڵ������� 
// 	  ObjectŬ������ ��ӹް� �ȴ�.

// 4. ��� Ŭ������ ObjectŬ������ ���ǵ� 11���� �޼��带
//    ��ӹ޴´�

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
