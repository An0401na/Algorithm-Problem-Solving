import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] arr;
	static int start;
	static int end;
	static int size;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'a') {
				size++;
			}
		}
		min=Integer.MAX_VALUE;
		for (int i = 0; i <=arr.length; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[(j+i)%arr.length] =='b') {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
		} 
		System.out.println(min);
		
	}

}