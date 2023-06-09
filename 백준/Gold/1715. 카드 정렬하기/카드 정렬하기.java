import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue(); 
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		
		while (pq.size()>1) {
			int a= pq.poll();
			int b= pq.poll();
			int count = a+b;
//			System.out.println("a : " + a+", b : "+b+", count : "+count);
			sum += count;
//			System.out.println("sum : "+sum);
//			System.out.println();
  			pq.add(count);
		}
		
		System.out.println(sum);
	}

}