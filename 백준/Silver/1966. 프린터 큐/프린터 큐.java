import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static int TC;
    static int N;
    static int M;
    static Queue<Document> q;
    static class Document{
        int num;
        int priority;
        public Document(int num, int priority){
            this.num = num;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "num=" + num +
                    ", priority=" + priority +
                    '}';
        }
    }
    static int priority[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for(int t = 0; t < TC; t ++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            priority = new int[N];
            q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i =0; i < N; i++){
                priority[i] = Integer.parseInt(st.nextToken());
                q.add(new Document(i, priority[i]));
            }


            Document next;
            int cnt = 0;
            int max = getMax();
            while (!q.isEmpty()){
                next = q.poll();
                if(next.priority < max){
                    q.add(new Document(next.num, next.priority));
                }else{
                    cnt++;
                    if(next.num == M) break;
                    priority[next.num] = 0;
                    max = getMax();
                }
            }
            System.out.println(cnt);
        }
    }
    public static int getMax(){
        int max = 0;
        for (int i = 0; i < priority.length; i++) {
            max = Math.max(max, priority[i]);
        }
        return max;
    }
}
