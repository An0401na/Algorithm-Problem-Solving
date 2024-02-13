import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean isBroken[];
    static int min = Integer.MAX_VALUE;
    static int channel;

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

    private static void makeChannel(int depth, int click) {
        if(click >= min) return;
        if(depth == 6){
            if(channel == 0){
                if(isBroken[0]) return;
                click +=1;
            }
            min = Math.min(min, click+Math.abs(N - channel));
//            System.out.println("목적지 채널 : "+ N);
//            System.out.println("  도착 채널 : "+channel);
//            System.out.println("  차이 : "+(Math.abs(N - channel)));
//            System.out.println("  클릭수 : "+ click);
//            System.out.println("  =====> min : " + min);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(i != 0 && isBroken[i]) continue;
            if(i == 0 && isBroken[0]){
                if(channel != 0) continue;
            }
            channel = channel*10 +i;
            if( N > 100 && channel>N*2){
                break;
            }
            makeChannel(depth+1, channel == 0 ? 0 : click+1);
            channel = channel/10;
        }
    }
}