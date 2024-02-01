import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;           // 더미의 개수
    static Dummy[] dummies; // 더미 객체 배열

    // 더미 클래스 정의
    static class Dummy {
        long a;  // 시작 정수
        long b;  // 정수 간격
        long c;  // 마지막 정수

        // 생성자
        public Dummy(long a, long c, long b) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        // 디버깅을 위한 toString 메소드 오버라이드
        @Override
        public String toString() {
            return "Dummy{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    static long max = Long.MIN_VALUE; // 더미 배열 내 최대 c값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dummies = new Dummy[N];

        // 더미 객체 배열 초기화 및 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dummies[i] = new Dummy(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            max = Math.max(max, dummies[i].c); // 최대 c값 갱신
        }

        long start = 1;       // 이분 탐색 시작값
        long end = max;       // 이분 탐색 끝값
        long resultNum = -1;  // 결과로 찾은 홀수개 존재하는 정수

        // 이분 탐색 실행
        while (start <= end) {
            long mid = (start + end) / 2;
            long numCnt = getSmallOrEqualNumCnt(mid);

            // 홀수개 존재하는 정수 찾은 경우
            if (numCnt % 2L == 1) {
                end = mid - 1;
                resultNum = mid;
            } else {
                start = mid + 1;
            }
        }

        // 결과가 없는 경우 "NOTHING" 출력 후 종료
        if (resultNum == -1) {
            System.out.println("NOTHING");
            return;
        }

        // 홀수개 존재하는 정수의 개수 계산
        long cnt = getSmallOrEqualNumCnt(resultNum) - getSmallOrEqualNumCnt(resultNum - 1);

        // 결과 출력
        System.out.println(resultNum + " " + cnt);
    }

    // target보다 작거나 같은 숫자의 개수를 반환하는 메소드
    private static long getSmallOrEqualNumCnt(long target) {
        long total = 0;

        // 모든 더미에 대해 처리
        for (int i = 0; i < N; i++) {
            // target보다 작은 경우 무시
            if (target < dummies[i].a) continue;

            // 더미의 c값이 target보다 작은 경우
            if (dummies[i].c < target) {
                // 해당 더미에서 target 이하의 숫자의 개수를 더함
                total += getCnt(dummies[i].c, i);
            } else {
                // 그렇지 않으면 해당 더미에서 target 이하의 숫자의 개수를 더함
                total += getCnt(target, i);
            }
        }

        return total;
    }

    // target 이하의 숫자의 개수를 반환하는 메소드
    private static long getCnt(long target, int i) {
        return ((target - dummies[i].a) / dummies[i].b) + 1;
    }
}