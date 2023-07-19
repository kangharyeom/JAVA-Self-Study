package FirstStudy.Day5;

import java.util.Arrays;
import java.util.Iterator;


class Day5Activity3 {
 public static void main(String[] args) {
// String �迭�� ����� ����
//	 String�� �������̸� �⺻���� null�̴�
	 
//	 ���� ���� �� ������ ������
	 String[] name = {"����", "����", "��"};
	 for(int i=0; i<10; i++) {
		 int tmx = (int)(Math.random()*3);
		 System.out.println(name[tmx]);
	 }
	 
// 2���� �迭
//	 ���̺� ����(����X�ٿ�)�� �����͸� �����ϱ� ���� �迭

// ex) int[][] score = new int[4][3]; 
//	                           ��,��
	 
	int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},
			{40,40,40}	
	};
	int sum = 0;
	for (int i=0; i<score.length; i++) {
		for(int j=0; j<score[i].length; j++) {
			System.out.printf("score[%d][%d]=[%d]%n",i,j,score[i][j]);
		sum+=score[i][j];
		}
	}
	System.out.println(sum);
	
// 1�г� 1�� �б⺰ ���� ����
	int[][] total = {
						{98,73,83,91},
						{54,56,78,81},
						{34,55,68,75},
						{12,45,32,76},
						{34,57,85,98}
	};
//	�б⺰ ����
	int first = 0, second = 0, third = 0, fourth = 0;
	System.out.println("��ȣ   1�б�  2�б�  3�б�  4�б�  ����  ���");
	for(int i=0; i<total.length; i++) {
		int sum1 = 0;
		float avg = 0.0f;
			first += total[i][0];
			second += total[i][1];
			third += total[i][2];
			fourth += total[i][3];
			System.out.printf("%3d", i+1);

			for(int j=0; j< total[i].length;j++) {
				sum1 += total[i][j]; 
				System.out.printf("%6d", total[i][j]);
			}

			avg = sum1/(float)total[i].length;  // ��հ��
			System.out.printf("%5d %5.1f%n", sum1, avg);
		}

		System.out.println("=============================");
     	System.out.printf("����:%5d %5d %5d %5d %n", first, second, third,fourth);
		}
	
}

