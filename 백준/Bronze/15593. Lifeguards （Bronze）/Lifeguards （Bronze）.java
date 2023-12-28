import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Time lgTime[];

    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Time o) {
            if(this.start == o.start){
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(this.start, o.start);
        }
    }
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        lgTime = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lgTime[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lgTime);

        max = 0;

        for (int i = 0; i < N; i++) {
            int time = 0;
            int preEnd = 0;
            for (int j = 0; j < N; j++) {
                if(i == j || preEnd > lgTime[j].end) continue;

                int start = lgTime[j].start;
                int end = lgTime[j].end;

                if(time == 0){
                    time = end - start;
                    preEnd = end;
                    continue;
                }

                if(preEnd > lgTime[j].start){
                    start = preEnd;
                }

                time += end - start;
                preEnd = end;
            }
            if(max < time) max = time;
        }

        System.out.println(max);

    }
}