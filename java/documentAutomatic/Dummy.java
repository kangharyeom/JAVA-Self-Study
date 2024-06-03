package documentAutomatic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

// 1억건 이상의 디비 적재를 위한 클래스
public class DummyBigDataInsert {
    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;
    private Connection con = null;
    public static void main(String[] args) {
        TB_D_ACMP_BATCH();
    }

    public static void TB_D_ACMP_EBM() {
        int times = 54;
        long perStack = 1000000L;
        try {
            for (int j = 1; j <= times; j++) {
                String filePath = "C:/work/DB_script/CSVs/AUTH/SVC/TB_D_ACMP_EBM/csv_TB_D_ACMP_EBM_" + j + ".csv";
                File file = null;
                BufferedWriter bw = null;

                file = new File(filePath);
                bw = new BufferedWriter(new FileWriter(file));

                long SEQ_NUM = 0L;
                long randomCount = 0L;

                SEQ_NUM = ((perStack * j) - perStack) + 1L;
                randomCount = perStack * j;

                bw.write("EBM_SEQ,PARTITION_ID,AGENCY_CODE,INPUT_DTIME,EBM_YN,RETRY_CNT,CTN,TELM_TYPE_CODE,NEW_TELM_TYPE_CODE,CP_CODE,TRD_NO,R_CODE,R_MSG,EBM_R_CODE,TRANSINFO");
                bw.newLine();
                for (long i = SEQ_NUM; i < randomCount; i++) {
                    Random random = new Random();
                    // agencyCode 랜덤 생성
                    int agencyCode = random.nextInt(99) + 1;
                    StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                    while (agencyCodeStr.length() < 2) {
                        agencyCodeStr.insert(0, "0");
                    }

                    // 요일 랜덤 생성
                    int month = random.nextInt(27) + 1;
                    StringBuilder monthStr = new StringBuilder("" + month);
                    while (monthStr.length() < 2) {
                        monthStr.insert(0, "0");
                    }

                    // 9자리 랜덤코드 생성
                    int randomCode = random.nextInt(999999998) + 1;
                    StringBuilder randomCodeStr = new StringBuilder("" + randomCode);
                    while (randomCodeStr.length() < 9) {
                        randomCodeStr.insert(0, "0");
                    }

                    int randomCode2 = random.nextInt(999999998) + 1;
                    StringBuilder randomCode2Str = new StringBuilder("" + randomCode2);
                    while (randomCode2Str.length() < 9) {
                        randomCode2Str.insert(0, "0");
                    }

                    int ctn = random.nextInt(99999999);
                    StringBuilder ctnStr = new StringBuilder("" + ctn);
                    while (ctnStr.length() < 8) {
                        ctnStr.insert(0, "0");
                    }

                    int cpNumberGen = random.nextInt(9999) + 1;
                    StringBuilder cpNumberGenStr = new StringBuilder("" + cpNumberGen);
                    while (cpNumberGenStr.length() < 4) {
                        cpNumberGenStr.insert(0, "0");
                    }

                    boolean rCode = random.nextBoolean();
                    String rCodeStr;
                    String rMessageStr;
                    String ebmRCodeStr;
                    if (rCode) {
                        rCodeStr = "00";
                        rMessageStr = "인증성공";
                        ebmRCodeStr = "S0000";
                    } else {
                        rCodeStr = "01";
                        rMessageStr = "인증실패";
                        ebmRCodeStr = "S0001";
                    }

                    String[] telmTypeCode = new String[]{"A2", "Q2", "Y2", "Z2", "G2", "H2", "I2", "s2", "X2", "s2"};
                    int telmTypeCodeNumber = random.nextInt(9);

                    int retryCount = random.nextInt(2);
                    boolean ebmYn = random.nextBoolean();
                    String ebmYnStr;
                    if (ebmYn) {
                        ebmYnStr = "Y";
                    } else {
                        ebmYnStr = "N";
                    }

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

                    int partitionId = random.nextInt(98) + 1;
                    String PARTITION_ID = "" + partitionId;

                    String nowDate = currentDate.format(formatter);
                    String AGENCY_CODE = "" + agencyCodeStr;
                    String EBM_YN = ebmYnStr;
                    String RETRY_CNT = "" + retryCount;
                    String TELM_TYPE_CODE = telmTypeCode[telmTypeCodeNumber];
                    String NEW_TELM_TYPE_CODE = telmTypeCode[telmTypeCodeNumber];
                    String CP_CODE = "CP1200" + cpNumberGenStr;
                    String TRD_NO = "" + nowDate + agencyCodeStr + randomCodeStr;
                    String R_CODE = rCodeStr;
                    String R_MSG = rMessageStr;
                    String EBM_R_CODE = ebmRCodeStr;
                    String CTN = "0100" + ctnStr;
                    String INPUT_DTIME = "";

                    String TRANSINFO = "LGU202404" + monthStr + randomCode2Str;

                    int monthRandom = random.nextInt(4) + 1;
                    int dayRandom = random.nextInt(27) + 1;
                    int hourRandom = random.nextInt(22) + 1;
                    int minuteRandom = random.nextInt(58) + 1;
                    int secondRandom = random.nextInt(58) + 1;
                    INPUT_DTIME = LocalDateTime.of(2024, monthRandom, dayRandom, hourRandom, minuteRandom, secondRandom).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    SEQ_NUM = i;
                    bw.write(SEQ_NUM + "," + PARTITION_ID + "," + AGENCY_CODE + "," + INPUT_DTIME + "," + EBM_YN + "," + RETRY_CNT + "," + CTN + "," + TELM_TYPE_CODE + "," + NEW_TELM_TYPE_CODE + "," + CP_CODE + "," + TRD_NO + "," + R_CODE + "," + R_MSG + "," + EBM_R_CODE + "," + TRANSINFO);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("finished");
    }

    public static void TB_D_ACMP_FIDO() {
        int times = 7;
        long perStack = 1000000L;
//        long perStack = 10L;

        try {
            for (int j = 1; j <= times; j++) {
                String filePath = "C:/work/DB_script/CSVs/AUTH/SVC/TB_D_ACMP_FIDO/csv_TB_D_ACMP_FIDO_" + j + ".csv";
//                String filePath = "C:/work/DB_script/CSVs/AUTH/BOF/TB_D_ACMP_FIDO/csv_TB_D_ACMP_FIDO_" + j + ".csv";
                File file = null;
                BufferedWriter bw = null;

                file = new File(filePath);
                bw = new BufferedWriter(new FileWriter(file));

                long SEQ_NUM = ((perStack * j) - perStack) + 1L;
                long randomCount = perStack * j;

                bw.write("AUTH_SEQ,PARTITION_ID,FIDO_TRANSACTION_ID,FIDO_R_CODE,FIDO_AUTH_STATUS_CODE,FIDO_APP_TOKEN");
                bw.newLine();

                for (long i = SEQ_NUM; i < randomCount; i++) {
                    Random random = new Random();
                    // agencyCode 랜덤 생성
                    int agencyCode = random.nextInt(99) + 1;
                    StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                    while (agencyCodeStr.length() < 2) {
                        agencyCodeStr.insert(0, "0");
                    }

                    // 월 랜덤 생성
                    int monthRandom = random.nextInt(5) + 1;
                    StringBuilder monthStr = new StringBuilder("" + monthRandom);
                    while (monthStr.length() < 2) {
                        monthStr.insert(0, "0");
                    }

                    // 요일 랜덤 생성
                    int dayRandom;
                    if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                        dayRandom = random.nextInt(31) + 1;
                    } else if (monthRandom == 2) {
                        dayRandom = random.nextInt(28) + 1;
                    } else {
                        dayRandom = random.nextInt(30) + 1;
                    }
                    StringBuilder dayStr = new StringBuilder("" + dayRandom);
                    while (dayStr.length() < 2) {
                        dayStr.insert(0, "0");
                    }

                    // 9자리 랜덤코드 생성
                    int randomCode = random.nextInt(999999999) + 1;
                    StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                    while (trdNoRandomCodeStr.length() < 9) {
                        trdNoRandomCodeStr.insert(0, "0");
                    }

                    // 토큰생성
                    int tokenLength = 20;
                    String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                    StringBuilder fidoAppToken = new StringBuilder(tokenLength);
                    for (int k = 0; k < tokenLength; k++) {
                        fidoAppToken.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
                    }

                    boolean rCode = random.nextBoolean();
                    boolean rStatus = random.nextBoolean();
                    String rCodeStr;
                    String rStatusStr = "";
                    if (rCode) {
                        rCodeStr = "00";
                        if (rStatus) {
                            rStatusStr = "32";
                        }
                    } else {
                        rCodeStr = "01";
                        rStatusStr = "01";
                    }

                    int partitionId = dayRandom;
                    String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;

                    SEQ_NUM = i;
                    String PARTITION_ID = "" + partitionId;
                    String FIDO_TRANSACTION_ID = agencyCodeStr + TRD_NO + TRD_NO;
                    String FIDO_R_CODE = rCodeStr;
                    String FIDO_AUTH_STATUS_CODE = rStatusStr;
                    String FIDO_APP_TOKEN = fidoAppToken.toString();

                    bw.write(SEQ_NUM + "," + PARTITION_ID + "," + FIDO_TRANSACTION_ID + "," + FIDO_R_CODE + "," + FIDO_AUTH_STATUS_CODE + "," + FIDO_APP_TOKEN);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("finished");
    }

    public static void TB_D_ACMP() {
        int times = 6;
        long perStack = 5000000L;

        try {
            for (int j = 1; j <= times; j++) {
                String filePath = "C:/work/DB_script/CSVs/AUTH/SVC/TB_D_ACMP/csv_TB_D_ACMP_" + j + ".csv";
//                String filePath = "C:/work/DB_script/CSVs/AUTH/BOF/TB_D_ACMP/csv_TB_D_ACMP_" + j + ".csv";
                File file = null;
                BufferedWriter bw = null;

                file = new File(filePath);
                bw = new BufferedWriter(new FileWriter(file));

                long SEQ_NUM = 0L;
                long randomCount = 0L;

                SEQ_NUM = ((perStack * j) - perStack) + 1L;
                randomCount = perStack * j;

                bw.write("AUTH_SEQ,PARTITION_ID,REQ_TYPE,AGENCY_CODE,TELM_TYPE_CODE,WND_TYPE,AUTH_CODE,PROD_CODE,REF_TYPE_CODE,OTP_SEND_TYPE,INPUT_DTIME,TRD_NO,CTN,R_CODE,R_MSG,AGE,GENDER,CP_CODE,CUST_NO,CA_INFO,PG_MALL_DESC,CP_URL_DESC,FAIL_REASON");
                bw.newLine();
                for (long i = SEQ_NUM; i < randomCount; i++) {
                    Random random = new Random();
                    // agencyCode 랜덤 생성
                    int agencyCode = random.nextInt(99) + 1;
                    StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                    while (agencyCodeStr.length() < 2) {
                        agencyCodeStr.insert(0, "0");
                    }

                    // 월 랜덤 생성
                    int monthRandom = random.nextInt(5) + 1;
                    StringBuilder monthStr = new StringBuilder("" + monthRandom);
                    while (monthStr.length() < 2) {
                        monthStr.insert(0, "0");
                    }

                    // 요일 랜덤 생성
                    int dayRandom;
                    if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                        dayRandom = random.nextInt(31) + 1;
                    } else if (monthRandom == 2) {
                        dayRandom = random.nextInt(28) + 1;
                    } else {
                        dayRandom = random.nextInt(30) + 1;
                    }
                    StringBuilder dayStr = new StringBuilder("" + dayRandom);
                    while (dayStr.length() < 2) {
                        dayStr.insert(0, "0");
                    }

                    // 9자리 랜덤코드 생성
                    int randomCode = random.nextInt(999999999) + 1;
                    StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                    while (trdNoRandomCodeStr.length() < 9) {
                        trdNoRandomCodeStr.insert(0, "0");
                    }

                    // 전화번호 랜덤코드 생성
                    int ctn = random.nextInt(99999999);
                    StringBuilder ctnStr = new StringBuilder("" + ctn);
                    while (ctnStr.length() < 8) {
                        ctnStr.insert(0, "0");
                    }

                    // cpCode 랜덤코드 생성
                    int cpNumberGen = random.nextInt(9998) + 1;
                    StringBuilder cpNumberGenStr = new StringBuilder("" + cpNumberGen);
                    while (cpNumberGenStr.length() < 4) {
                        cpNumberGenStr.insert(0, "0");
                    }

                    // custNo 랜덤코드 생성
                    int custNoRandom1 = random.nextInt(9999999) + 1;
                    int custNoRandom2 = random.nextInt(99999999) + 1;
                    String custNoStr1 = "" + custNoRandom1 + custNoRandom2;

                    // 나이 랜덤코드 생성
                    int ageRandom = random.nextInt(80) + 15;

                    // 젠더 랜덤코드 생성
                    String genderStr;
                    if (ageRandom > 24) {
                        int genderRandom = random.nextInt(2) + 1;
                        genderStr = "" + genderRandom;
                    } else {
                        int genderRandom = random.nextInt(2) + 3;
                        genderStr = "" + genderRandom;
                    }

                    boolean rCode = random.nextBoolean();
                    String rCodeStr;
                    String rMessageStr;
                    if (rCode) {
                        rCodeStr = "00";
                        rMessageStr = "인증성공";
                    } else {
                        rCodeStr = "01";
                        rMessageStr = "인증실패";
                    }
                    String[] refTypeCodeStr = new String[]{"ACN", "ADP", "ANX", "APS", "BRA", "BSB"
                            , "CAL", "CCM", "CGM", "CKC", "ADP", "ANX", "APS", "BRA", "BSB", "CAL"
                            , "CCM", "CGM", "CMI", "CNB", "CNM", "CPS", "CYB", "DFT", "DRM", "DSH"
                            , "EGM", "EMO", "ERL", "EVM", "EZN", "FBC", "FIT", "GME", "GMS", "LGT"};
                    String[] pgMallStr = new String[]{"테스트알뜰1", "테스트알뜰2", "테스트알뜰3", "테스트알뜰4"
                            , "테스트알뜰5", "테스트알뜰6", "테스트알뜰7", "테스트알뜰8", "테스트알뜰9", "테스트알뜰10"
                            , "테스트알뜰11", "테스트알뜰12", "테스트알뜰13", "테스트알뜰14", "테스트알뜰15", "테스트알뜰16"
                            , "테스트알뜰17", "테스트알뜰18", "테스트알뜰19", "테스트알뜰20", "테스트알뜰21", "테스트알뜰22"
                            , "테스트알뜰23", "테스트알뜰24", "테스트알뜰25", "테스트알뜰26", "테스트알뜰27", "테스트알뜰28"
                            , "테스트알뜰29", "테스트알뜰30", "테스트알뜰31", "테스트알뜰32", "테스트알뜰33", "테스트알뜰34"
                            , "테스트알뜰35", "테스트알뜰36"};
                    int refTypeCodeRandom = random.nextInt(refTypeCodeStr.length);

                    String[] productCodeStr = new String[]{"A", "B", "G", "D"};
                    int productCodeRandom = random.nextInt(productCodeStr.length);

                    String[] telmTypeCode = new String[]{"A2", "Q2", "Y2", "Z2", "G2", "H2", "I2", "s2", "X2", "s2"};
                    int telmTypeCodeNumber = random.nextInt(telmTypeCode.length);

                    String[] authCodeStr = new String[]{"C", "S", "L", "Q", "W", "E", "R", "P", "M"};
                    int authCodeRandom = random.nextInt(authCodeStr.length);

                    String[] otpSendType = new String[]{"ARS", "SMS", "MMS"};
                    int otpSendTypeRandom = random.nextInt(3);

                    boolean reqType = random.nextBoolean();
                    String reqTypeStr;
                    if (reqType) {
                        reqTypeStr = "T";
                    } else {
                        reqTypeStr = "Q";
                    }

                    boolean wndType = random.nextBoolean();
                    String wndTypeStr;
                    if (wndType) {
                        wndTypeStr = "C";
                    } else {
                        wndTypeStr = "S";
                    }

                    int partitionId = dayRandom;

                    SEQ_NUM = i;
                    String PARTITION_ID = "" + partitionId;
                    String REQ_TYPE = reqTypeStr;
                    String AGENCY_CODE = "" + agencyCodeStr;
                    String TELM_TYPE_CODE = telmTypeCode[telmTypeCodeNumber];
                    String WND_TYPE = wndTypeStr;
                    String AUTH_CODE = authCodeStr[authCodeRandom];
                    String PRD_CODE = productCodeStr[productCodeRandom];
                    String REF_TYPE_CODE = refTypeCodeStr[refTypeCodeRandom];
                    String OTP_SEND_TYPE = otpSendType[otpSendTypeRandom];
                    String INPUT_DTIME = "";
                    String CP_CODE = "CP1200" + cpNumberGenStr;
                    String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;
                    String R_CODE = rCodeStr;
                    String CA_INFO = "";
                    String CUST_NO = custNoStr1;
                    String PG_MALL_DESC = "";
                    String CP_URL_DESC = "http://www.test.com";
                    String FAIL_REASON = "";
                    String R_MSG = rMessageStr;
                    String AGE = "" + ageRandom;
                    String GENDER = genderStr;
                    String CTN = "0100" + ctnStr;

                    if (REF_TYPE_CODE.equals("LGT")) {
                        PG_MALL_DESC = "UPLUS";
                    } else {
                        PG_MALL_DESC = pgMallStr[refTypeCodeRandom];
                    }

                    int hourRandom = random.nextInt(23) + 1;
                    int minuteRandom = random.nextInt(59) + 1;
                    int secondRandom = random.nextInt(59) + 1;
                    INPUT_DTIME = LocalDateTime.of(2024, monthRandom, dayRandom, hourRandom, minuteRandom, secondRandom).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    bw.write(SEQ_NUM + "," + PARTITION_ID + "," + REQ_TYPE + "," + AGENCY_CODE + "," + TELM_TYPE_CODE + "," + WND_TYPE + "," + AUTH_CODE + "," + PRD_CODE + "," + REF_TYPE_CODE + "," + OTP_SEND_TYPE + "," + INPUT_DTIME + "," + TRD_NO + "," + CTN + "," + R_CODE + "," + R_MSG + "," + AGE + "," + GENDER + "," + CP_CODE + "," + CUST_NO + "," + CA_INFO + "," + PG_MALL_DESC + "," + CP_URL_DESC + "," + FAIL_REASON);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("finished");
    }

    public static void TB_D_ACMP_MIN() {
        int times = 4;
        long perStack = 500000L;
//        long perStack = 10L;

        try {
            for (int j = 1; j <= times; j++) {
                String filePath = "C:/work/DB_script/CSVs/AUTH/SVC/TB_D_ACMP_MIN/csv_TB_D_ACMP_MIN_" + j + ".csv";
//                String filePath = "C:/work/DB_script/CSVs/AUTH/BOF/TB_D_ACMP_MIN/csv_TB_D_ACMP_MIN_" + j + ".csv";
                File file = null;
                BufferedWriter bw = null;

                file = new File(filePath);
                bw = new BufferedWriter(new FileWriter(file));

                long SEQ_NUM = ((perStack * j) - perStack) + 1L;
                long randomCount = perStack * j;

                bw.write("AUTH_SEQ,PARTITION_ID,MIN_TRD_NO,MIN_R_CODE,MIN_MSG_TYPE");
                bw.newLine();

                for (long i = SEQ_NUM; i < randomCount; i++) {
                    Random random = new Random();
                    // agencyCode 랜덤 생성
                    int agencyCode = random.nextInt(99) + 1;
                    StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                    while (agencyCodeStr.length() < 2) {
                        agencyCodeStr.insert(0, "0");
                    }

                    // 월 랜덤 생성
                    int monthRandom = random.nextInt(5) + 1;
                    StringBuilder monthStr = new StringBuilder("" + monthRandom);
                    while (monthStr.length() < 2) {
                        monthStr.insert(0, "0");
                    }

                    // 요일 랜덤 생성
                    int dayRandom;
                    if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                        dayRandom = random.nextInt(31) + 1;
                    } else if (monthRandom == 2) {
                        dayRandom = random.nextInt(28) + 1;
                    } else {
                        dayRandom = random.nextInt(30) + 1;
                    }
                    StringBuilder dayStr = new StringBuilder("" + dayRandom);
                    while (dayStr.length() < 2) {
                        dayStr.insert(0, "0");
                    }

                    // 9자리 랜덤코드 생성
                    int randomCode = random.nextInt(999999999) + 1;
                    StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                    while (trdNoRandomCodeStr.length() < 9) {
                        trdNoRandomCodeStr.insert(0, "0");
                    }

                    boolean rCode = random.nextBoolean();
                    String rCodeStr;
                    if (rCode) {
                        rCodeStr = "00";
                    } else {
                        rCodeStr = "01";
                    }

                    int hourRandom = random.nextInt(23) + 1;
                    StringBuilder hourStr = new StringBuilder("" + hourRandom);
                    while (hourStr.length() < 2) {
                        hourStr.insert(0, "0");
                    }

                    int minuteRandom = random.nextInt(59) + 1;
                    StringBuilder minuteStr = new StringBuilder("" + minuteRandom);
                    while (minuteStr.length() < 2) {
                        minuteStr.insert(0, "0");
                    }

                    int secondRandom = random.nextInt(59) + 1;
                    StringBuilder secondStr = new StringBuilder("" + secondRandom);
                    while (secondStr.length() < 2) {
                        secondStr.insert(0, "0");
                    }

                    int milliSecondRandom = random.nextInt(999) + 1;
                    StringBuilder milliSecondStr = new StringBuilder("" + milliSecondRandom);
                    while (milliSecondStr.length() < 3) {
                        milliSecondStr.insert(0, "0");
                    }

                    int partitionId = dayRandom;
                    String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;
                    String tmpMinTrdNo = "2024"+monthStr + dayStr + hourStr + minuteStr + secondStr+ milliSecondStr; // YYYYMMDDHHmmSSsss

                    SEQ_NUM = i;
                    String PARTITION_ID = "" + partitionId;
                    String MIN_TRD_NO = TRD_NO + tmpMinTrdNo;
                    String MIN_R_CODE = rCodeStr;
                    String MIN_MSG_TYPE = "S";

                    bw.write(SEQ_NUM + "," + PARTITION_ID + "," + MIN_TRD_NO + "," + MIN_R_CODE + "," + MIN_MSG_TYPE);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("finished");
    }

    // 배치 인서트
    public void TB_D_ACMP_BATCH_BOF(){
        con = null;
        pstmt = null;

        int totlaTarget = 100;
        int nowRow = 0;

        String sql = "INSERT INTO TB_D_ACMP (AUTH_SEQ,PARTITION_ID,REQ_TYPE,AGENCY_CODE,TELM_TYPE_CODE,WND_TYPE,AUTH_CODE,PROD_CODE,REF_TYPE_CODE,OTP_SEND_TYPE,TRD_NO,CTN,R_CODE,R_MSG,AGE,GENDER,CP_CODE,CUST_NO,CA_INFO,PG_MALL_DESC,CP_URL_DESC,FAIL_REASON,INPUT_DTIME" +
                ") VALUES (?,EXTRACT(DAY FROM SYSDATE)-?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,(SYSDATE-29)+?)";

        Properties props = new Properties();

        try {
//            props.put("user", "idauthsvc");
            props.put("user", "idauthbof");
//            props.put("password", "altisvc_019");
            props.put("password", "altibof_019");

            Class.forName("Altibase.jdbc.driver.AltibaseDriver");
            con = DriverManager.getConnection("jdbc:Altibase://172.17.27.22:20300/authdb?ConnectionRetryCount=0&ConnectionRetryDelay=0&LoadBalance=off&SessionFailOver=on");
//            con = DriverManager.getConnection("jdbc:Altibase://172.17.27.184:20300/authdb?ConnectionRetryCount=0&ConnectionRetryDelay=0&LoadBalance=off&SessionFailOver=on");
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(sql);

            for (int i = nowRow; i< totlaTarget; i++){
                nowRow = i+1;


                Random random = new Random();
                // 월 랜덤 생성
                int monthRandom = random.nextInt(5) + 1;
                StringBuilder monthStr = new StringBuilder("" + monthRandom);
                while (monthStr.length() < 2) {
                    monthStr.insert(0, "0");
                }

                int dayRandom;
                if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                    dayRandom = random.nextInt(31) + 1;
                } else if (monthRandom == 2) {
                    dayRandom = random.nextInt(28) + 1;
                } else {
                    dayRandom = random.nextInt(30) + 1;
                }
                StringBuilder dayStr = new StringBuilder("" + dayRandom);
                while (dayStr.length() < 2) {
                    dayStr.insert(0, "0");
                }

                boolean reqType = random.nextBoolean();
                String reqTypeStr;
                if (reqType) {
                    reqTypeStr = "T";
                } else {
                    reqTypeStr = "Q";
                }

                // agencyCode 랜덤 생성
                int agencyCode = random.nextInt(99) + 1;
                StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                while (agencyCodeStr.length() < 2) {
                    agencyCodeStr.insert(0, "0");
                }

                String[] telmTypeCode = new String[]{"A2", "Q2", "Y2", "Z2", "G2", "H2", "I2", "s2", "X2", "s2"};
                int telmTypeCodeNumber = random.nextInt(telmTypeCode.length);

                boolean wndType = random.nextBoolean();
                String wndTypeStr;
                if (wndType) {
                    wndTypeStr = "C";
                } else {
                    wndTypeStr = "S";
                }

                String[] authCodeStr = new String[]{"C", "S", "L", "Q", "W", "E", "R", "P", "M"};
                int authCodeRandom = random.nextInt(authCodeStr.length);

                String[] productCodeStr = new String[]{"A", "B", "G", "D"};
                int productCodeRandom = random.nextInt(productCodeStr.length);

                String[] refTypeCodeStr = new String[]{"ACN", "ADP", "ANX", "APS", "BRA", "BSB"
                        , "CAL", "CCM", "CGM", "CKC", "ADP", "ANX", "APS", "BRA", "BSB", "CAL"
                        , "CCM", "CGM", "CMI", "CNB", "CNM", "CPS", "CYB", "DFT", "DRM", "DSH"
                        , "EGM", "EMO", "ERL", "EVM", "EZN", "FBC", "FIT", "GME", "GMS", "LGT"};
                String[] pgMallStr = new String[]{"테스트알뜰1", "테스트알뜰2", "테스트알뜰3", "테스트알뜰4"
                        , "테스트알뜰5", "테스트알뜰6", "테스트알뜰7", "테스트알뜰8", "테스트알뜰9", "테스트알뜰10"
                        , "테스트알뜰11", "테스트알뜰12", "테스트알뜰13", "테스트알뜰14", "테스트알뜰15", "테스트알뜰16"
                        , "테스트알뜰17", "테스트알뜰18", "테스트알뜰19", "테스트알뜰20", "테스트알뜰21", "테스트알뜰22"
                        , "테스트알뜰23", "테스트알뜰24", "테스트알뜰25", "테스트알뜰26", "테스트알뜰27", "테스트알뜰28"
                        , "테스트알뜰29", "테스트알뜰30", "테스트알뜰31", "테스트알뜰32", "테스트알뜰33", "테스트알뜰34"
                        , "테스트알뜰35", "테스트알뜰36"};
                int refTypeCodeRandom = random.nextInt(refTypeCodeStr.length);

                String[] otpSendType = new String[]{"ARS", "SMS", "MMS"};
                int otpSendTypeRandom = random.nextInt(3);

                // 9자리 랜덤코드 생성
                int randomCode = random.nextInt(999999999) + 1;
                StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                while (trdNoRandomCodeStr.length() < 9) {
                    trdNoRandomCodeStr.insert(0, "0");
                }

                String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;

                // 전화번호 랜덤코드 생성
                int ctn = random.nextInt(99999999);
                StringBuilder ctnStr = new StringBuilder("" + ctn);
                while (ctnStr.length() < 8) {
                    ctnStr.insert(0, "0");
                }

                String CTN = "0100" + ctnStr;

                boolean rCode = random.nextBoolean();
                String rCodeStr;
                String rMessageStr;
                if (rCode) {
                    rCodeStr = "00";
                    rMessageStr = "인증성공";
                } else {
                    rCodeStr = "01";
                    rMessageStr = "인증실패";
                }

                // 나이 랜덤코드 생성
                int ageRandom = random.nextInt(80) + 15;

                String AGE = "" + ageRandom;

                // 젠더 랜덤코드 생성
                String genderStr;
                if (ageRandom > 24) {
                    int genderRandom = random.nextInt(2) + 1;
                    genderStr = "" + genderRandom;
                } else {
                    int genderRandom = random.nextInt(2) + 3;
                    genderStr = "" + genderRandom;
                }

                String GENDER = genderStr;

                // cpCode 랜덤코드 생성
                int cpNumberGen = random.nextInt(9998) + 1;
                StringBuilder cpNumberGenStr = new StringBuilder("" + cpNumberGen);
                while (cpNumberGenStr.length() < 4) {
                    cpNumberGenStr.insert(0, "0");
                }

                String CP_CODE = "CP1200" + cpNumberGenStr;

                String PG_MALL_DESC = "";

                String REF_TYPE_CODE = refTypeCodeStr[refTypeCodeRandom];

                if (REF_TYPE_CODE.equals("LGT")) {
                    PG_MALL_DESC = "UPLUS";
                } else {
                    PG_MALL_DESC = pgMallStr[refTypeCodeRandom];
                }

                // custNo 랜덤코드 생성
                int custNoRandom1 = random.nextInt(9999999) + 1;
                int custNoRandom2 = random.nextInt(99999999) + 1;
                String custNoStr1 = "" + custNoRandom1 + custNoRandom2;

                pstmt.setInt(Column.AUTH_CODE.getIndex(), nowRow);
                pstmt.setInt(Column.PARTITION_ID.getIndex(), nowRow/30000000);
                pstmt.setString(Column.REQ_TYPE.getIndex(), reqTypeStr);
                pstmt.setString(Column.AGENCY_CODE.getIndex(), agencyCodeStr.toString());
                pstmt.setString(Column.TELM_TYPE_CODE.getIndex(), telmTypeCode[telmTypeCodeNumber]);
                pstmt.setString(Column.WND_TYPE.getIndex(), wndTypeStr);
                pstmt.setString(Column.AUTH_CODE.getIndex(), authCodeStr[authCodeRandom]);
                pstmt.setString(Column.PROD_CODE.getIndex(), productCodeStr[productCodeRandom]);
                pstmt.setString(Column.REF_TYPE_CODE.getIndex(), REF_TYPE_CODE);
                pstmt.setString(Column.OTP_SEND_TYPE.getIndex(), otpSendType[otpSendTypeRandom]);
                pstmt.setString(Column.TRD_NO.getIndex(), TRD_NO);
                pstmt.setString(Column.CTN.getIndex(), CTN);
                pstmt.setString(Column.R_CODE.getIndex(), rCodeStr);
                pstmt.setString(Column.R_MSG.getIndex(), rMessageStr);
                pstmt.setString(Column.AGE.getIndex(), AGE);
                pstmt.setString(Column.GENDER.getIndex(), GENDER);
                pstmt.setString(Column.CP_CODE.getIndex(), CP_CODE);
                pstmt.setString(Column.CUST_NO.getIndex(), custNoStr1);
                pstmt.setString(Column.CA_INFO.getIndex(), "");
                pstmt.setString(Column.PG_MALL_DESC.getIndex(), PG_MALL_DESC);
                pstmt.setString(Column.CP_URL_DESC.getIndex(), "http://www.test.com");
                pstmt.setString(Column.FAIL_REASON.getIndex(), "");
                pstmt.setInt(Column.INPUT_DTIME.getIndex(), nowRow/30000000);

                pstmt.addBatch();

                if ((nowRow % 200) == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    con.commit();
                    logger.info("nowRow:" + nowRow + "Commit");
                }
            }

            pstmt.executeBatch();
            pstmt.clearBatch();
            con.commit();
            logger.info("nowRow:" + nowRow + "Commit");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("ErrorRow:"+ nowRow);

            try {
                con.rollback();
            } catch (SQLException el) {
                logger.error(e.getMessage(), el);
            }
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {

                }
            }
        }
        logger.info("END");
    }

    public void TB_D_ACMP_BATCH(){
        con = null;
        pstmt = null;

        int totlaTarget = 100;
        int nowRow = 0;

        String sql = "INSERT INTO TB_D_ACMP (AUTH_SEQ,PARTITION_ID,REQ_TYPE,AGENCY_CODE,TELM_TYPE_CODE,WND_TYPE,AUTH_CODE,PROD_CODE,REF_TYPE_CODE,OTP_SEND_TYPE,TRD_NO,CTN,R_CODE,R_MSG,AGE,GENDER,CP_CODE,CUST_NO,CA_INFO,PG_MALL_DESC,CP_URL_DESC,FAIL_REASON,INPUT_DTIME" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,(SYSDATE-29)+?)";

        Properties props = new Properties();

        try {
            props.put("user", "idauthsvc");
            props.put("password", "altisvc_019");

            Class.forName("Altibase.jdbc.driver.AltibaseDriver");
            con = DriverManager.getConnection("jdbc:Altibase://172.17.27.184:20300/authdb?ConnectionRetryCount=0&ConnectionRetryDelay=0&LoadBalance=off&SessionFailOver=on",props);
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(sql);

            for (int i = nowRow; i< totlaTarget; i++){
                nowRow = i+1;


                Random random = new Random();
                // 월 랜덤 생성
                int monthRandom = random.nextInt(5) + 1;
                StringBuilder monthStr = new StringBuilder("" + monthRandom);
                while (monthStr.length() < 2) {
                    monthStr.insert(0, "0");
                }

                int dayRandom;
                if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                    dayRandom = random.nextInt(31) + 1;
                } else if (monthRandom == 2) {
                    dayRandom = random.nextInt(28) + 1;
                } else {
                    dayRandom = random.nextInt(30) + 1;
                }
                StringBuilder dayStr = new StringBuilder("" + dayRandom);
                while (dayStr.length() < 2) {
                    dayStr.insert(0, "0");
                }

                boolean reqType = random.nextBoolean();
                String reqTypeStr;
                if (reqType) {
                    reqTypeStr = "T";
                } else {
                    reqTypeStr = "Q";
                }

                // agencyCode 랜덤 생성
                int agencyCode = random.nextInt(99) + 1;
                StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                while (agencyCodeStr.length() < 2) {
                    agencyCodeStr.insert(0, "0");
                }

                int partitionId = dayRandom;

                String[] telmTypeCode = new String[]{"A2", "Q2", "Y2", "Z2", "G2", "H2", "I2", "s2", "X2", "s2"};
                int telmTypeCodeNumber = random.nextInt(telmTypeCode.length);

                boolean wndType = random.nextBoolean();
                String wndTypeStr;
                if (wndType) {
                    wndTypeStr = "C";
                } else {
                    wndTypeStr = "S";
                }

                String[] authCodeStr = new String[]{"C", "S", "L", "Q", "W", "E", "R", "P", "M"};
                int authCodeRandom = random.nextInt(authCodeStr.length);

                String[] productCodeStr = new String[]{"A", "B", "G", "D"};
                int productCodeRandom = random.nextInt(productCodeStr.length);

                String[] refTypeCodeStr = new String[]{"ACN", "ADP", "ANX", "APS", "BRA", "BSB"
                        , "CAL", "CCM", "CGM", "CKC", "ADP", "ANX", "APS", "BRA", "BSB", "CAL"
                        , "CCM", "CGM", "CMI", "CNB", "CNM", "CPS", "CYB", "DFT", "DRM", "DSH"
                        , "EGM", "EMO", "ERL", "EVM", "EZN", "FBC", "FIT", "GME", "GMS", "LGT"};
                String[] pgMallStr = new String[]{"테스트알뜰1", "테스트알뜰2", "테스트알뜰3", "테스트알뜰4"
                        , "테스트알뜰5", "테스트알뜰6", "테스트알뜰7", "테스트알뜰8", "테스트알뜰9", "테스트알뜰10"
                        , "테스트알뜰11", "테스트알뜰12", "테스트알뜰13", "테스트알뜰14", "테스트알뜰15", "테스트알뜰16"
                        , "테스트알뜰17", "테스트알뜰18", "테스트알뜰19", "테스트알뜰20", "테스트알뜰21", "테스트알뜰22"
                        , "테스트알뜰23", "테스트알뜰24", "테스트알뜰25", "테스트알뜰26", "테스트알뜰27", "테스트알뜰28"
                        , "테스트알뜰29", "테스트알뜰30", "테스트알뜰31", "테스트알뜰32", "테스트알뜰33", "테스트알뜰34"
                        , "테스트알뜰35", "테스트알뜰36"};
                int refTypeCodeRandom = random.nextInt(refTypeCodeStr.length);

                String[] otpSendType = new String[]{"ARS", "SMS", "MMS"};
                int otpSendTypeRandom = random.nextInt(3);

                int hourRandom = random.nextInt(23) + 1;
                int minuteRandom = random.nextInt(59) + 1;
                int secondRandom = random.nextInt(59) + 1;
                String INPUT_DTIME = LocalDateTime.of(2024, monthRandom, dayRandom, hourRandom, minuteRandom, secondRandom).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 9자리 랜덤코드 생성
                int randomCode = random.nextInt(999999999) + 1;
                StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                while (trdNoRandomCodeStr.length() < 9) {
                    trdNoRandomCodeStr.insert(0, "0");
                }

                String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;

                // 전화번호 랜덤코드 생성
                int ctn = random.nextInt(99999999);
                StringBuilder ctnStr = new StringBuilder("" + ctn);
                while (ctnStr.length() < 8) {
                    ctnStr.insert(0, "0");
                }

                String CTN = "0100" + ctnStr;

                boolean rCode = random.nextBoolean();
                String rCodeStr;
                String rMessageStr;
                if (rCode) {
                    rCodeStr = "00";
                    rMessageStr = "인증성공";
                } else {
                    rCodeStr = "01";
                    rMessageStr = "인증실패";
                }

                // 나이 랜덤코드 생성
                int ageRandom = random.nextInt(80) + 15;

                String AGE = "" + ageRandom;

                // 젠더 랜덤코드 생성
                String genderStr;
                if (ageRandom > 24) {
                    int genderRandom = random.nextInt(2) + 1;
                    genderStr = "" + genderRandom;
                } else {
                    int genderRandom = random.nextInt(2) + 3;
                    genderStr = "" + genderRandom;
                }

                String GENDER = genderStr;

                // cpCode 랜덤코드 생성
                int cpNumberGen = random.nextInt(9998) + 1;
                StringBuilder cpNumberGenStr = new StringBuilder("" + cpNumberGen);
                while (cpNumberGenStr.length() < 4) {
                    cpNumberGenStr.insert(0, "0");
                }

                String CP_CODE = "CP1200" + cpNumberGenStr;

                String PG_MALL_DESC = "";

                String REF_TYPE_CODE = refTypeCodeStr[refTypeCodeRandom];

                if (REF_TYPE_CODE.equals("LGT")) {
                    PG_MALL_DESC = "UPLUS";
                } else {
                    PG_MALL_DESC = pgMallStr[refTypeCodeRandom];
                }

                // custNo 랜덤코드 생성
                int custNoRandom1 = random.nextInt(9999999) + 1;
                int custNoRandom2 = random.nextInt(99999999) + 1;
                String custNoStr1 = "" + custNoRandom1 + custNoRandom2;

                pstmt.setInt(Column.AUTH_SEQ.getIndex(), nowRow);
                pstmt.setInt(Column.PARTITION_ID.getIndex(), partitionId);
                pstmt.setString(Column.REQ_TYPE.getIndex(), reqTypeStr);
                pstmt.setString(Column.AGENCY_CODE.getIndex(), agencyCodeStr.toString());
                pstmt.setString(Column.TELM_TYPE_CODE.getIndex(), telmTypeCode[telmTypeCodeNumber]);
                pstmt.setString(Column.WND_TYPE.getIndex(), wndTypeStr);
                pstmt.setString(Column.AUTH_CODE.getIndex(), authCodeStr[authCodeRandom]);
                pstmt.setString(Column.PROD_CODE.getIndex(), productCodeStr[productCodeRandom]);
                pstmt.setString(Column.REF_TYPE_CODE.getIndex(), REF_TYPE_CODE);
                pstmt.setString(Column.OTP_SEND_TYPE.getIndex(), otpSendType[otpSendTypeRandom]);
                pstmt.setString(Column.TRD_NO.getIndex(), TRD_NO);
                pstmt.setString(Column.CTN.getIndex(), CTN);
                pstmt.setString(Column.R_CODE.getIndex(), rCodeStr);
                pstmt.setString(Column.R_MSG.getIndex(), rMessageStr);
                pstmt.setString(Column.AGE.getIndex(), AGE);
                pstmt.setString(Column.GENDER.getIndex(), GENDER);
                pstmt.setString(Column.CP_CODE.getIndex(), CP_CODE);
                pstmt.setString(Column.CUST_NO.getIndex(), custNoStr1);
                pstmt.setString(Column.CA_INFO.getIndex(), "");
                pstmt.setString(Column.PG_MALL_DESC.getIndex(), PG_MALL_DESC);
                pstmt.setString(Column.CP_URL_DESC.getIndex(), "http://www.test.com");
                pstmt.setString(Column.FAIL_REASON.getIndex(), "");
                pstmt.setInt(Column.INPUT_DTIME.getIndex(), dayRandom);

                pstmt.addBatch();

                if ((nowRow % 200) == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    con.commit();
                    logger.info("nowRow:" + nowRow + "Commit");
                }
            }

            pstmt.executeBatch();
            pstmt.clearBatch();
            con.commit();
            logger.info("nowRow:" + nowRow + "Commit");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("ErrorRow:"+ nowRow);

            try {
                con.rollback();
            } catch (SQLException el) {
                logger.error(e.getMessage(), el);
            }
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {

                }
            }
        }
        logger.info("END");
    }

    public void TB_D_ACMP_FIDO_BATCH_BOF(){
        con = null;
        pstmt = null;

        int totlaTarget = 100;
        int nowRow = 0;

        String sql = "INSERT INTO TB_D_ACMP_FIDO (AUTH_SEQ,PARTITION_ID,FIDO_TRANSACTION_ID,FIDO_R_CODE,FIDO_AUTH_STATUS_CODE,FIDO_APP_TOKEN" +
                ") VALUES (?,?,?,?,?,?)";

        Properties props = new Properties();

        try {
            props.put("user", "idauthbof");
            props.put("password", "altibof_019");

            Class.forName("Altibase.jdbc.driver.AltibaseDriver");
            con = DriverManager.getConnection("jdbc:Altibase://172.17.27.22:20300/authdb?ConnectionRetryCount=0&ConnectionRetryDelay=0&LoadBalance=off&SessionFailOver=on",props);
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(sql);

            for (int i = nowRow; i< totlaTarget; i++){
                nowRow = i+1;

                Random random = new Random();
                // 월 랜덤 생성
                int monthRandom = random.nextInt(5) + 1;
                StringBuilder monthStr = new StringBuilder("" + monthRandom);
                while (monthStr.length() < 2) {
                    monthStr.insert(0, "0");
                }

                int dayRandom;
                if (monthRandom == 1 || monthRandom == 3 || monthRandom == 5 || monthRandom == 7 || monthRandom == 8 || monthRandom == 10 || monthRandom == 12) {
                    dayRandom = random.nextInt(31) + 1;
                } else if (monthRandom == 2) {
                    dayRandom = random.nextInt(28) + 1;
                } else {
                    dayRandom = random.nextInt(30) + 1;
                }
                StringBuilder dayStr = new StringBuilder("" + dayRandom);
                while (dayStr.length() < 2) {
                    dayStr.insert(0, "0");
                }

                // agencyCode 랜덤 생성
                int agencyCode = random.nextInt(99) + 1;
                StringBuilder agencyCodeStr = new StringBuilder("" + agencyCode);
                while (agencyCodeStr.length() < 2) {
                    agencyCodeStr.insert(0, "0");
                }

                int partitionId = dayRandom;

                // 9자리 랜덤코드 생성
                int randomCode = random.nextInt(999999999) + 1;
                StringBuilder trdNoRandomCodeStr = new StringBuilder("" + randomCode);
                while (trdNoRandomCodeStr.length() < 9) {
                    trdNoRandomCodeStr.insert(0, "0");
                }

                String TRD_NO = "24" + monthStr + dayStr + agencyCodeStr + trdNoRandomCodeStr;

                // r코드 생성
                boolean rCode = random.nextBoolean();
                boolean rStatus = random.nextBoolean();
                String rCodeStr;
                String rStatusStr = "";
                if (rCode) {
                    rCodeStr = "00";
                    if (rStatus) {
                        rStatusStr = "32";
                    }
                } else {
                    rCodeStr = "01";
                    rStatusStr = "01";
                }

                // 토큰생성
                int tokenLength = 20;
                String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                StringBuilder fidoAppToken = new StringBuilder(tokenLength);
                for (int k = 0; k < tokenLength; k++) {
                    fidoAppToken.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
                }

                String FIDO_TRANSACTION_ID = agencyCodeStr + TRD_NO + TRD_NO;
                String FIDO_R_CODE = rCodeStr;
                String FIDO_AUTH_STATUS_CODE = rStatusStr;
                String FIDO_APP_TOKEN = fidoAppToken.toString();

                pstmt.setInt(ColumnFIDO.AUTH_SEQ.getIndex(), nowRow);
                pstmt.setInt(ColumnFIDO.PARTITION_ID.getIndex(), partitionId);
                pstmt.setString(ColumnFIDO.FIDO_TRANSACTION_ID.getIndex(), FIDO_TRANSACTION_ID);
                pstmt.setString(ColumnFIDO.FIDO_R_CODE.getIndex(), FIDO_R_CODE);
                pstmt.setString(ColumnFIDO.FIDO_AUTH_STATUS_CODE.getIndex(), FIDO_AUTH_STATUS_CODE);
                pstmt.setString(ColumnFIDO.FIDO_APP_TOKEN.getIndex(), FIDO_APP_TOKEN);

                pstmt.addBatch();

                if ((nowRow % 200) == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    con.commit();
                    logger.info("nowRow:" + nowRow + "Commit");
                }
            }

            pstmt.executeBatch();
            pstmt.clearBatch();
            con.commit();
            logger.info("nowRow:" + nowRow + "Commit");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("ErrorRow:"+ nowRow);

            try {
                con.rollback();
            } catch (SQLException el) {
                logger.error(e.getMessage(), el);
            }
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {

                }
            }
        }
        logger.info("END");
    }


    public void TB_D_ACMP_BATCH_UPDATE(){
        con = null;
        pstmt = null;

        int totlaTarget = 10;
        int nowRow = 0;

        String sql = "UPDATE IDAUTHSVC.TB_D_ACMP" +
                "SET INPUT_DTIME = sysdate - 28" +
                "WHERE PARTIITON_ID = 1;";

        Properties props = new Properties();

        try {
            props.put("user", "idauthsvc");
            props.put("user", "altisvc_019");

            Class.forName("Altibase.jdbc.driver.AltibaseDriver");
            con = DriverManager.getConnection("jdbc:Altibase://172.17.27.184:20300/authdb?ConnectionRetryCount=0&ConnectionRetryDelay=0&LoadBalance=off&SessionFailOver=on");
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(sql);

            for (int i = 1; i< totlaTarget; i++){
                nowRow = i;

                pstmt.addBatch();

                if ((nowRow % 200) == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    con.commit();
                    logger.info("nowRow:" + nowRow + "Commit");
                }
            }

            pstmt.executeBatch();
            pstmt.clearBatch();
            con.commit();
            logger.info("nowRow:" + nowRow + "Commit");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("ErrorRow:"+ nowRow);

            try {
                con.rollback();
            } catch (SQLException el) {
                logger.error(e.getMessage(), el);
            }
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {

                }
            }
        }
        logger.info("END");
    }
    enum Column{
        AUTH_SEQ(1),
        PARTITION_ID(2),
        REQ_TYPE(3),
        AGENCY_CODE(4),
        TELM_TYPE_CODE(5),
        WND_TYPE(6),
        AUTH_CODE(7),
        PROD_CODE(8),
        REF_TYPE_CODE(9),
        OTP_SEND_TYPE(10),
        TRD_NO(11),
        CTN(12),
        R_CODE(13),
        R_MSG(14),
        AGE(15),
        GENDER(16),
        CP_CODE(17),
        CUST_NO(18),
        CA_INFO(19),
        PG_MALL_DESC(20),
        CP_URL_DESC(21),
        FAIL_REASON(22),
        INPUT_DTIME(23);

        final private int index;

        private Column(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

    }

    enum ColumnFIDO{
        AUTH_SEQ(1),
        PARTITION_ID(2),
        FIDO_TRANSACTION_ID(3),
        FIDO_R_CODE(4),
        FIDO_AUTH_STATUS_CODE(5),
        FIDO_APP_TOKEN(6);

        final private int index;

        private ColumnFIDO(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

    }


}
