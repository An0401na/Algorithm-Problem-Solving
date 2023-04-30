import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int s[][];
	static boolean team[];
	static int min;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		s = new int[N][N];
		team = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;

		makeTeam(0,0);
		
		System.out.println(min);
	}

	static void makeTeam(int cnt, int idx) {
		if(cnt == N/2) {
			int start = getScore(true);
			int link = getScore(false);
			min = Math.min(min, Math.abs(start-link));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			team[i] = true;
			makeTeam(cnt+1, i+1);
			team[i] = false;
		}
	}

	private static int getScore(boolean t) {
		int score=0;
		for (int i = 0; i < N; i++) {
			if(team[i]==t) {
				for (int j = 0; j < N; j++) {
					if(team[j]==t) {

						score +=s[i][j];
					}
				}				
			}			
		}
		return score;
	}
}