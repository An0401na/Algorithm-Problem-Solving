import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int sheepFeed; // 양의 사료 양
    static int goatFeed; // 염소 사료 양

    static int totalNumber; // 양 + 염소 전체 마리수
    static int totolFeed; // 어제 소비한 전체 사료의 양

    static int sheep; // 구해야하는 양의 마리 수
    static int goat; // 구해야하는 염소의 마리 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sheepFeed = Integer.parseInt(st.nextToken());
        goatFeed = Integer.parseInt(st.nextToken());

        totalNumber = Integer.parseInt(st.nextToken());
        totolFeed = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 1; i < totalNumber; i++) {
            if(i*sheepFeed + (totalNumber - i)*goatFeed == totolFeed) {
                sheep = i;
                goat = totalNumber - i;
                cnt ++;
            }
        }

        if(cnt != 1) {
            System.out.println(-1);
        }else{
            System.out.println(sheep+" "+goat);
        }

    }
}