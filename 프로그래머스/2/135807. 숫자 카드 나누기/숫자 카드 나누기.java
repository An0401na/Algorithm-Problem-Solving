import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
            int answer = 0;
            // arrayA의 최대 공약수 구하기 -> gcdA
            int gcdA = 0;
            for (int i = 0; i < arrayA.length; i++) {
                gcdA = GCD(gcdA, arrayA[i]);
            }

            // arrayB의 최대 공약수 구하기 -> gcdB
            int gcdB = 0;
            for (int i = 0; i < arrayB.length; i++) {
                gcdB = GCD(gcdB, arrayB[i]);
            }

            // gcdA로 arrayB의 원소들 중 나눠지는 원소가 있는지 확인
            for (int i = 0; i < arrayB.length; i++) {
                if(arrayB[i] % gcdA == 0){
                    gcdA = 0;
                    break;
                }
            }


            // gcdB로 arrayA의 원소들 중 나눠지는 원소가 있는지 확인
            for (int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % gcdB == 0){
                    gcdB = 0;
                    break;
                }
            }

            // gcdA와 gcdB 중에 큰 수
            answer = Math.max(gcdA, gcdB);

            return answer;
        }

        private static int GCD(int a, int b) {
            if (b == 0){
                return a;
            }
            return GCD(b, a % b);
        }
}