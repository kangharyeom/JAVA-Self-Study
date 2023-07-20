import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class bufferedWriterEx {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
        String s = "abcd";   //출력할 문자열
        bw.write(s+"\n");   //버퍼에 있는 값을 출력함
        bw.flush();   //남아있는 데이터를 모두 출력
        bw.close();   //스트림을 닫음
    }
}
