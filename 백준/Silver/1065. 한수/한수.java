
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count =0;
		for (int i = 1; i <=n ; i++) {
			if(han(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static boolean han(int n) {
		if(n<100) {
			return true;
		}
		String str = String.valueOf(n);
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i]=str.charAt(i);
		}
		int diff=0;
		for (int i = 0; i < arr.length-1; i++) {
			if(i==0) {
				diff=arr[1]-arr[0];
				
			}else {
				if(diff!=arr[i+1]-arr[i]) {
					return false;
				}
			}
		}
		return true;
		
	}
}
