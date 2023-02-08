import java.util.Scanner;

public class Main {
	static int N;
	static int [] RomeNum= {1,5, 10,50};
	static boolean [] sum = new boolean[10000]; //인덱스가 수의 합
	static int result = 0;  //만들 수 있는 서로 다른 수의 개수
	
	//구해야하하는거 : 로마숫자 n개를 사용해서 만들수 있는 서로다른 수의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N 번을 선택해야함
		
		dfs(0,0,0);
		
		System.out.println(result);
		
		
	}
	
	static void dfs(int depth, int idx, int s) { 
		//depth는 현재까지 로마숫자를 몇개사용했는지
		// 그게 n과 같다면 n개를 모두 사용함
		if(depth == N) {  //depth는 현재까지 로마숫자를 몇개사용했는지 
			if(!sum[s]) { //그렇게 뽑은 n개의 숫자의 합이 처음나온 숫자라면
				sum[s] = true; //나왔다고 표시해주고
				result++;  //개수증가
			}
			return;
		}
		//아직 n개를 다 뽑지 못했을때
		for (int i = idx; i < 4; i++) {
			//depth +1 숫자를 한개 더 뽑을 거니까 depth +1
			//i는 어떤수를 뽑을것인지 생각하면 되는데 for문과 재귀를 통해서 1---2---3---4---/11--12--13--...
			//이런식으로 순서대로 뽑히고 있으니 전에 뽑았던 숫자보다 더 적은 숫자는 생각할 필요가 없다.
			//그래서 i 는 index 부터
			//s+RomeNum[i] 지금까지 나온 숫자의 합에서 뽑은 로마숫자 더해주기
			dfs(depth+1, i , s+RomeNum[i]);
			
			
		}
	}
	
}
