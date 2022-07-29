// 오버라이딩(overriding)
// 	상속받은 조상의 메서드를 자신에 맞게 변경하는것

class Point{
	int x;
	int y;
	String getlocation() {
		return "x;"+x+",y:"+y;
	}
}
class Point3D extends Point{
	int z;
//	조상을 오버라이딩
	String getlocation() {
		return "x;"+x+",y:"+y+",z"+z;
	}
}

public class Day11Activity3 {
	public static void main(String[] args) {
		Point3D p = new Point3D();
		p.x = 3;
		p.y = 4;
		p.z = 5;
		System.out.println(p.x);
		System.out.println(p.y);
		System.out.println(p.z);
	}
}
