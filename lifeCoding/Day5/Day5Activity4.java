package FirstStudy.Day5;

import java.util.Arrays;
import java.util.Iterator;


class Day5Activity4 {
 public static void main(String[] args) {
// String Ŭ������ char[]�� �ż��带 �����Ѱ�
//	 String Ŭ���� = char[] + �ż���(���)
//	 �б⸸ �����ϱ� ������ ������ ���� �� �� ����
	 String str = "ABCDE";
	 char ch = str.charAt(2);
	 String str2 = str.substring(1,4);
	 String str3 = str.substring(1);
	 String str4 = str.substring(0,str.length());
	 System.out.println(ch);
	 System.out.println(str2);
	 System.out.println(str3);
	 System.out.println(str4);
 
 }
	
}

