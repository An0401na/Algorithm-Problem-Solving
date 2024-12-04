import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static class Oper{
        int r;
        int c;
        int s;

        @Override
        public String toString() {
            return "Oper{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    '}';
        }

        public Oper(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static Oper[] opers;
    static boolean isUsed[];
    static int[][] newBoard;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [][]board = new int[N+1][M+1];
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        opers = new Oper[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            opers[i] = new Oper(r, c, s);
        }

        isUsed = new boolean[K];

        dfs(0, board);

        System.out.println(min);
    }
    public static void dfs(int cur, int [][] board){
        if(cur >= K){
            min = Math.min(min, getArrayValue(board));
            return;
        }
//        System.out.println("cur : " + cur);
//        printBoard(board);

        int[][] originBoard = new int[N+1][M+1];
        for (int i = 0; i < N+1; i++) {
            originBoard[i] = Arrays.copyOf(board[i], M+1);
        }

        for (int i = 0; i < K; i++) {
            if(isUsed[i]) continue;
            isUsed[i] = true;
//            System.out.println("newboard : "+ opers[i].toString());
            newBoard = operBoard(i, board);
//            printBoard(board);
//            printBoard(newBoard);
            dfs(cur+1, newBoard);
            for (int j = 0; j < N+1; j++) {
                board[j] = Arrays.copyOf(originBoard[j], M+1);
            }
            isUsed[i] = false;
        }
    }

    private static int getArrayValue(int[][] board) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M ; j++) {
                sum += board[i][j];
            }
            min = Math.min(min, sum);
        }
//        System.out.println("---- 결과");
//        printBoard(board);
//        System.out.println(min);
//        System.out.println();
        return min;
    }

    public static int[][] operBoard(int operNum, int[][] board){
        Oper oper = opers[operNum];

        for (int s = 1; s <= oper.s; s++) {
            int up = oper.r - s;
            int bottom = oper.r + s;
            int left = oper.c - s;
            int right = oper.c + s;
            board = turnBoard(board, up, left, bottom, right);
        }

        return board;
    }

    private static int[][] turnBoard(int[][] board, int up, int left, int bottom, int right) {
        int tmp = board[up][left];

        //왼쪽 열 위로 한칸씩
        for (int i = up; i < bottom; i++) {
            board[i][left] = board[i+1][left];
        }
        //아래 행 왼쪽으로 한칸씩
        for (int i = left; i < right; i++) {
            board[bottom][i] = board[bottom][i+1];
        }
        //오른쪽 열 아래로 한칸씩
        for (int i = bottom; i > up; i--) {
            board[i][right] = board[i-1][right];
        }
        //위 행 오른쪽으로 한칸씩
        for (int i = right; i > left; i--) {
            board[up][i] = board[up][i-1];
        }

        board[up][left +1] = tmp;

        return board;
    }

    public static void printBoard(int[][] board){
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}