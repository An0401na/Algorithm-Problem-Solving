import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int arr[];
    static int total;
    public static void main(String[] args) throws IOException {
        arr = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        Arrays.sort(arr);

        Loop1: for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9 ; j++) {
                if(total - arr[i] - arr[j] == 100){
                    arr[i] = -1;
                    arr[j] = -1;
                    break Loop1;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(arr[i] != -1){
                System.out.println(arr[i]);
            }
        }

    }
}