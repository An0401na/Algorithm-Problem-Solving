import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
1. 가지고 있는 카드를 오름차순으로 정렬
	=> -10 -10 2 3 3 6 7 10 10 10
2. 정수를 한개씩 입력 받아 그 숫자들을 상근이가 가지고 있는지,
      가지고 있다면 몇개를 가지고 있는지 판별할 거다!!  => Goal
3. 정수 10을 입력 받아 (첫번째 10의 인덱스)와 (마지막 10의 인덱스+1)의 차를 구해 10이 몇개인지 구할 것이다.
	3-1. 정수 10 입력받기
	3-2. 카드의 배열에서 첫번째 10이 몇번째 인덱스인지를 찾음 => LowerBound()
	3-3. 카드의 배열에서 마지막 10이 몇번째 인덱스+1 이 몇인지를 찾음 => UpperBound()
	3-4. UpperBound() - LowerBound() 를 리턴한다.

*/
public class Main {
	static int N;
	static int M;
	static int [] card;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);

		M=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int target =Integer.parseInt(st.nextToken());
			int n = UpperBound(target)- LowerBound(target);
			sb.append(n).append(" ");
		
		}
		System.out.println(sb);
	}
	private static int UpperBound(int target) {
		int low = 0;
		int high = N;
		int mid;
		
		while(low < high) {
			/*
			1. mid를 지정한다.
			2. mid값이 target보다 크면 high를 mid까지 낮춘다.(즉 target이 mid의 왼쪽에 있으면 오른쪽 범위을 가지고 온다.)
			 	*이때  mid값이 lowerBound인덱스 즉 가장 첫번째로 나오는 값일수도 있기 때문에 mid -1이 아닌 mid로 지정한다.
			3. mid값이 target보다 작거나 같으면 low를 mid+1까지 높인다.(즉 target이 mid의 오른쪽에 있으면 왼쪽 범위를 가지고 온다.)
			 	*mid값이 target보다 크거나 같을때 high를 mid로 낮추고 작을때만 low를 mid+1까지 높이게 되면  target과 같은 값을 가지고 mid보다 인덱스가 큰 요소들이 무시된다.
			 	*ex) 1 3 2 5 5 5 5  => target = 5이면  mid는 인덱스3인 5가 mid값이고 다음 탐색 범위는 인덱스 0 ~ 3(1,3,2,5)이 되게 된다.		
			*/
			mid = (low+high)/2;
			if(card[mid] <= target){
				low = mid+1;
			}else if(target < card[mid])  {
				high = mid;
			}
		}
		
		//while문을 빠지고 나오게 되면 low == arr[mid] == high 다 같게 된다.
//		if(card[high-1]!=target) {
//			return 0; //target값이 없을때
//		}
		return high;
	}
	private static int LowerBound(int target) {
		int low = 0;
		int high = N;
		int mid;
		
		while(low < high) {
			/*
			1. mid를 지정한다.
			2. mid값이 target보다 크거나 같으면 high를 mid까지 낮춘다.(즉 target이 mid의 왼쪽에 있으면 오른쪽 범위을 가지고 온다.)
			 	*mid값이 target보다 클때만 high를 mid로 낮추고 작거나 클때  low를 mid+1까지 높이게 되면  mid보다 작은 인덱스에 있는 target들이 무시된다.
			 	*ex) 5 5 5 5 1 3 2 => target = 5이면  mid는 인덱스3인 5가 mid값이고 다음 탐색 범위는 인덱스 4 ~ 6이 되게 된다.		
				*그리고 이때  mid값이 lowerBound인덱스 즉 가장 첫번째로 나오는 값일수도 있기 때문에 mid -1이 아닌 mid로 지정한다.
			3.mid값이 target보다 작으면 low를 mid+1까지 높인다.(즉 target이 mid의 오른쪽에 있으면 왼쪽 범위를 가지고 온다.)
			*/
			mid = (low+high)/2;
			if(target <= card[mid]) {
				high = mid;
			}else if(card[mid] < target) {
				low = mid+1;
			}
		}
		
		//while문을 빠지고 나오게 되면 low == arr[mid] == high 다 같게 된다.
//		if(card[low]!=target) {
//			return 0;//target값이 없을때
//		}
		return low;
	}
}