import java.io.*;
import java.util.Arrays;

public class Main {
	static int T;
	static char [] enc;
	static int [] passwd;
	static int [] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		 for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			enc = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				enc[i]= str.charAt(i);
			}
			str = br.readLine();
			passwd =new int[26];
			count = new int[26];
			for (int i = 0; i < str.length(); i++) {
				passwd[str.charAt(i)-'a']++;
			}
			
			int size = str.length();
			int len = enc.length;
			for (int i = 0; i < size; i++) {
				count[enc[i]-'a']+=1;
			}
			if(check()) {
				System.out.println("YES");
				continue ;
			}
			boolean flag = false;
			for (int i = size; i < len; i++) {
				count[enc[i-size]-'a']-=1;
				count[enc[i]-'a']+=1;
				
				if(check()) {
					flag= true;
					break;
				}
			}
			if(flag) {
				System.out.println("YES");
				continue;
			}
			
			System.out.println("NO");
		}
		
		
	}
	/*
	 * Anagram
	 * 윈도우의 크기 -> 비밀번호의 길이
	 * 암호화된 비밀번호를 1씩 이동해가며 윈도우의 크기만큼 확인한다.
	 * 확인해야 할 것은 윈도우 크기만큼에 해당하는 구간의 사용한 알파벳의 개수이다.
	 * a ~ z까지를 인덱스로 하는 int형 배열을 만들자
	 * 그리고 윈도우를 하나씩 이동할때에는 이동전 0번째 알파벳의 사용횟수를 -1해주고
	 * 이동 후 가장 마지막 알파벳의 사용횟수를 +1 해주는 식으로 하여
	 * 이전 결과를 써먹을 수 있도록 접근하자.
	 */
	
	
	//비밀번호에 있는 알파벳이 모두 count 되었는지 확인하는 함수
	static boolean check() {
		for (int i = 0; i < count.length; i++) {
			if(count[i] != passwd[i] ) {
				return false;
			}
		}
		return true;
	}

}