import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        boolean usedNum[] = new boolean[10];
        int n;
        int cnt = 0;
        int resultNumber = 0;
        int k, i;
        Set<Integer> keySet;
        int number;
        int max = 1;
        map.put(1,1);
        while (true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            if(n <= max){
                System.out.println(map.get(n));
                continue;
            }else{
                cnt = max;
                resultNumber = map.get(cnt);

            }
//            keySet = map.keySet();
//            for (Integer key : keySet) {
//                if (key < n && cnt < key){
//                    cnt = key;
//                    resultNumber = map.get(key);
//                }
//            }



            Loop1: while (cnt != n){
                resultNumber++;
                number = resultNumber;
                Arrays.fill(usedNum, false);
//                for (int i = 0; i < resultNumberStr.length(); i++) {
//                    k = resultNumberStr.charAt(i)-48;
//                    if(usedNum[k]) { // 이미 사용한 숫자가 나왔다면
//                        continue Loop1;
//                    }
//                    usedNum[k] = true;
//                }
                i = 1;
                while ( number != 0){
                    k = number % 10;
                    number = number / 10 ;
                    i++;
                    if(usedNum[k]) { // 이미 사용한 숫자가 나왔다면
                        continue Loop1;
                    }
                    usedNum[k] = true;
                }
                cnt ++;
                map.put(cnt,resultNumber);
            }
            System.out.println(resultNumber);
            max = max < cnt ? cnt : max;
        }
    }
}


//1 int -> 4 byte
//100000 * 4 byte -> 4000000 byte
//4000KB
//4MB
//128MB 에서는 약 3천만개 정도의 int 선언가능