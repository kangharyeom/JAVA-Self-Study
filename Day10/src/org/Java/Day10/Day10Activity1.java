package org.Java.Day10;

import java.sql.Time;



public class Day10Activity1 {
	public static void main(String[] args) {
// �ν���Ʈ �޼��� = ��������.�ż����̸� = 
// Ŭ���� �ż��� = Ŭ�����̸�.�ż����̸� = static  
	
// �����ε�(����)�̶�?
//	�� Ŭ���� �ȿ� ���� �̸��� �ż��带 ���� �� �����ϴ� ��
//	= �����ϴ� ��
//	����  = 
//		1. �ż��� �̸��� ���ƾ� �Ѵ�.
//		2. �Ű������� ���� �Ǵ� Ÿ���� �޶���Ѵ�.
//		3. ��ȯ Ÿ���� ������ ����.
	
// �����ڶ�?
//	�ν��Ͻ��� ������ ������ ȣ��Ǵ� '�ν��Ͻ� �ʱ�ȭ �ż���'
	Time t = new Time();
	t.hour = 12;
	t.minute = 15;
	t.second = 11;
	System.out.println(t);
	
	
		
	}
}
	class Time {
		int hour = 12;
		int minute = 12;
		int second = 12;
		
	}