import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());

		ArrayList<Integer> result = new ArrayList<>();
		String op;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			
			switch (op) {
				case "add": {
					int value = Integer.parseInt(st.nextToken());
					if (!result.contains(value)) {
						result.add(value);
					}
					break;
				}
				case "remove": {
					int value = Integer.parseInt(st.nextToken());
					if (result.contains(value)) {
						result.remove(Integer.valueOf(value));
					}
					break;
	
				}
				case "check": {
					int value = Integer.parseInt(st.nextToken());
	
					if (result.contains(value)) {
						sb.append("1").append("\n");
	
					} else {
						sb.append("0").append("\n");
					}
	
					break;
				}
				case "toggle": {
					int value = Integer.parseInt(st.nextToken());
					if (result.contains(value)) {
						result.remove(Integer.valueOf(value));
					} else {
						result.add(value);
					}
					break;
	
				}
				case "all": {
	
					result.clear();
					for (int j = 1; j < 21; j++) {
						result.add(j);
					}
	
					break;
				}
				case "empty": {
					result.clear();
					break;
	
				}

			}
//			System.out.println(op);
//			for (int j = 0; j < result.size(); j++) {
//				System.out.print(result.get(j)+" ");
//			}
//			System.out.println();

		}

		System.out.println(sb.toString());
	}

}