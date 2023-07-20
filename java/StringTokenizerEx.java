import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽어드릴수 있는 라인 추가
        int c = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
        int d = Integer.parseInt(st.nextToken());
        System.out.println(c + " " + d);
    }
}
