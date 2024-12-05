import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int R;
    static int [][]board;
    static int [][] dir = {{0, 1}, {1, 0}, {0,-1},{-1, 0}};
    static int newBoard[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        newBoard = new int[N][M];
        int cnt = Math.min(N, M) / 2;
        for (int i = 0; i < cnt; i++) {
            turnBoard(i);
        }

        printBoard(newBoard);
    }
    private static void turnBoard(int layer) {
        int up = layer;
        int bottom = N - layer;
        int left = layer;
        int right = M - layer;

        int length = (bottom-up)*2 + (right-left)*2 - 4;
        int tmp[] = new int[length];


        int r = layer;
        int c = layer;
        int d = 0;

        int cnt = R % length;
        for (int i = 0; i < cnt; i++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(!(nr >= up && nr < bottom && nc >= left && nc < right)){ // 넘어가면
                d = d+1 < 4 ? d+1 : 0;
                nr = r + dir[d][0];
                nc = c + dir[d][1];
            }
            r = nr;
            c = nc;
        }

        for (int i = 0; i < length; i++) {
            tmp[i] = board[r][c];
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(!(nr >= up && nr < bottom && nc >= left && nc < right)){ // 넘어가면
                d = d+1 < 4 ? d+1 : 0;
                nr = r + dir[d][0];
                nc = c + dir[d][1];
            }
            r = nr;
            c = nc;
        }

        r = layer;
        c = layer;
        d = 0;
        for (int i = 0; i < length; i++) {
            newBoard[r][c] = tmp[i];
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(!(nr >= up && nr < bottom && nc >= left && nc < right)){ // 넘어가면
                d = d+1 < 4 ? d+1 : 0;
                nr = r + dir[d][0];
                nc = c + dir[d][1];
            }
            r = nr;
            c = nc;
        }

    }

    public static void printBoard(int[][] board){
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}