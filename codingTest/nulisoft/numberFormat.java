package nulisoft;

import java.text.NumberFormat;

public class numberFormat {
    public static void main(String[] args) {
        int number = 1000000;
        NumberFormat df = NumberFormat.getInstance();
        String answer = df.format(number);
        System.out.println(answer);
    }
}
