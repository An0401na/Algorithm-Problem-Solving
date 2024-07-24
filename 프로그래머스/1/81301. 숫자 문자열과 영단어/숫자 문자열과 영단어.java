import java.io.*;
import java.util.*;

class Solution {
    static String[] engNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] result = new int[51];
    static boolean flag = true;
    static public int solution(String s) {
        int answer = 0;
        Arrays.fill(result, -1);
        while(true){
            flag = true;
            for (int i = 0; i < 10; i++) {
                s = checkNumber(s, i);
                s = checkEngNumber(s, i);
            }
            if(flag){ // 더이상 아무 숫자도 검색되지 않는다면 중지
                break;
            }
        }

        answer =Integer.parseInt(makeNum());

        return answer;
        }

    private static String makeNum() {
        String answer ="";
        for (int i = 0; i < 51; i++) {
            if(result[i] != -1){
                answer = answer + result[i];
            }
        }
        return answer;
    }

    private static String checkNumber(String s, int i) {
        int idx = s.indexOf(String.valueOf(i));
        if(idx != -1){
            flag = false;
            result[idx] = i;
            s = s.substring(0, idx) + "@"+ s.substring(idx+1);
        }
        return s;
    }

    private static String checkEngNumber(String s, int i) {
        int idx = s.indexOf(engNum[i]);
        if(idx != -1){
            flag = false;
            result[idx] = i;
            s = s.substring(0, idx) + "@".repeat(engNum[i].length())+ s.substring(idx+engNum[i].length());
        }
        return s;
    }
}