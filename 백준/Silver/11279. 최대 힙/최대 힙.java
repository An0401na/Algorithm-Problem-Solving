import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o2-o1;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int x ;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
                continue;
            }
            pq.add(x);
        }
    }
}