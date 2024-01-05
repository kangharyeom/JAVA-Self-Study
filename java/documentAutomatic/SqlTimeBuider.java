package documentAutomatic;

public class SqlTimeBuider {
    public static void main(String[] args) {
        int cnt = 250; // cnt 숫자에 따라서 생성할 값의 개수를 조절할 수 있습니다.

        for (int i = 0; i < cnt; i++) {
            double time = generateTime();
            System.out.println(time);
        }
    }

    private static double generateTime() {
        // Randomly generate a double value between 0.45 and 0.79
        double randomTime = 0.045 + Math.random() * (0.079 - 0.045);

        // Round down to 2 decimal places
        return Math.floor(randomTime * 1000) / 1000;
    }
}