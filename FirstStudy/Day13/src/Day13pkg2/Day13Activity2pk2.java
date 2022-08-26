package Day13pkg2;
//	private ���� Ŭ���� �������� ������ �����ϴ�
//	default ���� ��Ű�� �������� ���� ����
//	protected ���� ��Ű�� ������, �׸��� �ٸ� ��Ű���� �ڼ�Ŭ�������� ���ٰ���
//	public ���� ������ ����.

import FirstStudy.Day13.Day13Activity1pk1;

class  MyChild extends Day13Activity1pk1 {
	public void printMenbers() {
//	System.out.println(prv);
//	System.out.println(dft); �ٸ� ��Ű��
	System.out.println(prt);
	System.out.println(pub);
	}
}

public class Day13Activity2pk2 {
	public static void main(String[] args) {
		Day13Activity1pk1 p = new Day13Activity1pk1();
//		System.out.println(p.prv);
//		System.out.println(p.dft);
//		System.out.println(p.prt); �ڼ�Ŭ���� 
		System.out.println(p.pub);
	}
}
