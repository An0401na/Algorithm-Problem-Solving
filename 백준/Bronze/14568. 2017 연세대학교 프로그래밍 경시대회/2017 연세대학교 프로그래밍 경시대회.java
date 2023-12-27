import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N; // 사탕의 개수
    static int a; // 택희
    static int b; // 영훈
    static int c; // 남규
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N-1 ; i++) { // 한사람이 받을 수 있는 사탕의 개수는 1 ~ 98개 ( 0개 받는 사람이 없어야 하기 때문)
            a = i;
            if( a % 2 != 0) continue;
            for (int j = 1; j < N-a-1; j++) {
                b = j;
                c = N - a - b;
                if( c >= b +2 ) count ++;
            }
        }

        System.out.println(count);


    }
}