import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int dot[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            dot = new int[N];
            for (int i = 0; i < N; i++) {
                dot[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dot);

            int cnt = 0;
            for (int b = 1; b <= N-1 ; b++) { // 점 b
                for (int a = 0; a <= b-1; a++) { // 점 a
                    int distance = dot[b] - dot[a];

                    int start = b+1;
                    int end = N-1;
                    boolean flag = false;
                    while(start <= end){
                        int mid = (int)(start+end)/2;

                        if(dot[mid]-dot[b] == distance){
                            flag = true;
                        }
                        if(dot[mid]-dot[b] < distance){
                            start = mid +1;
                        }else{
                            end = mid - 1;
                        }


                    }
                    if(flag) cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}