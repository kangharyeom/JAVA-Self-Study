// ��Ӱ� ����
// ��κ� ������ ���� ����ϸ�
// Ŭ������ ������ ���� �ڵ��� �����ϰ� �� �� �ִ�.


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
