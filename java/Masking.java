import java.io.IOException;

public class Masking {
    private static String ctn = "010011111111";
    private static String custNo = "12345678987654321";
    private static String userName = "최고다우리모두";
    public static void main(String[] args) throws IOException {
        /*
         * ctn 마스킹
         * */
        String maskedCtn = ctn.substring(0, 4) + "****" + ctn.substring(ctn.length() - 4, ctn.length());
        System.out.println(maskedCtn);

        StringBuffer asterisk = new StringBuffer();
        for (int i = 0; i < custNo.length() - 8; i++) {
            asterisk.append("*");
        }

        /*
         * CUST_NO 마스킹
         * */
        String maskedCustNo = custNo.substring(0, 4) + asterisk + custNo.substring(custNo.length() - 4, custNo.length());
        System.out.println(maskedCustNo);

        /*
         * USER_NAME 마스킹
         * */
        StringBuffer asteriskForUser = new StringBuffer();
        for (int i = 0; i < userName.length() - 2; i++) {
            asteriskForUser.append("*");
        }

        String maskedUserName = userName.substring(0, 1) + asteriskForUser + userName.substring(userName.length() - 1, userName.length());
        System.out.println(maskedUserName);
    }
}
