// �������� SUPER (= this������ �����)
// ��ü �ڽ��� ����Ű�� ��������, 
// �ν��Ͻ� �޼���(������)�������� ����
// �������� �ڽ��� ����� �����Ѵ�.



public class Day12Activity2 {
	public static void main(String[] args) {
		Child2 c =new Child2();
		c.mathod();
		
	}
}

class Parent2 { int x = 10;}
//super.x�� this.x �Ѵ� ����

class Child2 extends Parent2{
	
	void mathod() {
		System.out.println(x);
		System.out.println(this.x); // �ڽ� 
		System.out.println(super.x); // ����
	}
}
// �ڼ��� �����ڴ� �ڽ��� ������ �͸� �ʱ�ȭ �ؾ��Ѵ�.