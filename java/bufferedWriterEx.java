import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class bufferedWriterEx {
    public static void main(String[] args) throws IOException {
        String ctn = "010011111111";
        String maskedCtn = ctn.substring(0, 4) + "****" + ctn.substring(ctn.length()-4, ctn.length());
        System.out.println(maskedCtn);

        String custNo = "12345678987654321";
        StringBuffer asterisk = new StringBuffer();
        for (int i = 0; i<custNo.length() - 8; i++) {
            asterisk.append("*");
        }
        String maskedCustNo = custNo.substring(0, 4) + asterisk + custNo.substring(custNo.length()-4, custNo.length());
        System.out.println(maskedCustNo);
    }


}
