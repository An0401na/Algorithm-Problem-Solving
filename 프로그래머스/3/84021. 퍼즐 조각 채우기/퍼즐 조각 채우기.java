import java.util.*;
class Solution {
    
        static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        static class Point{
            int r;
            int c;
            public Point(int r, int c){
                this.r = r;
                this.c = c;
            }

            @Override
            public String toString() {
                return "Point{" +
                        "r=" + r +
                        ", c=" + c +
                        '}';
            }
        }

        static boolean isUsed[] = new boolean[1000]; // 보드의 길이가 최대 50이니까 퍼즐의 개수 최대 25개, 0인덱스 안쓰니까 +1
        static int puzzleSize[] = new int[1000];
        static int[][] gameBoard;
        static int[][] table;
        static int[][][] tables;
        static int N;
        public int solution(int[][] g, int[][] t) {
            gameBoard = g;
            table = t;

            N = table.length;
            int puzzleNum = 2; //0, 1은 이미 사용중이니까 2부터 표기


            // 퍼즐 번호 매기기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(table[i][j] ==1){
                        coloring(i, j, puzzleNum++);
                    }
                }
            }


            // ㅗ , ㅏ, ㅜ, ㅓ  한바퀴 돌린 보드 네개 만들기
            tables = new int[4][N][N];
            tables[0] = table;
            turnTable(table);
            for (int i = 1; i <= 3; i++) {
                tables[i] = turnTable(tables[i-1]);
            }




            /*
            game_board를 쭉 가면서 0을 만나면 테이블 탐색
            테이블에서 1이 아닌 숫자가 나오면 사용을 했는지 확인
            그 모양과 현재 게임보드 0과 모양이 같은지 확인
            => 큐에 담아서 확이
            같지 않다면 회전한 퍼즐에서도 확인
            다시 탐색하지 않도록 보드에서 0을 1로 칠하고 넘기기
            같다면 테이블에 찾은 퍼즐을 isused 체크하고
            넘기기
             */
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(gameBoard[i][j] == 0){ // 게임보드가 비어있다면 탐색
                        // 게임보드에 비어있는 모양대로 큐에 담으면서 보드 매꾸기 0 -> 1 (다시 탐색하지 않도록)
                        ArrayList<Point> q = addEmptyShape(i, j);
                        for (int k = 0; k < 4; k++) { // 회전된 4개의 테이블의 퍼즐들 확인
                            int fitPuzzleNum = findPuzzle(q, tables[k]); // 테이블에 들어맞는 퍼즐이 있다면 그 퍼즐 번호를 리턴/ 퍼즐이 없다면 0리턴
                            if(fitPuzzleNum != 0) {
                                isUsed[fitPuzzleNum] = true;
                                break;
                            }
                        }
                    }

                }
            }

            int answer = 0;
            for (int i = 0; i < 1000; i++) {
                if(isUsed[i]){
                    answer += puzzleSize[i];
                }
            }
            return answer;
        }

        private int findPuzzle(ArrayList<Point> emptyShape, int[][] table) {
            boolean isCheck[] = new boolean[1000];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(table[i][j] > 1 && !isCheck[table[i][j]]){
                        isCheck[table[i][j]] = true; // 확인한 퍼즐은 보지 않기 위해서 체크
                        
                        if(!isUsed[table[i][j]] && isFit(emptyShape, i, j, table)){
                            return table[i][j];
                        }
                    }
                }
            }
            return 0;
        }

        private boolean isFit(ArrayList<Point> emptyShape, int r, int c, int[][] table) {
            // 사이즈가 다르면 퍼즐 안맞음
            if(puzzleSize[table[r][c]] != emptyShape.size()){
                return false;
            }
            for (Point p : emptyShape) {
                int nr = r + p.r;
                int nc = c + p.c;
                if(!isInRange(nr, nc) || (table[nr][nc] != table[r][c])){
                    return false;
                }
            }

            return true;
        }


        // r, c 점을 기준으로 보드에 비어있는 퍼즐 모양을 큐에 담고(단 상대적인 좌표로 담음), 탐색한 퍼즐 모양은 재탐색을 방지하기 위해 1로 바꿈
        private ArrayList<Point> addEmptyShape(int r, int c) {
            ArrayList<Point> emptyShape = new ArrayList<>();
            Queue<Point> q = new LinkedList<>();


            q.add(new Point(r, c));
            while (!q.isEmpty()){
                Point p = q.poll();
                if(gameBoard[p.r][p.c] == 1) continue;
                gameBoard[p.r][p.c] = 1;
                emptyShape.add(new Point(p.r-r, p.c-c));
                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dir[d][0];
                    int nc = p.c + dir[d][1];
                    if(isInRange(nr, nc) && gameBoard[nr][nc] == 0){
                        q.add(new Point(nr, nc));
                    }
                }
            }

            return  emptyShape;
        }

        // 테이블에 들어맞는 퍼즐이 있다면 그 퍼즐 번호를 리턴/ 퍼즐이 없다면 0리턴
        private int[][] turnTable(int[][] table) {
            int newTable[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    newTable[j][N-i-1] = table[i][j];
                }
            }
            return  newTable;
        }


        private void coloring(int r, int c, int num) {
            Queue<Point> q = new LinkedList<>();
            int size = 0;
            q.add(new Point(r, c));
            table[r][c] = num;
            while (!q.isEmpty()){
                Point p = q.poll();
                size +=1;
                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dir[d][0];
                    int nc = p.c + dir[d][1];
                    if(isInRange(nr, nc) && table[nr][nc] == 1){
                        table[nr][nc] = num;
                        q.add(new Point(nr, nc));
                    }
                }
            }
            puzzleSize[num] = size;
        }

        private boolean isInRange(int nr, int nc) {
            return 0 <= nr && nr < N && 0 <= nc && nc < N;
        }
}