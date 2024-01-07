import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a;
    static int b;
    static int q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(br.readLine());

        for (int p = 0; p < q; p++) {
            st = new StringTokenizer(br.readLine());

            int check = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(check == 1){
                System.out.println(sequenceSum(r) - sequenceSum(l-1));
            }else{
                if(l == r){
                    System.out.println(a + (l-1)*b);
                }else{
                    System.out.println(gcd(Math.max(a, b), Math.min(a, b)));
                }
            }

        }
    }

    private static long gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    private static long sequenceSum(int n) {
        return (n * (2*a + (n-1)*b))/2;
    }
}