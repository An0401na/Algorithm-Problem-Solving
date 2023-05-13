import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static int N;
	static Str[] str;
	static class Str implements Comparable<Str>{
		String s;

		public Str(String s) {
			super();
			this.s = s;
		}

		@Override
		public int compareTo(Str o) {
			if(s.length()== o.s.length()) {
				return s.compareTo(o.s);
			}
			return s.length() - o.s.length();
		}

		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		str = new Str[N];
		for (int i = 0; i < N; i++) {
			str[i] = new Str(br.readLine());
		}
		
		Arrays.sort(str);
		String pre = "";
		for (int i = 0; i < N; i++) {
			if(pre.equals(str[i].s)) {
				continue;
			}
			System.out.println(str[i].s);

			pre = str[i].s;
		}
	}

}