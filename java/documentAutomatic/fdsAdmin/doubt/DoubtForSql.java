package documentAutomatic.fdsAdmin.doubt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubtForSql {
    public static void main(String[] args) {
        String front =
                        "SELECT paging.*                                                      "+
                        "FROM (                                                               "+
                        "SELECT DOUBT_PERSON_INFO_SEQ,                                        "+
                        "CONCAT(DATE_FORMAT(PROV_DT, '%Y-%m-%d %H:%i:%s'))                    "+
                        "PROV_DT,                                                             "+
                        "CONCAT(DATE_FORMAT(REG_DT, '%Y-%m-%d %H:%i:%s'))REG_DT,              "+
                        "REG_TYPE,                                                            "+
                        "DOUBT_CD,                                                            "+
                        "DOUBT_TYPE,                                                          "+
                        "CUST_NO,                                                             "+
                        "CTN,                                                                 "+
                        "SYNC_YN,                                                             "+
                        "( SELECT CODE1_NAME FROM TB_COMMON_CD_DTL WHERE CODE1 = DOUBT_CD )                                                              "+
                        "AS DOUBT_CODE_NAME                                                   "+
                        "FROM TB_DOUBT_PERSON_INFO WHERE ";

        String tail =
                        "                                                                     "+
                        " ORDER BY PROV_DT DESC                                               "+
                        " ) paging                                                            "+
                        " ORDER BY REG_DT DESC                                                "+
                        " LIMIT 40 OFFSET 0    ";
        // 예시 데이터
        List<String> resource =
                Arrays.asList(
                        ",,      PROV_DT BETWEEN '20231217' AND STR_TO_DATE(CONCAT('2023-12-17', '23:59:59'), '%Y-%m-%d %H:%i:%s')                                        ",
                        ",,      REG_DT BETWEEN '20231217' AND STR_TO_DATE(CONCAT('2023-12-17', '23:59:59'), '%Y-%m-%d %H:%i:%s')                                         ",
                        ",,      CTN = '010011111111'                                                                                                                     ",
                        ",,      CUST_NO = '1234123412341234'                                                                                                             ",
                        ",,      DOUBT_TYPE = 'E'                                                                                                                         ",
                        ",,      SYNC_YN = 'Y'                                                                                                                            ",
                        ",,      DOUBT_DETECT_HIST_SEQ = '1'                                                                                                              ");

        // 가능한 모든 조합을 생성
        List<List<String>> allResult = generateCombinations(resource);

        // 결과 출력
        for (List<String> result : allResult) {
            String resultStr = front+result.toString()+tail;
            resultStr= resultStr.replace("[", " ");
            resultStr= resultStr.replace("]", " ");
            resultStr= resultStr.replace(", ,,", "AND");
            resultStr= resultStr.replace(",,", "AND");
            resultStr= resultStr.replace("WHERE  AND", "WHERE ");
            System.out.println(resultStr);
        }
        System.out.println(allResult.size());
    }

    // 가능한 모든 조합을 생성하는 함수
    private static List<List<String>> generateCombinations(List<String> resource) {
        List<List<String>> result = new ArrayList<>();
        generateCombinationsHelper(resource, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(List<String> resource, int idx, List<String> combine, List<List<String>> result) {
        if (idx == resource.size()) {
            // 모든 요소를 확인한 경우 현재 조합을 결과에 추가
            result.add(new ArrayList<>(combine));
            return;
        }

        // 현재 인덱스의 요소를 포함하는 경우
        combine.add(resource.get(idx));
        generateCombinationsHelper(resource, idx + 1, combine, result);
        combine.remove(combine.size() - 1);

        // 현재 인덱스의 요소를 포함하지 않는 경우
        generateCombinationsHelper(resource, idx + 1, combine, result);
    }
}
