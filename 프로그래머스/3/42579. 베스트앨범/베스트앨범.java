import java.util.*;

class Solution {
        public class Album{
            int first;
            int seconds;

            public Album(int num) {
                first = num;
                seconds = -1;
            }
            public void compare(int num, int plays[]){
                
                if(plays[first] < plays[num]){ // 가장 많이 재생된 경우
                    seconds = first;
                    first = num;
                    return;
                }
                if(plays[first] == plays[num]){ // 재생된 수가 같은 경우
                    if(first > num){
                        seconds = first;
                        first = num;
                    } else {
                        if (plays[seconds] == plays[num]){
                            if (seconds > num){
                                seconds = num;
                            }
                        }else{
                            seconds = num;
                        }
                    }
                    return;
                }

                if(seconds == -1){
                    seconds = num;
                    return;
                }

                if(plays[seconds] < plays[num]){
                    seconds = num;
                    return;
                }

                if(plays[seconds] == plays[num]){
                    if(seconds > num){
                        seconds = num;
                    }
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
                    bestAlbum.get(genres[i]).compare(i, plays);

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