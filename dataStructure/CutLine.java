package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class CutLine {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        // N명의 학생
        int N = Scan.nextInt();

        // K명은 상을 받음
        int K = Scan.nextInt();

        //if N = 5, K= 2 => R = 3
        // 100 76 85 93 98
        // 98

        int arr[] = new int[N];
        for (int i=0; i<N; i++){

            //arr[i]에 점수 대입
            arr[i] = Scan.nextInt();
        }
        //오름차순 정렬
        Arrays.sort(arr);

        //N - K = R 이므로 R번째부터 커트라인임
        System.out.println(arr[N-K]);
    }
}
