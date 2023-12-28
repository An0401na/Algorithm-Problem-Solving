import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a;
    static int b;
    static int c;
    static int d;
    static int e;
    static int f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if(a*x + b*y == c && d*x + e*y ==f){
                    System.out.println(x+" "+y);
                    return;
                }
            }


        }


    }
}