package Boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 입력받을 정수
        StringBuilder sb = new StringBuilder(); // 입력할 내용

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); //띄어쓰기를 기준으로 문자열 분리
            while (st.hasMoreTokens()) { // 남아 있는 토큰이 있으면 true
                StringBuilder str = new StringBuilder(st.nextToken()); // 띄어쓰기를 기준으로 나눠진 문자열이 str에 담겨짐
                sb.append(str.reverse() + " "); // 담겨진 문자열 역순으로 저장 및 띄어쓰기
            }
            sb.append("\n"); // 개행하여 출력된 결과물 나눠주기
        }
        System.out.println(sb);
    }
}