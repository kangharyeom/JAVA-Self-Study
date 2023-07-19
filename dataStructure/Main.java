package dataStructure;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 5개 담을 배열
        int[] arr = new int[5];

        // 5개 총합
        int sum = 0;

        // 5개 값을 입력 / 입력값 sum += 대입
        for(int i=0; i<5; i++) {
            int num = scan.nextInt();
            arr[i] += num;
            sum += num;
        }

        System.out.println(sum/5);

        Arrays.sort(arr);

        System.out.println(arr[2]);

        scan.close();
    }
}