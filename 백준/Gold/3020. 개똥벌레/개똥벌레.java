import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int H;
    static int hurdle[];
    static int hurdleSum[];
    static int min = Integer.MAX_VALUE;
    static int cnt ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        hurdle = new int[H];
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(br.readLine());
            if(i % 2 == 1){ // i가 홀수면 석순
                hurdle[0] +=1;
                hurdle[h] -=1;
            }else { // i가 짝수면 종유석
                hurdle[H - h] += 1;
                // 끝점은 누적합 하면 0이라 기록할 필요 X
            }
        }

        hurdleSum = new int[H];
        hurdleSum[0] = hurdle[0];
        for (int i = 1; i < H; i++) {
            hurdleSum[i] = hurdleSum[i-1] + hurdle[i];
            min = Math.min(min, hurdleSum[i]);
        }
        for (int i = 0; i < H; i++) {
            if(min == hurdleSum[i]){
                cnt++;
            }
        }

        System.out.println(min+" "+cnt);

    }
}