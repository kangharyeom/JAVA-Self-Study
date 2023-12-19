import java.util.regex.Pattern;
public class StrUtil {
    public static void main(String[] args) {
        String ctn = "010011111111";
        String maskedCtn = maskPhoneNumber(ctn);
        System.out.println(maskedCtn);
    }

    private static String maskPhoneNumber(String phoneNumber) {
        if (isNumeric(phoneNumber)) {
            return phoneNumber.replaceAll("^(01\\d)\\d{4}(\\d{4})$", "$1****$2");
        }
        return phoneNumber;
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(str).matches();
    }
}