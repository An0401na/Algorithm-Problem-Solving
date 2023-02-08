import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L;
	static int C;
	static String p [] ;
	static String result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		p = new String[C];
		result= new String[L];
		for (int i = 0; i < C; i++) {
			p[i] =sc.next();
		}
		Arrays.sort(p);
		combi(0,0);
	}


	private static void combi(int cnt, int start) {
		if(cnt==L) {
			if(zeromoun()) return;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				if(result[i]!=null) {
					sb.append(result[i]);
				}
			}
			System.out.println(sb);
			return;
		}
		for (int i = start ; i < C; i++) {
			result[cnt] = p[i];
			combi(cnt+1,i+1);
		}
		
	}


	static boolean zeromoun() {
		int count = 0;
		for (int i = 0; i < L; i++) {
			if(result[i].equals("a") || result[i].equals("e")
						 || result[i].equals("i")
				|| result[i].equals("o") || result[i].equals("u")) {
					count++;
				}
		}
		if(!(count>0 && L-count>1)) return true;
		return false;
	}

}
