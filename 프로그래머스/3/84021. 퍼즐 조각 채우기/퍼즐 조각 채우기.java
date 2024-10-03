import java.util.*;

class Block{
    int cnt;//칸의 개수
    int[][] shape = new int[6][2];//모양
}

class Solution {
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        //1. 퍼즐 찾기
        List<Block> puzzles = new LinkedList<>();
        findBlocks(table, puzzles, 1, 0);
        
        //2. 빈칸 찾기
        List<Block> blanks = new ArrayList<>();
        findBlocks(game_board, blanks, 0, 1);
        
        //3. 빈칸에 퍼즐 넣을 수 있는지 보기
        for(Block blank : blanks){
            for(Block puzzle : puzzles){
                if(canInsert(puzzle, blank)){
                    answer+=puzzle.cnt;
                    puzzles.remove(puzzle);
                    //사용할 퍼즐이 더이상 없다면 종료
                    if(puzzles.size() == 0){
                        return answer;
                    }
                    break;
                }
            }
        }
            
        return answer;
    }
    
    public void findBlocks(int[][] map, List<Block> list, int flag, int nflag){
        int n = map.length;
        int m = map[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == flag){
                    list.add(findOne(map, n, m, i, j, flag, nflag));
                }
            }
        }
    }
    
    //block 하나 찾기
    public Block findOne(int[][] map, int n, int m, int x, int y, int flag, int blank){
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Block block = new Block();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = blank;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            block.shape[block.cnt++] = now;
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == blank){
                    continue;
                }
                map[nx][ny] = blank;
                q.add(new int[]{nx, ny});
            }
        }
        
        //해당 블럭에서 가장 앞에 있는 블럭을 0,0으로 맞추기
        setCenter(block);
        return block;
    }
    
    public boolean canInsert(Block puzzle, Block blank){
        if(puzzle.cnt != blank.cnt){return false;}
        
        int size = puzzle.cnt;
        
        for(int i=0; i<3; i++){
            //맞는 퍼즐 찾으면 return true, 아니면 회전시켜보기
            if(isSameShape(size, puzzle.shape, blank.shape)){
                return true;
            }
            turn(puzzle);
        }
        if(isSameShape(size, puzzle.shape, blank.shape)){
            return true;
        }
        return false;
    }
    
    public boolean isSameShape(int size, int[][] shape1, int[][] shape2){
        for(int j=0; j<size; j++){
            int k = 0;
            for(; k<size; k++){
                if(shape1[j][0] == shape2[k][0]
                   && shape1[j][1] == shape2[k][1]){
                    break;
                }
            }
            if(k==size){
                return false;
            }
        }
        return true;
    }
    
    //90도 회전
    public void turn(Block block){
        for(int i=0; i<block.cnt; i++){
            int temp = -block.shape[i][0];
            block.shape[i][0] = block.shape[i][1];
            block.shape[i][1] = temp;
        }
        setCenter(block);
    }
    
    public void setCenter(Block block){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        //해당 블럭에서 가장 앞에 있는 블럭 찾기
        for(int i=0; i<block.cnt; i++){
            if(block.shape[i][0] < minX){
                minX = block.shape[i][0];
                minY = block.shape[i][1];
            }
            else if(block.shape[i][0] == minX && block.shape[i][1] < minY){
                minY = block.shape[i][1];
            }
        }
        
        for(int i=0; i<block.cnt; i++){
            block.shape[i][0] -= minX;
            block.shape[i][1] -= minY;
        }
    }
    
}