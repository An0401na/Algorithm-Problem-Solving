import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String [] result = new String[tc];
		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			String s = sc.next();
			char[] arr = s.toCharArray();
			
			result[i]="";
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					result[i]= result[i].concat(String.valueOf(arr[j]));
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
			
	}	
}

