package nulisoft;

public class ThousandNumber{
    public static void main(String[] args) {
        String number = "1000000";
        number = number.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        System.out.println(number);
    }
}
