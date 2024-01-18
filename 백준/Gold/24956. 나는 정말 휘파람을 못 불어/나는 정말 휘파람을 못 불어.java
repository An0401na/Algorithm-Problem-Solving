import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] S;
    static long w;
    static long wh;
    static long whe;
    static long whee;
    static final long MOD = 1000000007;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new char[N];
        S = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if(S[i] == 'W'){
                w +=1;
            } else if (S[i] == 'H') {
                wh += w;
            } else if (S[i] == 'E') {
                whee = (2*whee+whe)%MOD;
                whe += wh;
            }
        }

        System.out.println(whee);

    }
}