import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//KMP 문자열 패턴 알고리즘
	/*
	 * 본문의 부분 문자열과 찾을 문자열을 비교
	 * 처음부터 일부까지 패턴이 일치하고 불일치하기 시작한 위치를 찾을 문자열의 접두부이후와 일치시켜 다시 일치를 확인한다.
	 * 
	 *	본문 : aabaabaabaabaacaaba
	 *  찾을 문자열 : aabaac
	 * 
	 * aabaabaabaabaacaaba
	 * aabaa? -> 불일치하기 시작한 위치를 찾음 본문의 접미사부분과 문자열의 접두사 부분일 일치 시켜 다시 같은지 비교
	 * 
	 * aabaabaabaabaacaaba
	 *    aabaa?    ->물음표 부터 보면됨
	 *
	 * aabaabaabaabaacaaba
	 *       aabaa?  ->물음표 부터 보면됨
	 *
	 * aabaabaabaabaacaaba
	 *          aabaac  => 일치
	 * 
	 * 
	 * 이동경로 테이블 : 부분이 일치할 때 본몬의 포인터를 얼마나 이동시켜야하는지 알려주는 테이블
	 * 이동거리 : 일치하는 패턴의 길이 - 최대 경계 너비 
	 */
	
	static char text[]; //본문 문자열
	static char pattern[]; //찾을 문자열 
	static int pi[]; //이동경로 테이블
	static int count;
	static ArrayList<Integer> start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		text = str.toCharArray();
		str = br.readLine();
		pattern = str.toCharArray();
		
		pi = new int[pattern.length];
		start = new ArrayList<>();
		
		for (int j = 0, i = 1; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j-1];				
			}
			if(pattern[i] == pattern[j]) {
				pi[i] = j+1;
				j++;
			}else {
				pi[i]= 0;
			}
		}
		
		for (int j = 0, i = 0; i < text.length; i++) {
			while (j > 0 && pattern[j] != text[i]) {
				j = pi[j-1];
			}
			if(text[i] == pattern[j]) {
				if(j == pattern.length-1) {
					count ++;
					start.add(i-j+1);
					j = pi[j];
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(count);
		for (int i = 0; i < start.size(); i++) {
			System.out.print(start.get(i)+" ");
		}
		
	}

}