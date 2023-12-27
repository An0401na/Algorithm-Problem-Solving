import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int height[];

    static int result[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        height = new int[9];
        result = new int[7];
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

    }

    static void dfs(int idx, int start){
        if(idx == 7){
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += result[i];
            }
            if(sum == 100) {

                Arrays.sort(result);
                for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < height.length; i++) {
            result[idx] = height[i];
            dfs(idx+1, i+1);
        }
    }
}