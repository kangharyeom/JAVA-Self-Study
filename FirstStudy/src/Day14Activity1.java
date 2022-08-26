abstract class Player{
	abstract void play(int pos);// 추상클래스
	abstract void stop();//추상 메서드
}
// 추상클래스는 상속을 통해 객체를 완성해야 객체 생성 가능
class AudioPlayer extends Player{
	void play(int pos) {System.out.println(pos);}
	void stop() {System.out.println("재생을 멈춥니다");}
	
}


public class Day14Activity1 {
	public static void main(String[] args) {
		Player ap = new AudioPlayer();
		ap.play(100);
		ap.stop();
	}
}
