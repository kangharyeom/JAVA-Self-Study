package nulisoft;

import java.text.DecimalFormat;

public class decimalFormat {
    public static void main(String[] args) {
        int number = 1000000;
        DecimalFormat df = new DecimalFormat("###,###");
        String answer = df.format(number);
        System.out.println(answer);
    }
}
