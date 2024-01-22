import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start =0;
        int end = 0;
        long sum = arr[end];
        int cnt =0;
        while (end < N){
            if(sum == M){
                cnt ++;
            }

            if(sum <= M){
                end++;
                if(end < N ){
                    sum += arr[end];
                }
            }else{
                sum -= arr[start];
                start++;
            }

        }

        System.out.println(cnt);


    }
}