import java.util.*;

class Solution {
    static int alp;
    static int cop;
    static int problems[][];
    static int maxAlp;
    static int maxCop;
    static int dp[][];
    public int solution(int alp, int cop, int[][] problems) {
        this.alp = alp;
        this.cop = cop;
        this.problems = problems;


        for(int i = 0; i < problems.length; i++){
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        dp = new int [maxAlp+1][maxCop+1];
        for (int i = 0; i < maxAlp+1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int answer = recur(alp, cop);
        return answer;
    }

    // alp, cop에서 maxAlp와 MaxCop를 만드는 최소 시간을 리턴하는 재귀 함수
    
        private int recur(int alp, int cop){
            if(alp >= maxAlp && cop >= maxCop) return 0;

            alp = Math.min(maxAlp, alp);
            cop = Math.min(maxCop, cop);

            if(dp[alp][cop] != Integer.MAX_VALUE) return dp[alp][cop];

            int value = Integer.MAX_VALUE;

            if(alp < maxAlp)    value = Math.min(value, recur(alp + 1, cop) + 1);
            if(cop < maxCop)    value = Math.min(value, recur(alp, cop + 1) + 1);


            for(int i = 0; i < problems.length; i++){
                int alp_req = problems[i][0];
                int cop_req = problems[i][1];
                int alp_rwd = problems[i][2];
                int cop_rwd = problems[i][3];
                int cost = problems[i][4];

                if(alp >= alp_req && cop >= cop_req) {
                    if((alp >= maxAlp && cop_rwd == 0) || (cop >= maxCop && alp_rwd == 0)) continue;
                    value = Math.min(value, recur(alp + alp_rwd, cop + cop_rwd) + cost);
                }
            }


            return dp[alp][cop]= value;
        }
}