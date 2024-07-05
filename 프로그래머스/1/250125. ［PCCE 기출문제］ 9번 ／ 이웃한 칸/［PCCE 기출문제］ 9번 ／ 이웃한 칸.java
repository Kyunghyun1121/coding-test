
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        
        int[] y = {0,0,-1,1};
        int[] x = {-1,1,0,0};
        int l = board.length;
        
        for(int i = 0; i < 4; i++){
            int tx = w + x[i];
            int ty = h + y[i];
            if(tx < 0 || tx >= l || ty < 0 || ty >= l)continue;
            if(color.equals(board[ty][tx]))answer++;
        }
        return answer;
    }
}