import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int K;
	static ArrayList<Integer>  nums;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());		
		nums = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				nums.remove(nums.size()-1);
			}else {
				nums.add(num);
			}
		}
		for (int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
		}
		System.out.println(sum)
		;
		
	}
	

}