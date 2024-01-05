package documentAutomatic.fdsAdmin.myInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActHistForSqlQuestion {
    public static void main(String[] args) {
        String front =
                "SELECT paging.*                                                      "+
                        "FROM (                                                               "+
                        "SELECT                                                               "+
                        "CONCAT(DATE_FORMAT(AAH.REG_DT, '%Y-%m-%d'),' (',SUBSTR(_UTF8'일월화수목금토',DAYOFWEEK(AAH.REG_DT),1),') ',(DATE_FORMAT(AAH.REG_DT, '%H:%i:%s'))) AS REG_DT,                            "+
                        "AAH.LOGIN_ID,                                                            "+
                        "AAH.LOGIN_IP,                                                            "+
                        "AAH.BROWSER_TYPE,                                                        "+
                        "AAH.FILE_DOWN_REASON,                                                    "+
                        "A.USER_NAME,                                                    "+
                        "( SELECT MENU_NAME FROM TB_ADMIN_MENU_INFO MENU WHERE MENU_CD = AAH.ACT_MENU_CD AND USE_YN = 'Y' AND MENU_URL IS NOT NULL )                                                                   "+
                        "AS MENU_NAME,                                                        "+
                        "( SELECT CODE1_NAME FROM TB_COMMON_CD_DTL WHERE CODE1 = AAH.ACT_FUNC_CD AND CD_DEF = 'MENU_FUNC_TYPE' AND USE_YN = 'Y')                                                             "+
                        "AS FUNC_NAME                                                         "+
                        "FROM TB_ADMIN_ACT_HIST AAH, TB_ADMIN A WHERE AAH.LOGIN_ID = A.LOGIN_ID ";

        String tail =
                "                                                                     "+
                        " ) paging                                                            "+
                        " ORDER BY REG_DT DESC                                                "+
                        " LIMIT ? OFFSET ?    ";
        // 예시 데이터
        List<String> resource =
                Arrays.asList(
                        ",,      AAH.REG_DT BETWEEN STR_TO_DATE(CONCAT('?', '/00/00/00'), '%Y%m%d/%H/%i/%s') AND STR_TO_DATE(CONCAT('?', '/23/59/59'), '%Y%m%d/%H/%i/%s')                                         ",
                        ",,      A.USER_NAME LIKE CONCAT('%', '?', '%')                                               ",
                        ",,      A.LOGIN_ID = '?'                                               ",
                        ",,      AAH.ACT_MENU_CD = '?'                                          ");
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
