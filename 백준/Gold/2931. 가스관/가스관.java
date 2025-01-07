import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char board[][];
    static class Point{
        int r;
        int c;
        int d;

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static Point start;
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},}; // 상, 하, 좌, 우
    static char pipe[] = {'|', '-','+','1','2','3','4'};
    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 'M'){
                    start = new Point(i, j, 0);
                }
            }
        }


        for (int d = 0; d < dir.length; d++) {
            int nr = start.r + dir[d][0];
            int nc = start.c + dir[d][1];
            if(!isInRange(nr, nc)) continue;
            if(board[nr][nc] != '.'){
                start.d = d;
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '.') {
                    for (int p = 0; p < pipe.length; p++) {
                        board[i][j] = pipe[p];
                        visited = new boolean[R][C];

                        if(isConnected()){
                            System.out.println((i+1)+" "+(j+1) +" "+board[i][j]);
                            return;
                        }
                    }
                    board[i][j] = '.';
                }
            }
        }
    }
    public static boolean isConnected(){

        Point cur = new Point(start.r + dir[start.d][0], start.c + dir[start.d][1], start.d);
        while(board[cur.r][cur.c] != 'Z'){
            visited[cur.r][cur.c] = true;

            Point next = findPipe(cur);
            if(next == null) {
                return false;
            }
            if(!isInRange(next.r, next.c)) {
                return false;
            }
            cur = next;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] != '.' && board[i][j] != 'M' && board[i][j] != 'Z'){
                    if(!visited[i][j]){ // 파이프가 있는데 방문하지 않았다면
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static Point findPipe(Point cur){
        Point next = null;
        switch (board[cur.r][cur.c]){
            case '|':
                next = vertical(cur);
                break;
            case '-':
                next = horizontal(cur);
                break;
            case '+':
                next = intersection(cur);
                break;
            case '1': // ┌
                next = one(cur);
                break;
            case '2': // └
                next = two(cur);
                break;
            case '3':  // ┘
                next = three(cur);
                break;
            case '4': // ┐
                next = four(cur);
                break;
        }
        return next;
    }
    private static Point intersection(Point cur) {// +
        if(cur.d == RIGHT){ // 아래에서 위로 올라오는 경우, 방향을 위으로
            return new Point(cur.r + dir[RIGHT][0], cur.c + dir[RIGHT][1], RIGHT);
        } else if (cur.d == LEFT) {
            // 위에서 아래로 내려오는 경우, 방향을 아래로
            return new Point(cur.r + dir[LEFT][0], cur.c + dir[LEFT][1], LEFT);
        }else if(cur.d == UP){ // 아래에서 위로 올라오는 경우, 방향을 위으로
            return new Point(cur.r + dir[UP][0], cur.c + dir[UP][1], UP);
        } else if (cur.d == DOWN) {
            // 위에서 아래로 내려오는 경우, 방향을 아래로
            return new Point(cur.r + dir[DOWN][0], cur.c + dir[DOWN][1], DOWN);
        }
        return null;
    }
    private static Point horizontal(Point cur) {// -
        if(cur.d == RIGHT){ // 아래에서 위로 올라오는 경우, 방향을 위으로
            return new Point(cur.r + dir[RIGHT][0], cur.c + dir[RIGHT][1], RIGHT);
        } else if (cur.d == LEFT) {
            // 위에서 아래로 내려오는 경우, 방향을 아래로
            return new Point(cur.r + dir[LEFT][0], cur.c + dir[LEFT][1], LEFT);
        }
        return null;
    }
    private static Point vertical(Point cur) {// |
        if(cur.d == UP){ // 아래에서 위로 올라오는 경우, 방향을 위으로
            return new Point(cur.r + dir[UP][0], cur.c + dir[UP][1], UP);
        } else if (cur.d == DOWN) {
            // 위에서 아래로 내려오는 경우, 방향을 아래로
            return new Point(cur.r + dir[DOWN][0], cur.c + dir[DOWN][1], DOWN);
        }
        return null;
    }
    private static Point four(Point cur) { // ┐
        if(cur.d == UP){ // 아래에서 위로 올라오는 경우, 방향을 좌측으로
            return new Point(cur.r + dir[LEFT][0], cur.c + dir[LEFT][1], LEFT);
        } else if (cur.d == RIGHT) {
            // 좌측에서 우측으로 오는 경우, 방향을 아래쪽으로
            return new Point(cur.r + dir[DOWN][0], cur.c + dir[DOWN][1], DOWN);
        }
        return null;
    }
    private static Point three(Point cur) { // ┘
        if(cur.d == DOWN){ // 위에서 아래로 내려오는 경우, 방향을 좌측으로
            return new Point(cur.r + dir[LEFT][0], cur.c + dir[LEFT][1], LEFT);
        } else if (cur.d == RIGHT) {
            // 좌측에서 우측으로 오는 경우, 방향을 위쪽으로
            return new Point(cur.r + dir[UP][0], cur.c + dir[UP][1], UP);
        }
        return null;
    }
    private static Point two(Point cur) { // └
        if(cur.d == DOWN){ // 위에서 아래로 내려오는 경우, 방향을 우측으로
            return new Point(cur.r + dir[RIGHT][0], cur.c + dir[RIGHT][1], RIGHT);
        }else if (cur.d == LEFT){
            // 우측에서 좌측으로 오는 경우, 방향을 위쪽으로
            return new Point(cur.r + dir[UP][0], cur.c + dir[UP][1], UP);
        }
        return null;
    }
    private static Point one(Point cur) { // ┌
        if(cur.d == UP){ // 아래에서 위로 올라오는 경우, 방향을 우측으로 변경
            return new Point(cur.r + dir[RIGHT][0], cur.c + dir[RIGHT][1], RIGHT);
        }else if (cur.d == LEFT){
            //우측에서 좌측으로 오는 경우, 방향을 아래로 변경
            return new Point(cur.r + dir[DOWN][0], cur.c + dir[DOWN][1], DOWN);
        }
        return null;
    }
    public static boolean isInRange(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
