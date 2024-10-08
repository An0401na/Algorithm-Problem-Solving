import java.util.*;
class Solution {
        static int n;
        static int tops[];
        static int answer = 0;
        static int[] dp;
        public int solution(int n, int[] tops) {
            this.n = n;
            this.tops = tops;

            dp = new int[n*2 + 100];
            Arrays.fill(dp , -1);
            answer = recur(0);

            return answer;
        }
    
        private int recur(int idx) {
            if(idx == 2 * n +1) return 1;
            if(idx > 2 * n) return 0;
            if(dp[idx] != -1) return dp[idx];
            
            int caseCnt = 0;
            if(idx % 2 == 1 && tops[idx/2] == 1) { // 2층을 놓을 수 있는 삼각형의 위치일 경우
                caseCnt += recur(idx + 1); // 일반 삼각형을 놓앗을때 만들어지는 경우의 수
                caseCnt += recur(idx + 1); // 마름모꼴 도형을 놓았을때 만들어지는 경우의 수
                caseCnt += recur(idx + 2); // 왼쪽을 바라보는 사다리꼴 모양을 놓았을때 경우의수
                caseCnt %= 10007;
            }else{
                caseCnt += recur(idx + 1); // 일반 삼각형을 놓았을때
                caseCnt += recur(idx + 2); // 오른쪽을 바라보는 사다리꼴 모양을 놓았을때
                caseCnt %= 10007;
            }

            dp[idx] = caseCnt;
            return dp[idx];
        }
}