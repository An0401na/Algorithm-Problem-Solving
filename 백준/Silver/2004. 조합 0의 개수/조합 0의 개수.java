import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 분자는 n!
        int numerator2 = divisionCnt(n,2);
        int numerator5 = divisionCnt(n, 5);


        // 분모는 (n-m)! m!
        // 2로 나누어 떨어지는 횟수는 (n-m)!에서의 2로 나누어 떨어지는 횟수 + m에서 2로 나누어 떨어지는 횟수
        // 5로 나누어 떨어지는 횟수는 (n-m)!에서의 5로 나누어 떨어지는 횟수 + m에서 5로 나누어 떨어지는 횟수
        int denominator2 = divisionCnt(n-m, 2) + divisionCnt(m, 2);
        int denominator5 = divisionCnt(n-m,5) + divisionCnt(m, 5);

        int result2 = numerator2 - denominator2;
        int result5 = numerator5 - denominator5;

        if(result2 <= 0 || result5 <= 0){
            System.out.println("0");
            return;
        }else{
            System.out.println(Math.min(result2, result5));
        }

    }

    //x를 k로 몇번 나누어 떨어지는 구하는 함수
    private static int divisionCnt(int x, int k) {
        int cnt = 0;
        long divisor = k;
        while (divisor <= x){
            cnt += x / divisor;
            divisor *= k;
        }
        return cnt;
    }
}