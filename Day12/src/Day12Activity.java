// �������� SUPER (= this������ �����)
// ��ü �ڽ��� ����Ű�� ��������, 
// �ν��Ͻ� �޼���(������)�������� ����
// �������� �ڽ��� ����� �����Ѵ�.



public class Day12Activity {
	public static void main(String[] args) {
		Child1 c =new Child1();
		c.mathod();
		
	}
}

class Parent { int x = 10;}
class Child1 extends Parent{
	int x = 20;
	void mathod() {
		System.out.println(x);
		System.out.println(this.x); // �ڽ� 
		System.out.println(super.x); // ����
	}
}