package FirstStudy.Day13;
// �������� ����
// 1) ������ �Ű�����
// 2) �ϳ��� �迭�� ���������� ��ü�� �ٷ� �� �ִ�.

//�Ű������� ������
// ������ �Ű������� �ż��� ȣ���, �ڽŰ� ���� Ÿ�� �Ǵ� 
// �ڼ�Ÿ���� �ν��Ͻ��� �Ѱ��� �� �ִ�. 
class Product {
	int price;			// ��ǰ�� ����
	int bonusPoint;	// ��ǰ���� �� �����ϴ� ���ʽ�����

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);	// ���ʽ������� ��ǰ������ 10%
	}
}

class Tv1 extends Product {
	Tv1() {
		// ����Ŭ������ ������ Product(int price)�� ȣ���Ѵ�.
		super(100);		// Tv�� ������ 100�������� �Ѵ�.
	}

	// ObjectŬ������ toString()�� �������̵��Ѵ�.
	public String toString() { return "Tv"; }
}

class Computer extends Product {
	Computer() { super(200); }

	public String toString() { return "Computer"; }
}

class Buyer {	// ��, ������ ��� ���
	int money = 1000;	  // �����ݾ�
	int bonusPoint = 0; // ���ʽ�����

	void buy(Product p) {
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}

		money -= p.price;            // ���� ������ ������ ��ǰ�� ������ ����.
		bonusPoint += p.bonusPoint;  // ��ǰ�� ���ʽ� ������ �߰��Ѵ�.
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
}

class Day13Activity6 {
	public static void main(String[] args) {
		Buyer b = new Buyer();

		b.buy(new Tv1());
		b.buy(new Computer());

		System.out.println("���� ���� ���� " + b.money + "�����Դϴ�.");
		System.out.println("���� ���ʽ������� " + b.bonusPoint + "���Դϴ�.");
	}
}
