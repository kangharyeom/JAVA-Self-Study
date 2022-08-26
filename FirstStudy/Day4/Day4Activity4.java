package FirstStudy.Day4;

class Day4Activity4 {

	public static void main(String[] args) {
// �ݺ��� = for���� while��
// for��
// ex) for(int i=1; i<5; i++)
// =   for(  �ʱ�ȭ; ���ǽ�;������)
		for(int i=1; i<=10; i=i*2){
		System.out.println("hello"+i);}

// �ݺ� ��ø��
//	������ 
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
		
// �ܼ� ��ø �ݺ�
		for(int i=1; i<10; i++){
			for(int j=1; j<10; j++) {
				System.out.print("$");
			}
			System.out.println();
		}

// J���� �����ϴ� ��ø�ݺ�
		for(int i=1; i<=10; i++){
			for(int j=1; j<=i; j++) { //���ǹ��� i���� ����
				System.out.print("$");
			}
			System.out.println();
		}

		
	}
}
