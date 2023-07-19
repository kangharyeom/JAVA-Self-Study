package dataStructure;

import java.util.Scanner;
import java.util.StringTokenizer;

public class countWord {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);

        String string = str.nextLine();
        str.close();

        StringTokenizer st = new StringTokenizer(string, " ");
        System.out.println(st.countTokens());
    }
}
