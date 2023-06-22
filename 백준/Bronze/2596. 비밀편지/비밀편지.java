import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static String[] abc = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String substr = str.substring(i * 6, (i * 6) + 6);
			int idx = -1;
			for (int j = 0; j < 8; j++) {
				int count = 0;
				for (int k = 0; k < 6; k++) {
					if (substr.charAt(k) == abc[j].charAt(k)) {
						count++;
					}
				}
				if (count == 5) {
					idx = j;
				}else if (count == 6) {
					idx = j;
					break;
				}
			}
			if (idx == -1) {
				System.out.println(i + 1);
				return;

			}

			sb.append((char) (idx + 65));

		}
		System.out.println(sb.toString());
	}

}