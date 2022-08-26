package FirstStudy.Day4;

import java.util.Scanner;

import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Day4Activity1 {

	public static void main(String[] args) {
// ��� = ���ǹ�, �ݺ���
//		���ǹ� = if�� 
		
//	x�� ���� ���
		int x = 30;
		if(x>25) {
			System.out.println("�հ��Դϴ�.");
		}
		
//	x�� ������ ���
		if(x<25) {
			System.out.println("�հ��Դϴ�.");
		}
		System.out.println("���հ��Դϴ�.");

//	�Ǵ� if else�� Ȱ���Ͽ�
		if(x<25) {
			System.out.println("�հ��Դϴ�.");
		} else {
		System.out.println("���հ�");
		}
		
// if else if�� = ����� ���� ������ �̻��� ���
		if(x<24) {
			System.out.println("�հ��Դϴ�");
		} else if(x<26) {
			System.out.println("�հ��Դϴ�");
		} else if(x<29) {
			System.out.println("�հ��Դϴ�");
		} else {
			System.out.println("�հ��� �ƴմϴ�.");
		}
		
// ���� �ǵ��⸦ ������ 
		int score = 0; //���� ����
		char grade = ' '; //����, ������ �־� �ʱ�ȭ�Ѵ�.
		
		System.out.println("������ �Է����ּ��� =>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		if (score>=90) {
			grade = 'A';
		} else if (score>=80) {
			grade = 'B';				
		} else if (score>=70){
			grade = 'C';
		} else {
			grade = 'D';
		}
		System.out.println("������"+ grade + "�Դϴ�.");
	}		
}
