import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int arr[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = 0;
        int odd = 0;
        while (start < N ){
            while (end < N && odd <= K){
                if(arr[end] % 2 != 0){
                    odd++;
                }
                end ++;
            }
            max = Math.max(max, end - start - odd);

            if(arr[start] % 2 != 0){
                odd--;
            }
            start++;
        }

        System.out.println(max);
    }
}