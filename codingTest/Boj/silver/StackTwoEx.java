package Boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackTwoEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean bl = false;

        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = 1; j <= num; j++) {
                stack.push(j);
                sb.append("+").append("\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                bl = true;
            }
        }
        if (bl) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
