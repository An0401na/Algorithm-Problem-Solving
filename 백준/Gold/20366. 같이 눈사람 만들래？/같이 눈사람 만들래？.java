import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int snow[];
    static ArrayList<Snowman> snowmans;

    static class Snowman implements Comparable<Snowman> {
        int headSnowIdx;
        int bodySnowIdx;
        int hight;
        public Snowman(int head, int body, int hight){
            this.headSnowIdx = head;
            this.bodySnowIdx = body;
            this.hight = hight;
        }


        @Override
        public int compareTo(Snowman o) {
            return this.hight - o.hight;
        }
    }
    static int min = Integer.MAX_VALUE;
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

         snow = new int[N];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
             snow[i] = Integer.parseInt(st.nextToken());
         }

         snowmans = new ArrayList<>();
         for (int i = 0; i < N; i++) {
             for (int j = i+1; j < N; j++) {
                 snowmans.add(new Snowman(i , j, snow[i]+snow[j]));
             }
         }

         Collections.sort(snowmans);



         for (int i = 0; i < snowmans.size()-1; i++) {
             Snowman snowman = snowmans.get(i);
             Snowman nextSnowman = snowmans.get(i+1);
             int snow1 = snowman.bodySnowIdx;
             int snow2 = snowman.headSnowIdx;
             int snow3 = nextSnowman.bodySnowIdx;
             int snow4 = nextSnowman.headSnowIdx;
             if(snow1 != snow3 && snow1 != snow4 && snow2 != snow3 && snow2 != snow4){
                 min = Math.min(min, nextSnowman.hight - snowman.hight);
             }

         }

         System.out.println(min);


     }

}