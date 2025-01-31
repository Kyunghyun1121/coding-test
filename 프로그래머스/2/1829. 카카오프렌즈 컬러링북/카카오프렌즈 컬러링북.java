class Solution {
    boolean[][]rem;
    int[][]arr;
    int size = 0;
    int[]dx = {0,0,-1,1};
    int[]dy = {-1,1,0,0};
    int width = 0; int height = 0;
    int count = 0;
    
    public void dfs(int x, int y){
        if(rem[x][y])return;
        rem[x][y] = true;
        count++;
        //System.out.println(x + " " + y + " " + count);
        
        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx >= 0 && mx < height && my >= 0 && my < width && !rem[mx][my] &&
              arr[mx][my] == arr[x][y]){
                dfs(mx, my);
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        width = n; height = m;

        rem = new boolean[m][n];
        arr = picture;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0)rem[i][j] = true;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rem[i][j])continue;
                numberOfArea++;
                count = 0;
                dfs(i,j);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}