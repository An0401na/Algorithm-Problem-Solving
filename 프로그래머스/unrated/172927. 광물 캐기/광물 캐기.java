import java.util.*;
class MineralDummy implements Comparable<MineralDummy>{
    int dia_pirodo;
    int iron_pirodo;
    int stone_pirodo;
    
    public MineralDummy(int dia_pirodo, int iron_pirodo, int stone_pirodo){
        this.dia_pirodo = dia_pirodo;
        this.iron_pirodo =iron_pirodo;
        this.stone_pirodo=stone_pirodo;
    }
    
    // @Override
    public int compareTo(MineralDummy o){
        return -(this.stone_pirodo - o.stone_pirodo);
    }
    
    public String toString(){
        return "dia : "+dia_pirodo+"\n"+"iron_pirodo : "+iron_pirodo+"\n"+"stone_pirodo : "+stone_pirodo;
    }
    
}

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 우선순위 큐, 돌의 피로도로 바꿔보기 
        int n =0;
        if(minerals.length % 5 ==  0){
            n = minerals.length/5;
        }else{
            n = minerals.length/5 +1;
        }
        
        int cnt =0;
        for(int i =0; i < 3 ; i++) {
            cnt += picks[i];
        }
        if(cnt < n ){
            n = cnt;
        }        
    
        PriorityQueue<MineralDummy> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n; i++){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for(int j = 0 ; j < 5; j++){
                if(i*5+j >= minerals.length) break;
                
                if(minerals[i*5+j].equals("diamond")){
                    dia +=1;
                    iron += 5;
                    stone += 25;
                }
                
                if(minerals[i*5+j].equals("iron")){
                    dia +=1;
                    iron += 1;
                    stone += 5;
                }
                
                if(minerals[i*5+j].equals("stone")){
                    dia +=1;
                    iron += 1;
                    stone +=1;
                }
            }
            
            pq.add(new MineralDummy(dia, iron, stone));
        }
          
        
        int answer = 0;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j<picks[i]; j++){
                if(pq.isEmpty()){
                    return answer;
                }
                MineralDummy md = pq.poll();
                System.out.println(md.toString());
                if(i == 0){
                    answer+= md.dia_pirodo;
                    System.out.println("dia");
                    System.out.println("answer : "+answer);
                }else if (i ==1){
                    answer += md.iron_pirodo;
                    
                    System.out.println("iron_pirodo");
                    System.out.println("answer : "+answer);
                }else if(i == 2){
                    answer += md.stone_pirodo;
                    
                    System.out.println("stone_pirodo");
                    System.out.println("answer : "+answer);
                }
            }
        }
        
        
//         while(picks[2] !=0){
//             int min = 1000;
//             int idx = -1;
//             for(int j = 0; j < n; j++){
//                 if(pirodo[2][j] != 0&& min > pirodo[2][j]){
//                     min = pirodo[2][j];
//                     idx = j;
//                 }
//             }
            
//             if(idx == -1) {
//                 break;
//             }
//             answer += pirodo[2][idx];
//             pirodo[2][idx]=0;
//             picks[2]--;
            
//             for(int d = 0; d <3; d++){
//               System.out.println(Arrays.toString(pirodo[d]));
//             }
//             System.out.println("-----------");
//         }
        
        return answer;
    }
}