import java.util.*;

class Point{
    int r;
    int c;
    
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    static int H;
    static int W;
    static char map[][];
    static boolean visited[][];
    static int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static ArrayList<Integer> days = new ArrayList<>();
    public int[] solution(String[] maps) {
        H = maps.length;
        W = maps[0].length();
        
        map = new char[H][W];
        visited = new boolean[H][W];
        
        for(int i = 0; i < H; i++){
            map[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < H; i ++ ){
            for(int j = 0; j < W; j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    days.add(bfs(i, j));
                }
            }
            
        }
        
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for(int i =0; i < days.size(); i++){
            answer[i] = days.get(i);
        }
        
        if(days.size() == 0) {
            return new int[] {-1};
        }
        
        return answer;
    }
    
    static boolean isInRange(int r, int c ){
        return r < H && r >=0 && c < W && c >=0;
    }
    
    static int bfs(int r, int c ){
        int day = map[r][c] -'0';
        visited[r][c] = true;
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(r,c));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int d =0; d < 4; d++){
                int nr = p.r + dir[d][0];
                int nc = p.c + dir[d][1];
                
                if(isInRange(nr, nc)){
                    if(!visited[nr][nc] && map[nr][nc] !='X'){
                        visited[nr][nc] = true;
                        day += map[nr][nc] - '0';
                        q.add(new Point(nr, nc));
                    }
                }
            }
            
        }
        return day;
        
    }
}