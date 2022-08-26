package FirstStudy.Day13;
//	private ���� Ŭ���� �������� ������ �����ϴ�
//	default ���� ��Ű�� �������� ���� ����
//	protected ���� ��Ű�� ������, �׸��� �ٸ� ��Ű���� �ڼ�Ŭ�������� ���ٰ���
//	public ���� ������ ����.


public class Day13Activity1pk1 {
	private int prv;
			int dft;
	protected	int prt;
	public 	int pub;
	public void printMembers() {
	System.out.println(prv);
	System.out.println(dft);
	System.out.println(prt);
	System.out.println(pub);
	
	}
}

 class Myprent {
	public static void main(String[] args) {
		Day13Activity1pk1 p = new Day13Activity1pk1();
//		System.out.println(p.prv);
		System.out.println(p.dft);
		System.out.println(p.prt);
		System.out.println(p.pub);
	}
}
