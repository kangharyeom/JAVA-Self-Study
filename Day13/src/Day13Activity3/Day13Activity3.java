package Day13Activity3;
// ���������ڸ� ����ϴ� ����
//  �ܺηκ��� �����͸� ��ȣ�ϱ� ���ؼ�
//	�ܺο����� ���ʿ������� ���������θ� ���Ǵ� �κ��� ���߱� ���ؼ�

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
