import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 기타 개수
    static int M; // 곡의 개수
    static int minGuitarCnt = Integer.MAX_VALUE;
    static boolean [][] isPossible;
    static boolean[] check;
    static int maxSongCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isPossible = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String play = st.nextToken();
            for (int j = 0; j < M; j++) {
                if(play.charAt(j) == 'Y'){
                    isPossible[i][j] = true;
                }
            }
        }

        check = new boolean[M];
        powerset(0, 0, 0);
        System.out.println(minGuitarCnt == Integer.MAX_VALUE ? -1 : minGuitarCnt);

    }

    private static void powerset(int guitarIdx, int songCnt, int usedGuitarCnt) {
        if(guitarIdx == N){
            if(songCnt == 0) return;
            if(maxSongCnt < songCnt){
                maxSongCnt = songCnt;
                minGuitarCnt = usedGuitarCnt;
            } else if (maxSongCnt == songCnt) {
                minGuitarCnt = Math.min(minGuitarCnt, usedGuitarCnt);
            }
            return;
        }


        //기타 선택 X
        powerset(guitarIdx+1, songCnt, usedGuitarCnt);

        //기타 선택
        boolean newIsPossibleSong[] = Arrays.copyOf(check, check.length);
        for (int i = 0; i < M; i++) {
            if(isPossible[guitarIdx][i]){
                if(check[i]) continue;
                check[i] = true;
                songCnt++;
            }
        }
        powerset(guitarIdx+1, songCnt, usedGuitarCnt+1);
        check = Arrays.copyOf(newIsPossibleSong, newIsPossibleSong.length);

    }
}