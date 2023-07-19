package FirstStudy.src;// ��Ӱ� ����
// ��κ� ������ ���� ����ϸ�
// Ŭ������ ������ ���� �ڵ��� �����ϰ� �� �� �ִ�.


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
