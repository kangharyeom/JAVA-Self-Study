package org.Java.Self.Study.Day2;

class Day2Activity3 {
	public static void main(String[] args) {
// 1. ���� ��� ���ͷ�		
// ���� (ex: int = 100 ) = �ϳ��� ���� �����ϱ� ���� ����
// ��� (ex: final int = 100) = �� ���� ���� ���� ������ ���� 
// ���ͷ�	= ���� �ǹ��ϴ� ��
		final int Max = 20;
		int Score = 100;
		Score = 200;
		
		System.out.println(Score+Max);
// ������ ������ ���Ŀ� �� ������ �ϸ� �ıⰪ���� ó���ȴ�
// final(���)�� ���� �� ���Ŀ� ���� �����ϸ� ������ �߻��Ѵ�.
	
//  2.  ���ͷ��� ���λ�� ���̻�
//	������ = L
			long Long = 100L;
			System.out.println(Long);
//  �Ǽ��� = f,d
			double Double = 3.141592d;
			float Float = 1.1345f;
			System.out.println(Double);
			System.out.println(Float);
//	������ = ''(���� ����ǥ)
			char ch = 'A';
			System.out.println(ch);
//	���ڿ� = ""(ū ����ǥ)
			String str = "ABC";
			System.out.println(str);
			
//	���� = false, true
			boolean kang = true;
			System.out.println(kang);
			
		int oct = 010; //���λ簡 0�̸� 8������ ó����
		int hex = 0x10; //���λ�� 0x�� 16������ ó����
			System.out.println(oct);
			System.out.println(hex);
	}
}