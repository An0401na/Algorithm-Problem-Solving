import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int input[];
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = new int[10];
        for (int i = 0; i < 10; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        sum = input[0];
        for (int i = 1; i < 10; i++) {
            if(Math.abs(sum-100) >= Math.abs(sum+input[i]-100)) {
                sum += input[i];
            }else{
                break;
            }
        }
        System.out.println(sum);

    }
}