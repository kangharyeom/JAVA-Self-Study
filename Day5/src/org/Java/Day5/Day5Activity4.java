package org.Java.Day5;

import java.util.Arrays;
import java.util.Iterator;


class Day5Activity4 {
 public static void main(String[] args) {
// String 클래스는 char[]와 매서드를 결합한것
//	 String 클래스 = char[] + 매서드(기능)
//	 읽기만 가능하기 때문에 내용을 변경 할 수 없다
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

