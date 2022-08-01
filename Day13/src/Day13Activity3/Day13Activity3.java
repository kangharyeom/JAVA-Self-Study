package Day13Activity3;
// 접근제어자를 사용하는 이유
//  외부로부터 데이터를 보호하기 위해서
//	외부에서는 불필요하지만 내부적으로만 사용되는 부분을 감추기 위해서

class Time {
 private int hour;
 private int minute;
 private int second;

 public void sethour(int hour) {
	 if(hour <0 || hour >23)return;
	 this.hour = hour;
 }
 public int gethour() {return hour;};
}

public class Day13Activity3 {
	public static void main(String[] args) {
		Time t = new Time();
//		t.hour = 24;
//		t.minute = 60;
//		t.second = 60;
		t.sethour(4);
		System.out.println(t.gethour());
	}
}
