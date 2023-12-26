import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /** 방법 1. 1~1000000까지 완탐
     * 1부터 1000000까지 탐색하면서 주어진 수로 3개 이상 나눠지는지 확인
     * 나눠지면 출력하고 끝
     */

    /** 방법 2. 3개 조합 만들어 3개 수의 최소 공배수들 중 가장 작은 값 출력
     *
     */
    static int input[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[5];

        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 1000001; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(i % input[j] != 0) {
                    cnt ++;
                    if(cnt == 3) break;
                }
            }
            if(cnt < 3) {
                System.out.println(i);
                break;
            }
        }
    }
}