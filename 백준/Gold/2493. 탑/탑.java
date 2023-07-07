import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int height[];
	static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		height = new int[N+1];
		height[0] = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Stack<Integer> s = new Stack<>();
		int idx = 0;
		for (int i = 1; i <= N; i++) {
//			System.out.println("=----------------"+i);
//			System.out.println(";;"+height[i]);
			if(height[i-1] > height[i]) { // 내려가면
//				System.out.println("내려가면");
				idx = i-1; //큰 건물의 번호를 큰쪽으로 바꿔좀 
				sb.append(idx).append(" ");
				s.push(i-1);
			}else { //올라가면
//				System.out.println("올라가면");
				if(height[idx] > height[i]) { //내가 지정하고 있는 큰 건물과 높이 비교 
					sb.append(idx).append(" ");
				}else { // 내가 지정하고 있는 큰 건물보다 크면 이전의 더 큰 건물 찾기
					int j = idx;
//					System.out.println(height[i]);
//					System.out.println(j);
					while (!s.isEmpty()) {
//						System.out.println(s.toString());
						j = s.peek();
						if(height[j] > height[i]) {
							idx = j;
							break;
						}else {
							s.pop();
						}
					}
					sb.append(idx).append(" ");
				}
				
			}
			
		}
		System.out.println(sb.toString());
		
	
	
		
	}

}