package org.Java.Self.Study.Day2;

class Day2Activity4 {
	public static void main(String[] args) {
		System.out.println(10/3);
//		����/���� �̱� ������ �Ǽ�/������ �ٲ���� �Ѵ�.
		System.out.println(10.0/3);
		System.out.printf("%f\n", 10.0/3);
//		%b = boolean �������� ���
//		%d = 10�� ������ �������� ���
//		%o = 8�� ������ �������� ���
//		%x, %X = 16�� ������ �������� ���
//		%f = �ε� �Ҽ���(floating-point)�� �������� ���
//		%e, %E = ����(exponent) ǥ������ �������� ���
//		%c = ���ڷ� ���
//		%s = ���ڿ��� ���
//		%n = �ٹٲ� (=\n)
		System.out.printf("%d%n", 15); // 10����
		System.out.printf("%o%n", 15); // 8����
		System.out.printf("%x%n", 15); // 16����
	}
}