import java.util.*;

class Solution {
    class song{
        String genre;
        int play;
        int num;
        public song(int a, String b, int c){
            num = a;    genre = b;  play = c;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        HashMap<String, Integer>genreSum = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(!genreSum.containsKey(genres[i]))genreSum.put(genres[i], plays[i]);
            else genreSum.replace(genres[i], genreSum.get(genres[i]) + plays[i]);
        }
        
        PriorityQueue<song>arr = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(song a, song b){
                if(a.genre.equals(b.genre)){
                    if(a.play == b.play)
                        return a.num - b.num;
                    else
                        return b.play - a.play;
                    
                }else{
                    return genreSum.get(b.genre) - genreSum.get(a.genre);
                }
            }
        });
        
        
        for(int i = 0; i < genres.length; i++){
            
            arr.add(new song(i,genres[i],plays[i]));
        }
        
        ArrayList<Integer>Arr = new ArrayList<>();
        song t = arr.remove();
        String pastWord = t.genre; int count = 1;
        Arr.add(t.num);
        
        while(!arr.isEmpty()){
            song temp = arr.remove();
            if(pastWord.equals(temp.genre)){
                if(count >= 2)continue;
                else count++;
            }else{
                pastWord = temp.genre;
                count = 1;
            }
            
            //System.out.println(temp.num+" "+temp.genre+" "+temp.play);
            Arr.add(temp.num);
        }
        answer = new int[Arr.size()];
        int l = 0;
        for(int p : Arr)answer[l++] = p;
        
        return answer;
    }
}