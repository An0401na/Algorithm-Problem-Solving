import java.util.*;
import java.io.*;

public class Main {
	static int N ;
	static int points[][];
	static int temp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		points = new int[N][2];
		temp = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0]= Integer.parseInt(st.nextToken());
			points[i][1]= Integer.parseInt(st.nextToken());
			
		}
		Sort(0, points.length-1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(points[i][j]+" ");
			}
			System.out.println();
			
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
			if(points[leftStart][1] > points[rightStart][1]) {
				copy(temp,idx,points,rightStart);
				rightStart++;
				idx++;
			}else if(points[leftStart][1] < points[rightStart][1]){
				copy(temp,idx,points,leftStart);
				leftStart++;
				idx++;
			}else {
				if(points[leftStart][0] >= points[rightStart][0]) {
					copy(temp,idx,points,rightStart);
					rightStart++;
					idx++;
				}else if(points[leftStart][0] < points[rightStart][0]){
					copy(temp,idx,points,leftStart);
					leftStart++;
					idx++;
				}
			}
		}
		
		if(leftStart > mid) {
			while(rightStart <= end) {
				copy(temp,idx,points,rightStart);
				rightStart++;
				idx++;
			}
			
		}else if(rightStart > end) {
			while(leftStart <= mid) {
				copy(temp,idx,points,leftStart);
				leftStart++;
				idx++;
			}
		}
		
		
		for (int i = start; i <= end; i++) {
			copy(points,i,temp,i);
		}
	}
	static void copy(int[][] a, int aIndex, int[][] b, int bIndex) {
		a[aIndex][0] = b[ bIndex][0];
		a[aIndex][1] = b[ bIndex][1];
	}
}
