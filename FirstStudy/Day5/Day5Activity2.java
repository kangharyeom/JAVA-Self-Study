package FirstStudy.Day5;

import java.util.Arrays;


class Day5Activity2 {
 public static void main(String[] args) {
	 int[] iArr = {100,90,80,70,60};
	 for(int i=0; i<iArr.length; i++) {
		 System.out.println(iArr[i]); 
	 }
	 System.out.println(Arrays.toString(iArr));
	 
// ������ Ȱ���غ���
//	 �迭�� ���հ� ����� ���غ���
	 int sum = 0; //������ �־��� ����
	 float avg = 0f; //����� ������� ����
	 int[] score = {10,20,30,40,50,60,70,80,90};
	 
	 for(int i=0; i<score.length; i++){
		sum += score[i]; 
	 }
	 avg = sum / (float)score.length;
	 
	 System.out.println(sum);
	 System.out.println(avg);
	 
// �������� �迭 ����
	 int[] numarr = {0,1,2,3,4,5,6,7,8,9};
	 for(int i=0; i<100; i++) {
		 int n = (int)(Math.random()*10);
		 int tmx = numarr[0];
		 numarr[0] = numarr[n];
		 numarr[n] = tmx;
	 }
	 System.out.println(Arrays.toString(numarr));
 }
}
