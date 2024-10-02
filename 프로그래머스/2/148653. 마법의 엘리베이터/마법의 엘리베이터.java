class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int s) {

        dfs(s, 0);

        return min;
    }

    private void dfs(int s, int cnt) {
        if(s <= 1 ) {
            min = Math.min(min, cnt+s);
            return ;
        }
        int num = s % 10;
        dfs((s / 10)+1, cnt +(10 - num));
        dfs(s / 10, cnt +num);

    }
}