import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String [] serials;
	static String [] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		serials = new String[N];
		temp = new String[N];;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			serials[i] = st.nextToken();
		}
		
		


		
		Sort(0, N-1);
		
		
		for (int i = 0; i < N; i++) {
			System.out.println(serials[i]+" ");
		}
		
		
	}
	static void Sort(int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start + end)/2;
		
		Sort(start, mid);
		Sort(mid+1, end);
		
		Merge(start, mid, end);
	}
	static void Merge(int start, int mid, int end) {
		int leftStart = start; //왼쪽 배열의 첫번째 인덱스
		int rightStart = mid+1;  //오른쪽 배열의 첫번째 인덱스
		int idx = start; //정렬된 배열을 차례대로 담을 인덱스
		
		while(leftStart<=mid && rightStart <= end) {
			if(serials[leftStart].length() != serials[rightStart].length()) {
				//A와 B의 길이가 다르면
				//짧은 것이 먼저 온다. => 짧은 걸 temp에 넣기
				if(serials[leftStart].length() < serials[rightStart].length()) {
					temp[idx] = serials[leftStart];
					idx++;
					leftStart++;
				}else {
					temp[idx] = serials[rightStart];
					idx++;
					rightStart++;
				}
			}else { //A와 B의 길이가 같고
				if(sumNums(serials[leftStart]) != sumNums(serials[rightStart])){
				
					//자리수의 합이 같지 않을때
					//작은걸 temp에 넣기
					if(sumNums(serials[leftStart]) < sumNums(serials[rightStart])) {
						temp[idx] = serials[leftStart];
						idx++;
						leftStart++;
					}else {
						temp[idx] = serials[rightStart];
						idx++;
						rightStart++;
					
					}
				}else { //A와 B의 길이가 같고 자리수의 합이 같을때
					//사전순으로 비교 (숫자가 알파벳보다 사전순을 작다)
					
					for (int i = 0; i <serials[leftStart].length(); i++) {
						if (serials[leftStart].charAt(i) < serials[rightStart].charAt(i)) {
							temp[idx] = serials[leftStart];
							idx++;
							leftStart++;
							break;
						}else if(serials[leftStart].charAt(i) > serials[rightStart].charAt(i)) {
							temp[idx] = serials[rightStart];
							idx++;
							rightStart++;
							break;
						}
					}
					
				}
			}
			
		}
		
		//남은거 복사
		if(leftStart > mid) {
			while(rightStart <= end) {
				temp[idx] = serials[rightStart];
				idx++;
				rightStart++;
			}	
		}else if(rightStart > end) {
			while(leftStart <= mid) {
				temp[idx] = serials[leftStart];
				idx++;
				leftStart++;
			}
		}
		
		for (int i = start; i <= end; i++) {
			serials[i] = temp[i];
		}
		
	}

	
	private static int sumNums(String str) {
		// TODO 모든 자리수의 합을 리턴, 숫자인 것만 더한다.
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				sum += str.charAt(i)-'0';
			}
		}
		return sum;
	}
}