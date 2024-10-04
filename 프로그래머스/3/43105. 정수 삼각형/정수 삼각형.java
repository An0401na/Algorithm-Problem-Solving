import java.util.*;
class Solution {

    static int triangle[][];
    static int dp[][];
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        dp = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = recur(0, 0);
        return answer;
    }

    private int recur(int depth, int idx) {
        if(depth == triangle.length-1){
            return triangle[depth][idx];
        }
        if(dp[depth][idx] != -1){
            return dp[depth][idx];
        }
//            return Math.max(recur(depth+1, idx)+triangle[depth][idx],
//                            recur(depth+1, idx+1)+triangle[depth][idx]);

        dp[depth][idx] = Math.max(recur(depth+1, idx)+triangle[depth][idx],
                recur(depth+1, idx+1)+triangle[depth][idx]);

        return dp[depth][idx];
        }

}