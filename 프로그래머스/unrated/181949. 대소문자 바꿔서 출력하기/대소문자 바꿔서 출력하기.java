import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String up = a.toUpperCase();
        String low = a.toLowerCase();
        
        for(int i = 0; i< a.length(); i++){
                                 
            if((int)a.charAt(i) < (int)'a' ){
                System.out.print(low.charAt(i));
            }else{
                System.out.print(up.charAt(i));
            }
        }
        
    }
}