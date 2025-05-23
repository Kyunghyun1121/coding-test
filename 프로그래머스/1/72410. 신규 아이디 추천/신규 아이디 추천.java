import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1 단계
        new_id = new_id.toLowerCase();
        
        //2단계
        char[]temp = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == '-' ||
              temp[i] == '_' || 
              (temp[i] >= '0' && temp[i] <= '9')||
              (temp[i] >= 'a' && temp[i] <= 'z')){
                sb.append(temp[i]);
            }else if(temp[i] == '.'){
                sb.append(temp[i]);
                while(i+1 < temp.length && temp[i+1] == '.') i++;
            }
        }
        new_id = sb.toString();
        
        temp = new_id.toCharArray();
        sb = new StringBuilder();
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == '-' ||
              temp[i] == '_' || 
              (temp[i] >= '0' && temp[i] <= '9')||
              (temp[i] >= 'a' && temp[i] <= 'z')){
                sb.append(temp[i]);
            }else if(temp[i] == '.'){
                sb.append(temp[i]);
                while(i+1 < temp.length && temp[i+1] == '.') i++;
            }
        }new_id = sb.toString();
        //System.out.println(new_id);
        
        // 4
        int s = 0;
        int e = new_id.length() - 1;
        while(s < new_id.length() && new_id.charAt(s) == '.') s++;
        while(e >= 0 && new_id.charAt(e) == '.') e--;
        if(s > e)new_id = "";
        else new_id = new_id.substring(s,e+1);
        
        //5
        if(new_id.length() == 0)new_id = "a";
        
        //6
        if(new_id.length() >= 15){
            new_id = new_id.substring(0,15);
            e = new_id.length() - 1;
            while(e >= 0 && new_id.charAt(e) == '.') e--;
            
            if(e < 0)new_id = "";
            else new_id = new_id.substring(0,e+1);
        }
        
        // 7
        char p = new_id.charAt(new_id.length()-1);
        while(new_id.length() < 3)new_id += p;
        
        //System.out.println(new_id);
        return new_id;
    }
}