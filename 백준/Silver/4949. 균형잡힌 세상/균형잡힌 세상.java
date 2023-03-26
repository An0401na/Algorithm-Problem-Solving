import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static char[] string;
	static ArrayList<Character> op;
	static Stack<Character> st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			string = str.toCharArray();
			
			op = new ArrayList<>();
			for (int i = 0; i < string.length; i++) {
				if(string[i] == '(' || string[i] == ')'||string[i] == '['||string[i] == ']') {
					op.add(string[i]);
				}
			}
			
			if(op.size()==0) {
				System.out.println("yes");
				continue;
			}
//			if(op.size()%2 == 1){
//				System.out.println("no");
//				continue;
//			}
//			if(op.get(0) == ')' ||op.get(0) == ']') {
//				System.out.println("no");
//				continue;
//			}
//			if(op.get(op.size()-1) == '(' ||op.get(op.size()-1) == '[') {
//				System.out.println("no");
//				continue;
//			}
			
			
			st = new Stack<>();
			for (int i = 0; i < op.size(); i++) {
				if(op.get(i) == ')' ) {
					if(st.size() !=0 && st.peek() == '(' ) {
						st.pop();
						continue;
					}
				}
				if(op.get(i) == ']' ) {
					if(st.size() !=0 && st.peek() == '[' ) {
						st.pop();
						continue;
					}
				}
				st.push(op.get(i));
			}
			if(st.size()!=0) {
				System.out.println("no");
				continue;
			}
			System.out.println("yes");
			
		}
		
		
	}

}