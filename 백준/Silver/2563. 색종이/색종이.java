import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static Paper[] papers;

    static class Paper{
        int x;
        int y;

        @Override
        public String toString() {
            return "Paper{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        Paper(int x , int y){
            this.x = x;
            this.y = y;
        }

    }

    static int area;
    static final int BLACK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[100][100];
        papers = new Paper[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            papers[i] =new Paper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

//        System.out.println(Arrays.toString(papers));

        for (int i = 0; i < N; i++) {
            draw(papers[i].x, papers[i].y);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j] == BLACK){
                    area+=1;
                }
            }
        }

        /*for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }*/


        System.out.println(area);
    }

    static void draw(int x, int y){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[x+i][y+j] = BLACK;
            }
        }
    }

}