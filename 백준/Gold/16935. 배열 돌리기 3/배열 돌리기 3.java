import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int R;
    static int [][]board;
    static int originBoard[][];
    static int opers[];
    static int [][] dir = {{0, 1}, {1, 0}, {0,-1},{-1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        opers = new int[R];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            operation(opers[i]);
        }

        printBoard(board);
    }

    private static void operation(int oper) {
        originBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            originBoard[i] = Arrays.copyOf(board[i], M);
        }

        switch (oper){
            case 1:
                flipVertical(); // 상하반전
                break;
            case 2:
                flipHorizontal(); //좌우반전
                break;
            case 3:
                turnRight(); // 오른쪽으로 90도 회전
                break;
            case 4:
                turnLeft(); //왼쪽으로 90도 회전
                break;
            case 5:
                moveRight(); // 4분할 해서 오른쪽 방향으로 이동
                break;
            case 6:
                moveLeft(); //4분할 해서 왼쪽 방향으로 이동
                break;

        }
    }

    private static void moveLeft() {
        int start[][] = {{N/2, 0},{N/2, M/2}, {0, M/2},{0,0}};

        for (int i = 0; i < 4; i++) {
            int cur[] = start[i];
            int next[] = start[i+1 != 4 ? i+1:0];
            for (int r = 0; r < N/2; r++) {
                for (int c = 0; c < M/2; c++) {
                    board[next[0]+r][next[1]+c] = originBoard[cur[0]+r][cur[1]+c];
                }
            }
        }
    }

    private static void moveRight() {
        int start[][] = {{0,0},{0, M/2},{N/2, M/2}, {N/2, 0}};

        for (int i = 0; i < 4; i++) {
            int cur[] = start[i];
            int next[] = start[i+1 != 4 ? i+1:0];
            for (int r = 0; r < N/2; r++) {
                for (int c = 0; c < M/2; c++) {
                    board[next[0]+r][next[1]+c] = originBoard[cur[0]+r][cur[1]+c];
                }
            }
        }
    }

    private static void turnRight() {
        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = originBoard[N-j-1][i];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
    }

    private static void turnLeft() {
        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = originBoard[j][M-i-1];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
    }

    private static void flipHorizontal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = originBoard[i][M-j-1];
            }
        }
    }

    private static void flipVertical() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = originBoard[N-i-1][j];
            }
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