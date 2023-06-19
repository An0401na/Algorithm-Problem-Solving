import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	// 접근 : 5 min
	// 구현 :
	static int S;
	static int P;
	static char[] str;
	static int min[]; // A, C, G ,T 순서대로 최소 개수
	static int count[]; // 현재 내가 보고 있는 부분 문자열의 ACGT의 개수
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		str = br.readLine().toCharArray();

		min = new int[4];
		count = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		//-------입력
//		System.out.println("A, C, G ,T");
//		System.out.println("[min] : "+Arrays.toString(min));

		for (int i = 0; i < P; i++) {
			int idx = 0;
			switch (str[i]) {
			case 'A': {
				idx = 0;
				break;
			}
			case 'C': {
				idx = 1;
				break;
			}
			case 'G': {
				idx = 2;
				break;
			}
			case 'T': {
				idx = 3;
				break;
			}
			}
			count[idx]++;
		}
//		System.out.println("[Count] : "+Arrays.toString(count));
		

		check();

		for (int i = 1; i <= S - P; i++) {
//			System.out.println("=============");
			
			char temp[] = new char[2];
			temp[0] = str[i - 1];
			temp[1] = str[i + P - 1];
//			System.out.println("[Temp] : "+Arrays.toString(temp));
			for (int j = 0; j < 2; j++) {
				int idx = 0;
				switch (temp[j]) {
				case 'A': {
					idx = 0;
					break;
				}
				case 'C': {
					idx = 1;
					break;
				}
				case 'G': {
					idx = 2;
					break;
				}
				case 'T': {
					idx = 3;
					break;
				}
				}
				if(j == 0) {
					count[idx]--;
				}else {
					count[idx]++;
				}
			}
//			System.out.println("[Count] : "+Arrays.toString(count));
			check();
//			System.out.println("[Result] : "+result);
		}
		System.out.println(result);

	}

	static void check() {
		for (int i = 0; i < count.length; i++) {
			if (min[i] > count[i]) {
				return;
			}
		}
		result++;
	}

}