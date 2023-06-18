import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int num[] = new int [4];
	static int clockNum;
	static int minNum;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//------입력
		
		clockNum = 	getClockNum(num);
		
		num = new int[]{ 1, 1, 1, 1};
		
		findSmallColockNum(0); 
		
		System.out.println(set.size());
	}
	
	//주어진 시계수보다 작은 시계수 찾는 함수
	static void findSmallColockNum(int cnt) {
		if(cnt >= 4) {
			int minNum = getClockNum(num);
			if(minNum <= clockNum) {
				set.add(minNum);
			}
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			num[cnt] = i;
			findSmallColockNum(cnt+1);
		}
		
		
	}

	//-----시계수 구하기
	static int getClockNum(int[] num) {
		int cNum = Integer.MAX_VALUE; // 시계수 초기화
		for (int i = 0; i < 4; i++) {
			int tempNum = 0;
			
			int idx = i;
			
			for (int j = 3; j >= 0; j--) {
				if(idx > 3) {
					idx= 0;
				}
				tempNum += num[idx++] * Math.pow(10, j);
			}
			if(cNum > tempNum) {
				cNum = tempNum;
			}
		}
		return cNum;
	}

}