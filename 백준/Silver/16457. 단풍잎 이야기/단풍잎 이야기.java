import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n; // 키의 개수
    static int m; // 퀘스트 개수
    static int k; // 스킬의 수
    static int quest[][];
    static boolean isUsed[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        quest = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                quest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isUsed = new boolean[(2*n)+1];
        powerset(0, 0, 0);
        System.out.println(max);
    }

    private static void powerset(int i, int keyCnt, int successCnt) {
        if(keyCnt > n ) return;
        if(i == m){
            max = Math.max(max, successCnt);
            return;
        }

        // 퀘스트 선택 안함
        powerset(i+1, keyCnt, successCnt);

        // 퀘스트 선택 함
        boolean newIsUsed[] = Arrays.copyOf(isUsed, isUsed.length);
        for (int j = 0; j < k; j++) {
            if(isUsed[quest[i][j]]) continue;
            isUsed[quest[i][j]] = true;
            keyCnt++;
        }
        powerset(i+1, keyCnt, successCnt+1);
        isUsed = Arrays.copyOf(newIsUsed, newIsUsed.length);
    }
}