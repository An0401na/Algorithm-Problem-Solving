import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int num[];
    static int cnt;
    static int len = 8;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[len];

        recur(0, 0, false);
    }
    private static void recur(int depth, int sixCnt, boolean isok) {
        if (depth == len) {
            if(isok){
                cnt++;
//                boolean flag = true;
//                for (int i = 0; i < len; i++) {
//                    if(num[i] == 0 && flag){
//                        continue;
//                    }
//                    flag = false;
//                    System.out.print(num[i]);
//                }
//                System.out.println();
//                if(cnt % 10 == 0){
//                    System.out.println();
//                }

                if(cnt == N){
                    boolean flag = true;
                    for (int i = 0; i < len; i++) {
                        if(num[i] == 0 && flag){
                            continue;
                        }
                        flag = false;
                        System.out.print(num[i]);
                    }
                    System.exit(0);
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            num[depth] = i;
            if(i == 6){
                recur(depth+1, sixCnt+1, sixCnt +1 == 3 ? true : isok);
            }else{
                recur(depth+1, 0, isok);
            }
        }

    }
}
