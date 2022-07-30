// 참조변수 SUPER (= this변수랑 비슷함)
// 객체 자신을 가리키는 참조변수, 
// 인스턴스 메서드(생성자)내에서만 존재
// 조상멤버와 자신의 멤버를 구별한다.



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
		System.out.println(this.x); // 자식 
		System.out.println(super.x); // 조상
	}
}