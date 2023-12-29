import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Number numbers[];
    static boolean possible[];

    static class Number{
        String num;
        int strike;

        int ball;

        public Number(String num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        possible = new boolean[988];
        Arrays.fill(possible, true);
        numbers = new Number[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[i] = new Number(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 중복된 숫자가 있는 수가 있거나 0이 들어있는 경우는 답이  될 수 없으므로 제외
        for (int j = 123; j <= 987; j++) {
            if(!possible[j])continue;
            String n = String.valueOf(j);
            for (int i = 0; i < 3; i++) {
                if(n.charAt(i) =='0') {
                    possible[j] = false;
                    continue;
                }
                for (int k = i+1; k < 3; k++) {
                    if(n.charAt(i) == n.charAt(k)){
                        possible[j] = false;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
//            System.out.println("주어진 수 : "+ numbers[i].num);
//            System.out.println("  가능성 있는 수 ");
            for (int j = 123; j <= 987; j++) {
                if(possible[j]){ //j라는 숫자가 답 가능성이 있을때
                    if(isPossible(numbers[i], j)) {
//                        System.out.println("   - "+j);
                        continue; //주어진 조건에 만족하는지 확인
                    }
                    possible[j] = false; //만족하지 않으면 false로 변경
                }
            }
        }

        int cnt = 0;
        for (int i = 123; i <= 987; i++) {
            if(possible[i]) {
//                System.out.println(i);
                cnt++;
            }

        }
        System.out.println(cnt);
    }

    private static boolean isPossible(Number number, int possibleNumber) {
        // number와 possibleNumber 가 주어진 조건에 해당하느냐 ( ex : 1스트라이크, 1볼 관계가 맞나 )

        if(getStrikeCnt(number.num, String.valueOf(possibleNumber)) == number.strike){
            if(getBallCnt(number.num, String.valueOf(possibleNumber)) == number.ball){
//                System.out.println("    "+getStrikeCnt(number.num, String.valueOf(possibleNumber)) +" 스트라이크 ,"+
//                        getBallCnt(number.num, String.valueOf(possibleNumber))+" 볼");
                return true;
            }
        }
        return false;
    }

    private static int getStrikeCnt(String num, String possibleNumber) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(num.charAt(i) == possibleNumber.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    private static int getBallCnt(String num, String possibleNumber) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j) continue;
                if(num.charAt(i) == possibleNumber.charAt(j)){
                    cnt++;
                }
            }
        }
        return cnt;

    }

}