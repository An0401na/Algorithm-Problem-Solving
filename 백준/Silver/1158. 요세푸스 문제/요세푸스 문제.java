import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static ArrayList<Integer> num = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		for (int i = 1; i <= N; i++) {
			num.add(i);
		}
		sb.append("<");
		Josephus(-1);
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		
		System.out.println(sb.toString());
		
	}
	static void Josephus(int idx) {
		int count =0;
		while (!num.isEmpty()) {
			for (int i = 0; i < K; i++) {
				idx ++;
				if(idx >= num.size()) {
					idx = 0;
				}
			}
			sb.append(num.get(idx)).append(", ");
			num.remove(idx);
			count++;
			idx--;
			
		}
		
	}
	
}