import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;        // 체스판의 크기
    static int queens[]; // 각 퀸의 열 위치를 저장하는 배열
    static int cnt;      // 유효한 배열의 수를 세는 변수
    
    static class Queen{
        int r;
        int c;

        @Override
        public String toString() {
            return "Queen{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        public Queen(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자로부터 체스판의 크기를 입력받음
        N = Integer.parseInt(br.readLine());

        // 퀸의 열 위치를 저장할 배열을 초기화
        queens = new int[N];

        // 문제를 해결하기 위해 nqueen 함수 호출
        nqueen(0, 0);// 결과 출력
        System.out.println(cnt);
    }

    // 백트래킹을 사용한 N-Queens 문제 해결 메서드
    private static void nqueen(int depth, int r) {
        // 모든 퀸을 배치했을 때, 유효한 배열이 하나 늘어남
        if (depth == N) {
            cnt++;
            return;
        }

        // 현재 행이 체스판을 벗어나면 종료
        if (r >= N)
            return;

        // 현재 행에서 가능한 모든 열에 대해 시도
        for (int i = 0; i < N; i++) {
            // 해당 열에 퀸을 놓을 수 있는지 체크
            if (check(r, i)) {
                // 가능하다면 해당 열에 퀸을 놓고 다음 행으로 이동
                queens[r] = i;
                nqueen(depth + 1, r + 1);
            }
        }
    }

    // 현재 위치에 퀸을 놓을 수 있는지 체크하는 메서드
    private static boolean check(int r, int c) {
        // 현재 행보다 위쪽의 모든 행에 대해 검사
        for (int i = 0; i < r; i++) {
            Queen q = new Queen(i, queens[i]);
            // 같은 열에 퀸이 있는 경우 또는 대각선에 위치한 경우
            if (q.c == c || (Math.abs(q.r - r) == Math.abs(q.c - c))) {
                return false; // 놓을 수 없음
            }
        }
        return true; // 놓을 수 있음
    }
}