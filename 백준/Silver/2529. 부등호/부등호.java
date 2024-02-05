import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char sign[];
    static int[][] nums;

    static boolean flag;
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        isVisited = new boolean[10];
        nums = new int[2][k+1];

        flag = false;
        getMaxResult(0);
        flag = false;
        Arrays.fill(isVisited, false);
        getMinResult(0);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < k+1; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
    public static void getMaxResult(int depth){
        if(depth == k+1 ){
            flag = true;
            return;
        }


        for (int i = 9; i >= 0; i--) {
            if(flag) break;
            if(depth != 0){
                if(!isVisited[i] && isOk(depth-1, i, 0)){
                    isVisited[i] = true;
                    nums[0][depth] = i;
                    getMaxResult(depth+1);
                    isVisited[i] = false;
                }
            }else{
                isVisited[i] = true;
                nums[0][depth] = i;
                getMaxResult(depth+1);
                isVisited[i] = false;
            }
        }
    }

    public static void getMinResult(int depth){
        if(depth == k+1 ){
            flag = true;
            return;
        }


        for (int i = 0; i < 10; i++) {
            if(flag) break;
            if(depth != 0){
                if(!isVisited[i] && isOk(depth-1, i, 1)){
                    isVisited[i] = true;
                    nums[1][depth] = i;
                    getMinResult(depth+1);
                    isVisited[i] = false;
                }
            }else{
                isVisited[i] = true;
                nums[1][depth] = i;
                getMinResult(depth+1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean isOk(int idx, int num, int maxmin) {
        if(sign[idx] == '<' ){
            return nums[maxmin][idx] < num;
        }else{
            return nums[maxmin][idx] > num;
        }
    }
}