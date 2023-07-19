package FirstStudy.Day5;

import java.util.Arrays;

public class Day5Activity1 {
 public static void main(String[] args) {
// �迭 
//	 =���� Ÿ���� ������ �ϳ��� �������� �ٷ�� ��
	 
// �迭�� ���� - �迭�� �ٷ�� ���� ���������� ����
// �迭�� �����ϱ� ���� ���
//	 Ÿ��[] �����̸� = ex) int[] score;
//	 					String[] name;
//OR Ÿ�� �����̸�[] = ex) int score[];
//	 					String name[];
	 
	 int[] score; // 1. �迭�� �����Ѵ�.
	 score = new int[5]; // 2. �迭�� �����Ѵ�. 
//	= int[] score = new int[5];
	 score[3] = 100;
	 System.out.println(score[3]);
	 int value = score[3];
	 System.out.println(value);

// �迭�� �ε��� = �� ��ҿ� �ڵ����� �ٴ� �Ϸù�ȣ

// �迭�� ����	 
//	 = �迭�̸�.length => int�� �����
//	 �迭�� �ѹ� �����ϸ� 
//	 �����ϴ� ���� �� ���̸� �ٲ� �� ����.
//	 ���� �迭�� ����̴�.
	 
	 int[] arr = new int[10];
	 arr[3] = 100;
	 System.out.println(arr.length);
	 for(int i=0; i<arr.length; i++) {
		 System.out.println("arr["+i+"]"+"="+arr[i]);
	 }
		 
// �迭�� �ʱ�ȭ
//	 �迭�� �߰�ȣ�� ó���ϸ� �ڵ����� �ʱ�ȭ�� ���� 
	 int[] num = {50, 60, 70, 80, 90};
	 System.out.println(num[0]);
	 
// �迭�� ���
	 int[] number = {50, 60, 70, 80, 90};
//	 ��� ���� ����Ϸ���?!
//	 �迭�� ��� ������ ����Ϸ��� for���� Ȱ���ؾ��Ѵ�.
	 for(int i=0; i<number.length; i++) {
		 System.out.println(number[i]);
// �Ǵ� Arrays.toString Ŭ������ Ȱ���Ѵ�.
	 }
	 System.out.println(Arrays.toString(number));
	 
 }
}
