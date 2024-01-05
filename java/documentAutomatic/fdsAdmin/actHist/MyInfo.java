package documentAutomatic.fdsAdmin.actHist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyInfo {
    public static void main(String[] args) {
        String title ="내 정보 ";
        // 예시 데이터
        List<String> resource =
                Arrays.asList("등록 일시", "LOGIN_ID", "ACT_MENU_CD");

        // 가능한 모든 조합을 생성
        List<List<String>> allResult = generateCombinations(resource);

        // 결과 출력
        for (List<String> result : allResult) {
            System.out.println(title+result);
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
