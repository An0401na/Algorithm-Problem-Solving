import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	/* 스택을 활용
	 * 스택의 삽입, 삭제, 읽기 모드 O(1)
	 * 탐색은 O(n)
	 * 
	 * 커서 기준 왼쪽 스택과 오른쪽 스택을 나누어 구현
	 */
	static Stack<Character> leftStr;
	static Stack<Character> rightStr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		leftStr = new Stack<>();
		rightStr = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			leftStr.push(str.charAt(i));
		}
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			String op = br.readLine();
			
			switch (op.charAt(0)){
				case 'L': {
					if(!leftStr.isEmpty()) {
						rightStr.push(leftStr.pop());
					}
					break;
				}
				
				case 'D': {
					if(!rightStr.isEmpty()) {
						leftStr.push(rightStr.pop());
					}
					break;
				}
				
				case 'B': {
					if(!leftStr.isEmpty()) {
						leftStr.pop();
					}
					break;
				}
				
				case 'P': {
					char c = op.charAt(2);
					leftStr.push(c);
					break;
				}
			}
		}
		
		
		while (!leftStr.isEmpty()) {
			rightStr.push(leftStr.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while (!rightStr.isEmpty()) {
			sb.append(rightStr.pop());
		}
		
		System.out.println(sb.toString());
	}
}