package FirstStudy.Day3;

public class Day3Activity1 {
	public static void main(String[] args) {
// ����ȯ �ǽ�
		String str = "5";
		System.out.println(str.charAt(0)- '0');
//		���ڿ� "5"�� ���������� ��ȯ 
		System.out.println('5' - '0'+1);
		System.out.println('5' - '1');
//		������ '5'�� ������ '1'�� ���� 
		System.out.println(1+"5");
//		���� 1�� ���ڿ� 5�� ���� => 1�� 5�� ���
		System.out.println(Integer.parseInt("5")+1);
//		���ڿ� "5"�� int(����)Ÿ������ ����ȯ ���� ���� 1�� ���� 6���
		System.out.println("5"+1);
//		���ڿ� "5"�� ���� 1�� ���� => 5�� 1�� ��µǾ� 51
		System.out.println(5+ '0');
//		���� 5�� ���� 0�� ������ȣ 48�� ���յǾ� 53 ���
		
		
	}
}
