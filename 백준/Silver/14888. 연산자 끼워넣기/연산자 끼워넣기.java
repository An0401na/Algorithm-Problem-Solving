import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];
    static int oper[]; // + - x /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }


        dfs(1,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int cur, int result){
        if(cur >= N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(oper[i] == 0) continue;
            int value = result;
            switch (i){
                case 0:
                    value = result + arr[cur];
                    break;
                case 1:
                    value = result - arr[cur];
                    break;
                case 2:
                    value = result * arr[cur];
                    break;
                case 3:
                    value = result / arr[cur];
            }

            oper[i]--;
            dfs(cur+1, value);
            oper[i]++;

        }
    }
}