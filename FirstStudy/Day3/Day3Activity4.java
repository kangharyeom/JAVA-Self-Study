package FirstStudy.Day3;

import javax.naming.spi.DirStateFactory.Result;

class Day3Activity4 {
	public static void main(String[] args) {
// �ݿø� - Math.round()
// ex)	long result = Math.round(4.52);
		double pi = 3.141592;
		double shortPi = Math.round(pi*10000)/10000.0;
		System.out.println(shortPi);
// 3.141�� ����ϰ� �غ���
		double piTwo = 3.141592;
		System.out.println((int)(piTwo*1000) /1000.0);

// ������ ������ 
		int x = 10, y = 8;
		System.out.println(x%y);

// �񱳿����� (���ڿ��� �񱳴� equals()�� ����Ѵ�.)
		String str1 = "Aaron";
		String str2 = "Aaron";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
// �������� 
//	���ǽ��� ������ �� ����ϴ� ������
		
// ���� ������ 
// ���ǽ��� ����� ���� �������� �޸��Ѵ�. 
	int result = (x>y) ? x : y;
	System.out.println(result);
	
// ���� ���� ������
//		(i +=3;) = (i = i +3;)
	}
}
