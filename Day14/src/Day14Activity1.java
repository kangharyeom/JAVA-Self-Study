abstract class Player{
	abstract void play(int pos);// �߻�Ŭ����
	abstract void stop();//�߻� �޼���
}
// �߻�Ŭ������ ����� ���� ��ü�� �ϼ��ؾ� ��ü ���� ����
class AudioPlayer extends Player{
	void play(int pos) {System.out.println(pos);}
	void stop() {System.out.println("����� ����ϴ�");}
	
}


public class Day14Activity1 {
	public static void main(String[] args) {
		Player ap = new AudioPlayer();
		ap.play(100);
		ap.stop();
	}
}
