import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /** 방법 1. 1~1000000까지 완탐
     * 1부터 1000000까지 탐색하면서 주어진 수로 3개 이상 나눠지는지 확인
     * 나눠지면 출력하고 끝
     */

    /** 방법 2. 3개 조합 만들어 3개 수의 최소 공배수들 중 가장 작은 값 출력
     *
     */
    static int input[];
    static int number[];
    static int min; // 최소 공배수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[5];
        number = new int[3];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(min);

    }

    public static void dfs(int idx, int start) {
        if(idx == 3){
            // 최소 공배수를 구해서 현재 대부분의 배수보다 더 작은 수 인지 비교
            int lcm = getLCM(getLCM(number[0], number[1]), number[2]);
            if(min > lcm) {
                min = lcm;
            }
            return;
        }
        for (int i = start; i < 5; i++) {
            number[idx] = input[i];
            dfs(idx+1, i+1);
        }
    }

    public static int getLCM(int a, int b){
        if( a < b ){
            int temp = a;
            a = b;
            b = temp;
        }
        return a * b / getGCD(a, b);  // 두수의 곱을 최대 공약수로 나누면 최소공배수

    }


    public static int getGCD(int a, int b){
        // a > b 일때 
        if(b == 0) return a; // b가 0이면 a를 리턴 
        if( a % b == 0) return b; // a 가 b로 나누어 떨어지면 b 리턴
        return getGCD(b, a%b); // 나누어 떨어지지 않으면 a를 b로, b를 a에서 b로 나눈 나머지로 대입하고 재귀
    }
}