import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long num[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        for (int n = 0; n < N; n++) {
            boolean flag = true;
            for (int s = 2; s < 1000000; s++) {
                if(num[n] % s == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }


        }




    }
}