class Solution {
    static int k;
    static int[][] dungeons;
    static int size;
    static int max;
    static boolean visited[];
    public int solution(int kk, int[][] d) {
        k = kk;
        dungeons = d;
        size = dungeons.length;
        visited = new boolean[size];
        
        dfs(0, k, 0);
        return max;
    }
    public void dfs(int n, int curK, int cnt){
        if(n == size){
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i = 0; i < size; i ++){
            if(visited[i]) continue;
            visited[i] = true;
            if(curK >= dungeons[i][0]){
                dfs(n+1, curK-dungeons[i][1], cnt+1);
            }else{
                dfs(n+1, curK, cnt);
            }
            visited[i] = false;
        }
    }
}