package FirstStudy.Day6.src.org.Java.Day6;

class Day6Activity3 {
	public static void main(String[] args) {
//Ŭ���� ������ �ν��Ͻ�
//	iv = �������� Ư���� ���� �ν��Ͻ� 
//	cv = �������� Ư���� ���� �ν��Ͻ� 
//		(Ŭ���� �̸��� ����ؼ� �ڵ��ϴ°� ����)
		
// ī������� ����ٰ� �����غ���
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);

		Card c1 = new Card();
		c1.kind = "Heart"; //iv
		c1.number = 7; // �������� Ư¡�� ���� ������ iv

		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;

		System.out.println("c1�� " + c1.kind + ", " + c1.number + "�̸�, ũ��� (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2�� " + c2.kind + ", " + c2.number + "�̸�, ũ��� (" + c2.width + ", " + c2.height + ")");
		System.out.println("c1�� width�� height�� ���� 50, 80���� �����մϴ�.");
		c1.width = 50;
		c1.height = 80;

		System.out.println("c1�� " + c1.kind + ", " + c1.number + "�̸�, ũ��� (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2�� " + c2.kind + ", " + c2.number + "�̸�, ũ��� (" + c2.width + ", " + c2.height + ")");
	}
}

class Card {
	String kind;
	int number;
	static int width = 100; //ī���� ���� �������̾�� �ϹǷ� cv���� 
	static int height = 250; // cv����
		
}
// ������ �״�� ������ �� ��ü���⿡ ���ؼ� �� �� �ɰ� ��� ����غ��߰ڴ�.
