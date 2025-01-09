import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        recur(A, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    public static void recur(long value, int cnt){
        if(value < 0) return;
        if(value > B) return;
        if(min <= cnt) return;
        if(value == B){
            min = Math.min(min, cnt);
            return;
        }

        recur(value * 2, cnt+1);
        recur(value * 10 + 1, cnt+1);
    }
}
