import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        
        StringTokenizer st;
        int[][]give = new int[50][50];
        Map<String, Integer> name = new HashMap<>();
        int friendsNum = friends.length;
        for(int i = 0; i < friendsNum; i++){
            name.put(friends[i],i);
        }
        
        int giveNum = gifts.length;
        int[] presentPoint = new int[friendsNum];
        for(int i = 0; i < giveNum; i++){
            st = new StringTokenizer(gifts[i]);
            String giveP = st.nextToken();
            int giveN = name.get(giveP);
            String getP = st.nextToken();
            int getN = name.get(getP);
            presentPoint[getN]--;
            presentPoint[giveN]++;
            give[giveN][getN]++;
        }

        int[] nextMonthPresent = new int[friendsNum];
        for(int i = 0; i< friendsNum; i++){
            for(int j = i+1; j< friendsNum; j++){
                int ij = give[i][j];
                int ji = give[j][i];
                if(ij > ji){
                    nextMonthPresent[i]++;
                }else if(ij < ji){
                    nextMonthPresent[j]++;
                }else{
                    if(presentPoint[i] > presentPoint[j])nextMonthPresent[i]++;
                    else if(presentPoint[i] < presentPoint[j])nextMonthPresent[j]++;
                }
            }
        }
        
        int answer = 0;
        for(int i =0; i<friendsNum; i++){
            answer = Math.max(answer, nextMonthPresent[i]);
        }
        
        
        
        return answer;
    }
}