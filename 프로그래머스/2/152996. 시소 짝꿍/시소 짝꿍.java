import java.util.*;

class Solution {
    static int weights[];
    static HashMap<Integer,Integer> cnt = new HashMap<>();
    static HashMap<Integer, Integer> lastIdx = new HashMap<>();

    public long solution(int[] weights) {
        this.weights = weights;
        // 정렬
        Arrays.sort(weights);

        int len = weights.length;

        for (int i = 0; i < len-1; i++) {
            cnt.put(weights[i], cnt.containsKey(weights[i]) ? cnt.get(weights[i])+1 : 1);
            if(weights[i] != weights[i+1]){
                lastIdx.put(weights[i], i);
            }
        }
        cnt.put(weights[len-1], cnt.containsKey(weights[len-1]) ? cnt.get(weights[len-1])+1 : 1);
        lastIdx.put(weights[len-1], len-1);

        long answer = 0;


        /*
        100 - B 라고 한다면
        100 일때 2m 일때는 볼 필요가 없음 200/2, 3, 4 인 무게들이 있는지 확인하게 될거고, 이 무게들은 100보다 작다. (100, 66, 50)
        만약 100*2 - 50*4 인 경우는 => 50*4 - 100*2에서 이미 짝을 찾았을테니 확인 할 필요 없음
        100*3일때는 300/2, 3, 4 인 무게들이 있는지 확인하게 될거고, 이 무게들은 각 150, 100, 75 이므로 거리 2미터만 보면 됨
        100*4일때는 400/2, 3, 4 인 무게들이 있는지 확인하게 될거고, 이 무게들은 각 200, 166, 100 이므로 거리 2, 3, 만 보면됨
        즉 자기보다 거리보다 적은 애들만 보면 되고 별도로 자기 무게와 동일한 무게들이 있다면 자기 인덱스보다 큰 애들이 몇개 인지 알면 됨
         */
        for (int i = 0; i < len-1; i++) {
    //                System.out.println(i + ". 현재 사람 무게 : " + weights[i]);
            for (int dis = 2; dis <=4 ; dis++) {
    //                    System.out.println("한쪽에는 : "+weights[i] +"*"+dis +" = "+(weights[i]*dis));
                for (int pairDis = dis-1; pairDis >= 2; pairDis--) {
    //                        System.out.println("  반대에는 :"+(weights[i]*dis)+"/"+pairDis+" => "+(weights[i]*dis/pairDis));
    //                        if(getTargetWeightCnt(weights[i] * dis / pairDis) != 0) {
    //                            System.out.println("{" + weights[i] + ", " + (weights[i] * dis / pairDis) + "} 은 각각 " + dis + "m, " + pairDis + "m 거리에 마주보고 앉으면 균형");
    //                        }else{
    //                            System.out.println("  => 반대 무게 없음");
    //                        }
                    if(weights[i] * dis % pairDis != 0 ) continue;
                    answer += getTargetWeightCnt(weights[i] * dis / pairDis);
                }
            }
            // i번째 사람과 동일한 무게인 사람이 있다면
            if(cnt.containsKey(weights[i])){
    //                    if(lastIdx.get(weights[i]) - i != 0){
    //                        System.out.println("{"+weights[i]+", "+weights[i]+"} 은 서로 같은 거리에 마주보고 앉으면 균형");
    //                    }

                answer += lastIdx.get(weights[i]) - i;
            }
    //                System.out.println();
        }

        return answer;
    }

    //targetW를 무게로 가지는 사람들의 수를 반환
    private int getTargetWeightCnt(int targetW) {
        if(cnt.containsKey(targetW)){
            return cnt.get(targetW);
        }
        return 0;
    }
}