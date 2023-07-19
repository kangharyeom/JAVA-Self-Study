package FirstStudy.Day6.src.org.Java.Day6;

class Day6Activity2 {
	public static void main(String[] args) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		System.out.println("t1�� ��"+t1.channel);
		System.out.println("t1�� ��"+t2.channel);
		
		t1.channel = 6;
		System.out.println("t1�� ���� 6���� ������");
		
		t2 = t1;
		System.out.println("t1�� ��"+t1.channel);
		System.out.println("t1�� ��"+t2.channel);
				
	}
}
