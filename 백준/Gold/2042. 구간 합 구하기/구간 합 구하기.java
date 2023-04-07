import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	//세그먼트 트리 - O(logN)
	//참고 - https://www.acmicpc.net/blog/view/9
	/*
	 * 세그먼트 트리의 리프노드 : 배열의 그 수 자체
	 * 세그먼트 트리의 리프노드가 아닌 노드 : 왼쪽 자식과 오른쪽 자식의 합을 저장
	 * 즉 ,()는 값     루트0
	 * 			   (0~5까지합) 
	 *        자식1           자식2
	 *      (0~2까지합)     (3~5까지합)
	 *    자식3    자식4    자식5      자식6
	 *  (0~1까지합)  (2) (3~4까지합)    (5)
	 *  자식7 자식8	   자식11 자식12
	 *  (0)  (1)        (3)  (4) 
	 * 
	 * 왼쪽자식의 인덱스 : 루트*2
	 * 오른쪽자식의 인덱스 : 루트*2+1
	 * 
	 * 부모는 각 왼,오른쪽 자식의 합을 값으로 가진다.
	 * 
	 * 세그먼트 트리의 배열의 크기는 2^(트리의 높이+1)-1인데 
	 * 편의상 2^(트리의 높이+1) 또는 4N으로 크기를 정하기도 한다.
	 * (트리 높이는 logN)
	 */
	
	/*
	 * sum[i] 는 1 ~ i 까지의 누적합이라고 했을때
	 * i ~ j 까지의 합은 sum[j] - sum[i]
	 */
	static int N; //수의 개수
	static int M; //수 변경 횟수
	static int K; // 구간합을 구하는 횟수
	static long num[];
	static long tree[]; //구간합을 저장하는 트리 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		num = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[N*4];
		
		makeTree(0, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M+K; i++) {
			
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				int n = Integer.parseInt(st.nextToken())-1;
				long newValue = Long.parseLong(st.nextToken());
				long diff =  newValue - num[n];
				num[n] = newValue;
				update(n, 0, N-1, 0, diff);
			}else {
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				long result = sum(a, b, 0, N-1, 0);
				sb.append(result+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	//세그먼트 트리 만들기
	//num배열의 start ~ end 까지의 합을 tree[treeNodeNum]에 저장
	//tree[treeNodeNum]은 start~end 범위를 합을 담당
	//즉 tree[treeNodeNum]에 두 자식을 더해서 값을 저장시키는 함수
	static long makeTree(int treeNodeNum, int start, int end) {
		if(start == end) {
			tree[treeNodeNum] = num[start];
		}else {
			long leftChild= makeTree(treeNodeNum*2+1, start, (start+end)/2); //treeNodeNum*2+1는 왼쪽 자식노드 인덱스 
			long rightChild= makeTree(treeNodeNum*2+2, (start+end)/2+1, end);//treeNodeNum*2+2는 오른쪽 자식노드 인덱스 
			tree[treeNodeNum] = leftChild + rightChild;
			//트리에서 왼쪽자식의 값 + 오른쪽자식의값 
		}
		return tree[treeNodeNum];
	}
	
	//start부터 end까지의 구간합 구하기
	//treeNodeNum인덱스의 노드가 담당하는 부분이 start ~ end고 구해야하는 합의 구간이 a ~ b
	static long sum(int a, int b, int start, int end, int treeNodeNum) {

		// 구해야하는 합의 구간과 노드 담당 구간이 겹치지 않는 경우
		// 1 ~ 3구간의 합을 구할건데 노드가 4~5담당인 경우
		// 상관없는 부분임으로 합에 영향을 주지않게 0을 리턴한다.
		if(end < a || b < start) { // s----e  a--합--b  s----e
			return 0;
		}
		
		// 구해야하는 합의 구간이 노드 담당 구간을 완전히 포함되는 경우
		// 나는 0~5의 합을 알고 싶은데 노드가 3~5를 담당해 그럼 3~5 값이랑 0~2 값을 더하면 되니까 그 값필요해 리턴해줘
		if(a <= start && end <= b) { //a----s--노드담당--e----b
			return tree[treeNodeNum];
		}
		
		// 1. 노드 담당구간이 구해야하는 합의 구간을 완전히 포함하는 경우
		// 노드는 0~5를 담당하는데 나는 0~2까지의 합을 알고싶어. 0~2의 합을 찾으러 가야해 -> 자식노드 탐방
		// 3~5까지의 합은 0으로 리턴될거야.걱정 ㄴㄴ
		// 2.구해야하는 합의 구간이 노드 담당 구간의 일부분만 포함하는 경우
		// 나는 2~4합을 알고 싶은데 노드는 3~5를 담당해 
		// 2~2까지의 합 + 3~4까지의 합 해서 알아낼수 있어 
		// 두 범위에 대한 합을 찾으러 자식 노드 탐방
		else {
			long leftChild= sum(a, b, start, (start+end)/2, treeNodeNum*2+1); //treeNodeNum*2+1는 왼쪽 자식노드 인덱스 
			long rightChild= sum(a, b, (start+end)/2+1, end, treeNodeNum*2+2);//treeNodeNum*2+2는 오른쪽 자식노드 인덱스 
			return leftChild + rightChild;
		}
	}

	// 중간에 num의 n번째를 x로 변경한다면 그 숫자가 포함된 구간을 담당하는 노드를 모두 변경해주어야 한다.
	// 그러면 원래의 num[n]의 값과 x의 차이를 찾아서 합들을 그 차이만큼 빼거나 더하여 합을 수정할 수 있다.
	// 그 차이를 diff라고 하자.
	// tree[treeNodeNum]은 start~end의 합을 담당하고 있다.
	static void update(int n, int start, int end, int treeNodeNum, long diff) {
		
		//노드 담당구간에 n번째 값이 포함되지 않는경우
		// 탐색중단
		if(n < start || end < n) {// n s--노드담당--e 또는 s--노드담당--e n 
			return ;
		}
		//노드 담당구간에 n번째 값이 포함되는 경우
		// 포함한다면 그 노드 담당구간의 합을 차이만큼 빼거나 더해서 합을 수정
		if(start <= n && n <= end) {
			tree[treeNodeNum] +=diff;
			//start와 end가 같은 단말노드라면 탐색중단.
			if(start == end) return;
			
			//같지 않다면 n번째 값을 모두 포함하고 있는 담당 노드들을 찾아서 다 수정해야하므로 자식노드 탐방
			update(n, start, (start+end)/2, treeNodeNum*2+1, diff);
			update(n, (start+end)/2+1, end, treeNodeNum*2+2, diff);
		}
		
	}

}