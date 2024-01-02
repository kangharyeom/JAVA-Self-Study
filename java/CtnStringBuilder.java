import java.io.IOException;

public class CtnStringBuilder {
    public static void main(String[] args) throws IOException {
        StringBuilder toStringCtn = new StringBuilder("312312312");
        String removeCtnComma = "";
        if(toStringCtn != null && !toStringCtn.equals("")){
            removeCtnComma = toStringCtn.substring(1, toStringCtn.length());
        }
        System.out.println(removeCtnComma);
    }
}
