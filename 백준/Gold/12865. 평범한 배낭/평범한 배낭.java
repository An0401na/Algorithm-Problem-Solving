import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Main {
	//배낭문제
	static int N; //물건의 수
	static int K; //가방에 담을 수 있는 최대 무게
	static int productWeigth[]; // 각 물건들의 무게를 담고 있는 리스트
	static int productValue[]; // 각 물건들의 가치를 담고 있는 리스트
	static int val[][];  // 물건을 하나씩 담을 때마다 가방에 담을 수 있는 최대의 물건의 가치를 기록하는 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		productWeigth = new int[N+1];
		productValue = new int[N+1];
		
		val = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			productWeigth[i] = w;
			productValue[i] = v;				
		}
		
		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= K; k++) {
				if(productWeigth[i] > k) {
					//i번째 물품의 무게가 1~K(가방에 담을 수 있는 무게)를 넘는지 판별
					//넘는다면 i번째 물품을 선택하지 않고 패스
					val[i][k] = val[i-1][k];  //i-1번째 물품까지 담고서 기록했던 가방의 최대의 가치를 가져옴
				}else { //i번째 물품의 무게가 가방에 담을 수 있는 무게 보다 작아서 담을 수 있는 경우
					//i번째 물건을 넣는것을 선택하는 경우
					int select_1 = val[i-1][k-productWeigth[i]] + productValue[i]; //i-1번째 물품까지 담고서 기록했던 가방의 최대의 가치 + 현 물품의 무게
					
					//i번째 물건을 넣지 않는 것을 선택하는 경우
					int select_2 = val[i-1][k];
					
					val[i][k] = Math.max(select_1, select_2) ; // 두선택중 최대의 가치를 찾아서 현 단계에서 가방의 최대의 가치를 저장
				}
			}
		}
		
		System.out.println(val[N][K]); //1~N번째 까지의 물건을 K무게의 가방에서 담을지 말지 고려하고 찾은 가장 최대의 가치
		
		
		
	}

}