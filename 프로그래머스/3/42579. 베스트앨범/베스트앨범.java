import java.util.*;

class Solution {
        public class Album{
            int first;
            int seconds;

            public Album(int num) {
                first = num;
                seconds = -1;
            }
            public int compare(int n1, int n2, int[] plays){
                if(plays[n1] == plays[n2]){ // 재생수가 같다면 번호가 작은게 우선
                    return n2 - n1; // 양수면 n2가 숫자가 더 크니까 n1이 더 우선, 음수면 n1이 숫자가 더 크니까 n2가 더 우선
                }
                //재생수가 큰게 우선
                return plays[n1] - plays[n2]; //양수면 n1재생수가 더 크니까 n1이 우선, 음수면 n2재생수가 더 크니까 n2가 우선
            }
            public void reorder(int num, int plays[]){
                int temp;
                if(compare(first, num, plays) <  0){
                    // 음수면 num이 1위
                    temp = first;
                    first = num;
                }else{
                    // 양수면 first가 그대로 1위
                    temp = num;
                }

                if(seconds == -1){ // 2위 자리 비어 있으면 넣고 마치기
                    seconds = temp;
                    return;
                }

                if(compare(seconds, temp, plays) <  0){
                    // 음수면 temp 2위
                    seconds = temp;
                    // 양수면 seconds가 그대로 2위
                }
            }
        }
    public int[] solution(String[] genres, int[] plays) {
            HashMap <String, Integer> bestAlbumPlay = new HashMap<>();
            HashMap <String, Album> bestAlbum = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if(bestAlbumPlay.containsKey(genres[i])){ // 기존에 있던 장르
                    // 재생수 합하고
                    bestAlbumPlay.put(genres[i], bestAlbumPlay.get(genres[i]) + plays[i]);

                    // 순서 다시 정하기
                    bestAlbum.get(genres[i]).reorder(i, plays);

                }else{ // 새로운 장르
                    // 재생수 map에 추가
                    bestAlbumPlay.put(genres[i], plays[i]);

                    // 순서 map에 생성
                    bestAlbum.put(genres[i], new Album(i));
                }
            }

            List<Map.Entry<String ,Integer>> list = new ArrayList<>(bestAlbumPlay.entrySet());
            list.sort(Map.Entry.comparingByValue((o1, o2) -> o2-o1));

            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < bestAlbumPlay.size(); i++) {
                Album album = bestAlbum.get(list.get(i).getKey());
                answer.add(album.first);
                if(album.seconds != -1){
                    answer.add(album.seconds);
                }

            }
            int result[] = new int[answer.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = answer.get(i);
            }
            return result;
    }
}