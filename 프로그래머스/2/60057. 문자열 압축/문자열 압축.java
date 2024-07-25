import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
            int answer = s.length();
            String zipStr ;

            for (int tokenLen = 1; tokenLen <= s.length()/2; tokenLen++) { //문자열 절반까지만 확인 => O(N)
                zipStr = "";
                int start = 0;
                int end = tokenLen;
                String subStr = s.substring(start, end);

                // 본인은 무조건 반복 횟수 1이기 때문에 볼 필요 없이 다음 부분 문자여을 보면 된다.
                start += tokenLen;
                end += tokenLen;
                int cnt = 1; // 부분 문자열의 반복 횟수

                //보고 있는 문자열의 범위가 입력으로 주어진 문자열을 넘어간다면 문자열 반복 탐색을 멈추고 다음 토큰 길이로 넘기기
                while(end <= s.length()){ // => O(N)
                    if(s.substring(start,end).equals(subStr)) { // 부분 문자열과 보고 있는문자열 (start ~ end)이 같을때 (즉 반복될때)
                        // 반복 횟수 올리고 다음 부분문자열 보기
                        cnt++;
//                        start += tokenLen;
//                        end += tokenLen;
                    }else { // 부분문자열과 보고 있는 문자열이 다르다면 count 중지
                        //문자열 압축 
                        zipStr = makeZipStr(cnt, zipStr, subStr);

                        if(end > s.length()){
                            break;
                        }
                        //부분 문자열을 현재 보고 있는 문자열로 바꿈
                        subStr = s.substring(start, end);
//                        start += tokenLen;
//                        end += tokenLen;

                        cnt = 1;
                    }
                    start += tokenLen;
                    end += tokenLen;
                }

                //문자열 압축 
                zipStr = makeZipStr(cnt, zipStr, subStr);
                
                // 단위만큼 나누고 남은 문자열 붙이기
                zipStr += s.substring(start);

                //압축한 문자열의 가장 작은 길이 비교
                answer = Math.min(answer, zipStr.length());
            }
            return answer;
        }

        private static String makeZipStr(int cnt, String zipStr, String subStr) {
            // 단 1일때는 생략
            if(cnt != 1){
                zipStr = zipStr + cnt + subStr;
            }else{
                zipStr = zipStr + subStr;
            }
            return zipStr;
        }
}