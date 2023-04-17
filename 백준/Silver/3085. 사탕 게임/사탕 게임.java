import java.io.*;
import java.util.*;



public class Main {
	static int N;
	static char map[][];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			search(i);
		}
		char[][] copymap = new char[N][N];
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				copymap[j][k]=map[k][j]; 
			}
		}
		map = copymap;
		for (int i = 0; i < N; i++) {
			search(i);
		}
		System.out.println(max);
	}
	
	private static void search(int row) {
		for (int i = 0; i < N-1; i++) {
			if(map[row][i] != map[row][i+1]) {
//				System.out.println("("+row+","+ i+")"+" => "+map[row][i]+"!="+map[row][i+1]);
				swap(row, i);
					check(map);
					char[][] copymap = new char[N][N];
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < N; k++) {
							copymap[j][k]=map[k][j]; 
						}
					}
					check(copymap);
				swap(row, i);
			}
		}
	}
	
	
	static void check(char[][] map) {
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N-1; j++) {
				if(map[i][j]==map[i][j+1]) {
					count ++;
				}else {
					count =1;
				}
				max = Math.max(max, count);
//				System.out.println("max : "+ max+", count : "+ count );
			}
			if(max == N) {
				System.out.println(N);
				System.exit(0);
			}
			
		}
		
		
		
	}
	
	
	static void swap(int row, int i) {
		 char temp = map[row][i];
		 map[row][i] = map[row][i+1];
		 map[row][i+1] = temp;
	}
	
	

}