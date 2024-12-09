import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int board[][];
    static boolean visited[][];
    static int dir[][] = {{1,0}, {-1,0}, {0,1},{0,-1}};
    static int start[];
    static int end[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        start = new int[2];
        end = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            start[i] = Integer.parseInt(st.nextToken())-1;
        }
        for (int i = 0; i < 2; i++) {
            end[i] = Integer.parseInt(st.nextToken())-1;
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int a = 0;
                switch (str.charAt(j)){
                    case '*':
                        a = 2;
                        break;
                    case '#':
                        a = 3;
                        break;
                    case '1':
                        a = 1;
                        break;
                }
                board[i][j] = a;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        int cnt = 0;

        boolean catched = false;
        while (!catched){
            cnt++;
//            System.out.println("cnt : " + cnt +", catched : " + catched);
            q.add(new int[]{start[0], start[1]});
            visited = new boolean[N][M];
            while (!q.isEmpty()){
                int[] now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];

                    if(!isInRange(nr, nc)) continue;

                    if(visited[nr][nc]) continue;
                    visited[nr][nc] = true;

                    if(board[nr][nc] == 0 ){
                        q.add(new int[]{nr, nc});
                    }else if(board[nr][nc] == 1 ){
                        board[nr][nc] = 0;
                    }else if(board[nr][nc]==3){
                        catched = true;
                    }
                }
            }

//            printBoard();
//            System.out.println();
        }


        System.out.println(cnt);

    }
    public static boolean isInRange(int r, int c){
        return r >= 0 && c>=0 && r < N && c < M;
    }
    public static void printBoard(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
}