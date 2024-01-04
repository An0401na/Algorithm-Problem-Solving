import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    static long reverseN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        if(!isPrime(N)){
            System.out.println("no");
            return;
        }

        while (N != 0){
            long num = N % 10;
            N /= 10;
            if(num == 3 || num == 4 || num == 7 ){
                System.out.println("no");
                return;
            }
            if (num == 6L) {
                num = 9L;
            }else if (num == 9L){
                num = 6L;
            }
            if(reverseN == 0){
                reverseN = num;
            }else {
                reverseN = reverseN * 10 + num;
            }
        }

        if(!isPrime(reverseN)){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }

    }

    private static boolean isPrime(long number) {
        if (number == 1){
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}