package FirstStudy.Day8.src.org.Java.Day8;

public class Day8Activity1 {
	public static void main(String[] args) {
//�޼��� ȣ��
		Mathod Math = new Mathod();
		long result1 = Math.add(5L,1L);
		long result2 = Math.substract(5L,1L);
		long result3 = Math.multiply(5L,1L);
		long result4 = Math.divide(5L,1L);
		long result5 = Math.max(5L,1L);
		long result6 = Math.min(5L,1L);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		
	}
}
class Mathod {
	long add(long a, long b) {
		long result = a+b;
		return result;
	}
	long substract(long a, long b) {return a-b;}
	long multiply(long a, long b) {return a*b;}
	long divide(long a, long b) {return a/b;}
//	�ִ��� ���Ͻÿ�
	long max(long a, long b) {
		long result=0;
		if(a>b) {
			result = a;
			}else {
				result = b;
			}return result;
	}
//�ּڰ��� ���Ͻÿ�
	long min(long a, long b) {
		long result=0;
		if(a>b) {
			result = b;
		}else {
			result = a;
		}return result;
	}
	
}