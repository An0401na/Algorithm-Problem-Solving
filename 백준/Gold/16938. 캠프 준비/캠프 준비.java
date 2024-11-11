import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int R;
    static int X;
    static int level[];
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());

         level = new int[N];

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0, 0, Integer.MAX_VALUE);
        System.out.println(cnt);

    }
    public static void combi(int n, int sum, int max, int min){
        if(n > N-1){
            if (sum >= L && sum <= R){
                if(max - min >= X){
                    cnt++;
                }
            }
            return;
        }

        combi(n+1, sum+level[n], Math.max(max, level[n]), Math.min(min, level[n]));

        combi(n+1, sum, max, min);
    }
}