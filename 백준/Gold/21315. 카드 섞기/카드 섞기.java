import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int answer[];
    static boolean isUsed[];
    static int originArr[];
    static int newArr[];
    static int num[];
    static int K;
    static int idx = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        isUsed = new boolean[N+1];
        originArr = new int[N];
        newArr = new int[N];
        num = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
            newArr[i] = i+1;
        }

        K = getK(N);
        dfs(0, 0);
    }
    public static void dfs(int n, int prev){
        if(n > 1) {
            boolean isSame = true;
            for (int i = 0; i < N; i++) {
                if(newArr[i] != answer[i]) {
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                System.out.println(num[0] +" " + num[1]);
                System.exit(0);
            }
            return;
        }
        int tmpArr[] = Arrays.copyOf(newArr, N);

        for (int i = 1; i <= K; i++) {
//            if(prev == i) continue;
            originArr = Arrays.copyOf(tmpArr, N);
            Arrays.fill(isUsed, false);
            idx = 0;
            shuffle(i);
            for (int j = 0; j < N; j++) {
                if(idx == N) break;
                newArr[idx++] = originArr[j];
            }
            num[n] = i;
            dfs(n+1, i);
        }
    }

    public static void shuffle(int k){
        if(k < 0) {
            return;
        }

        shuffle(k-1);

        for (int i = (int)(N-Math.pow(2,k)); i < N; i++) {
            if(isUsed[originArr[i]]) break;
            newArr[idx] = originArr[i];
            isUsed[newArr[idx]] = true;
            idx++;
        }
    }
    public static int getK(int n) {
        int cnt = 0;
        while (n/2 != 0){
            cnt ++;
            n /= 2;
        }
        return cnt;
    }

}