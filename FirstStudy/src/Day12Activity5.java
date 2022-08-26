// import문
//	 클래스를 사용할 때 패키지 이름을 생략할 수 있다.
//	 단축키 ctrl+shift+o
//	 java.lang 패키지의 클래스는 import하지 않고도
//   사용할 수 있다.


// import문의 선언
//  import 패키지명.클래스명;
//  or import 패키지명.*;

// import문은 패키지문과 클래스선언의 사이에 선언한다.
// import문은 컴파일시에 처리되므로 프로그램의 성능에 영향없음

// static import문
// static 멤버를 사용할 때 클래스 이름을 생략 할 수 있게 해준다.

// 제어자(modifier)
// 클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여

//	접근제어자 
//	= public, protected, default, private
//	= 한가지만 사용 할 수 있다.(함께 쓸 수 없음)

//	그 외		
//	= static, final, abstract

// ex) public static final
//     접근제어자  제어자  제어자

// static (=클래스의, 공통적인)
//   static int with = 200 = iv 앞에 붙으면 cv가 된다. = 클래스 변수
//   static{} = 클래스의 초기화를 한다. 
//   static int max(int a) = 클래스 메서드
// 특징 1. 객체 생성없이 사용가능 = 객체를 필요로하는 iv와 instance method에서는 사용할 수 없다.

// final (=마지막의, 변경될 수 없는)
// 특징 1. 다른 클래스의 조상이 될 수 없다. = 확장될 수 없다.
//     3. 오버라이딩 할 수 없다. = 오버라이딩 할 수 없는 메서드
//	   2. 값을 변경할 수 없는 상수다. = 멤버변수,지역변수(=상수)

// abstract (=추상의, 미완성의)
// 특징 1. 클래스 내에 추상 메서드가 선언되어있다.
//     2. 메서드 -> 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드가 된다.
// ex) abstract class Abstact{
//		abstract void move();
// 따라서 추상메서드를 가지고 있으면 추상 클래스다.
// 추상클래스는 인스턴스를 생성할 수 없다. 



public class Day12Activity5 {
	public static void main(String[] args) {
	
	}
}
