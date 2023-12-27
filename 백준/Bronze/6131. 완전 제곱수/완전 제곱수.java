import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static  int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int a = 1; a <= 500 ; a++) {
            for (int b = 1; b < 500; b++) {
                if(a*a == b*b+N){
                    count ++;
                }
            }
        }

        System.out.println(count);

    }
}