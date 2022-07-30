// 참조변수 SUPER (= this변수랑 비슷함)
// 객체 자신을 가리키는 참조변수, 
// 인스턴스 메서드(생성자)내에서만 존재
// 조상멤버와 자신의 멤버를 구별한다.



public class Day12Activity2 {
	public static void main(String[] args) {
		Child2 c =new Child2();
		c.mathod();
		
	}
}

class Parent2 { int x = 10;}
//super.x와 this.x 둘다 가능

class Child2 extends Parent2{
	
	void mathod() {
		System.out.println(x);
		System.out.println(this.x); // 자식 
		System.out.println(super.x); // 조상
	}
}
// 자손의 생성자는 자신이 선언한 것만 초기화 해야한다.