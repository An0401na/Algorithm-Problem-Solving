import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static int k=-1;
	static int [] num;
	static ArrayList<int[]> tc_list = new ArrayList<>();
	
	static boolean [] visited;
	static ArrayList<Integer> result= new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
			
		while(k !=0) {
			k = sc.nextInt();
			if(k==0) {
				break;
			}
			num = new int[k];
			for (int i = 0; i < k; i++) {
				num[i]= sc.nextInt();
			}
			tc_list.add(num);
		}
		
		
		for (int i = 0; i < tc_list.size(); i++) {
			num = (int[]) tc_list.get(i);
			k = num.length;
			visited = new boolean[k];
			dfs(0,-1);
			result.clear();
			System.out.println();
		}
		
		
	}
	
	static void dfs(int depth, int idx) {
		if(depth==6) {
			for (int i = 0; i <6 ; i++) {
				System.out.print(result.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for (int i = idx+1; i < k; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result.add(num[i]);
				dfs(depth+1, i);
				result.remove(result.size()-1);
				visited [i]= false;
			}
		}
	}
}
