import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
            int answer = s.length();
            String zipStr ;

            for (int tokenLen = 1; tokenLen <= s.length()/2; tokenLen++) { //문자열 절반까지만 확인
//            for (int tokenLen = 8; tokenLen < 9; tokenLen++) { //문자열 절반까지만 확인
//                System.out.println();
//                System.out.println("+++++++++++++++++++++++++++++++");
//                System.out.println("길이 : " + tokenLen);
                zipStr = "";
                int start = 0;
                int end = tokenLen;
                String subStr = s.substring(start, end);;
                start += tokenLen;
                end += tokenLen;
                int cnt = 1; // 부분 문자열의 반복 횟수

//                System.out.println("subStr : " + subStr);
                //보고 있는 문자열의 범위가 s를 넘어간다면 문자열 반복 탐색을 멈추가 다음 토큰 길이로 넘기기
                while(end <= s.length()){
//                    System.out.println("start ~ end : " + start +" ~ "+ end +"["+s.substring(start, end)+"]");


                    if(s.substring(start,end).equals(subStr)) { // 부분 문자열과 보고 보고 있는문자열 (start ~ end)이 같을때 (즉 반복될때)
                        // 반복 횟수 올리고 다음 부분문자열 보기

                        cnt++;
                        start += tokenLen;
                        end += tokenLen;
//                        System.out.println("-> 같아  : "+cnt);

                    }else { // 부분문자열과 보고 있는 문자열이 다르다면 count 중지
                        //문자열 압축 단 1일때는 생략
//                        System.out.println("-> 달라 : " +cnt);
                        if(cnt != 1){
                            zipStr = zipStr + cnt + subStr;
                        }else{
                            zipStr = zipStr + subStr;
                        }

                        if(end > s.length()){
                            break;
                        }


                        subStr = s.substring(start, end);
//                        System.out.println("바뀐 subStr : " + subStr);
                        start += tokenLen;
                        end += tokenLen;
                        //반복되는 부분 문자열을 다음으로 바꿈
                        cnt = 1;
//                        System.out.println("zipStr : " + zipStr);
                    }
//                    System.out.println();
//                    System.out.println("subStr : " + subStr);
                }

                if(cnt != 1){
                    zipStr = zipStr + cnt + subStr;
                }else{
                    zipStr = zipStr + subStr;
                }
                zipStr += s.substring(start);
//                System.out.println(zipStr);

                //압축한 문자열의 가장 작은 길이 비교
                answer = Math.min(answer, zipStr.length());
            }
            return answer;
    }
}