class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int[]sum = new int[elements.length * 2];
        boolean[]num = new boolean[1000001];
        sum[0] = elements[0];
        
        for(int i = 1; i < elements.length * 2; i++){
            int j = i;
            if(i >= elements.length) j = i - elements.length;
            sum[i] = elements[j] + sum[i-1];
            
        }
        
        for(int len = 1; len <= elements.length; len++){
            
            for(int j = 0; j + len < elements.length*2; j++){
                int temp;
                
                temp = sum[j + len] - sum[j];
                //System.out.println(len + " " + j + " " + temp);
                if(num[temp] != true){num[temp] = true; answer++;}
                
            }
        }
        
        return answer;
    }
}