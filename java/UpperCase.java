import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);

            if(Character.isLowerCase(c)){
                answer += Character.toUpperCase(c);
            } else if (Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            } else {
                answer += c;
            }
        }
        System.out.println(answer);

    }
}