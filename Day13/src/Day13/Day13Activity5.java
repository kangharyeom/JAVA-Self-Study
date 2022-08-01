package Day13;

class Day13Activity5 {
	public static void main(String[] args) {
		Car car = new Car();
		FireEngine fe2 = (FireEngine)car;
		fe2.stop();
	}
}

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("dirve");
	}
	void stop() {
		System.out.println("stop");
	}
}
class FireEngine extends Car{
		String color;
		int door;
		
		void drive() {
			System.out.println("dirve2");
		}
		void stop() {
			System.out.println("stop2");
		}
}