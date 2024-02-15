import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean isBroken[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isBroken = new boolean[10];
        if(M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        min = Math.abs(N - 100);
        makeChannel(0, 0);
        System.out.println(min);
    }

    private static void makeChannel(int depth, int channel) {
        if(depth == 6){
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(isBroken[i]) continue;
            int newChannel = channel*10 +i;
            if( N > 100 && newChannel>N*2){
                break;
            }

            min = Math.min(min, (depth+1)+Math.abs(N - newChannel));
            makeChannel(depth+1, newChannel);
        }
    }
}