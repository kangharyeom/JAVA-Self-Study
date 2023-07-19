package FirstStudy.Day9;

class Mathod5{int x;}

public class Day9Activity2 {
	public static void main(String[] args) {
		Mathod5 Math2 = new Mathod5();
		Math2.x = 10;
		System.out.println(Math2.x);
		change(Math2);
		System.out.println("change(Math2)");
	}
	static void change(Mathod5 Math2) {
		Math2.x =11000;
		System.out.println(Math2.x);
	}
}
