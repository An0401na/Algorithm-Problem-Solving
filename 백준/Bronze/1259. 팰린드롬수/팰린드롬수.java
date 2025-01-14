import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str = br.readLine();
            if(str.equals("0")) break;


            int end = str.length()-1;

            boolean flag = false;

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != str.charAt(end - i)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }

        }
    }
}
