class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int activeTime = bandage[0];
        int recoverySecond = bandage[1];
        int recoveryPlus = bandage[2];
        int maxHealth = health;
        
        int attackCount = 0;
        int tryTime = 0;
        
        
        int answer = 0;
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++){
            if(i == attacks[attackCount][0]){
                health -= attacks[attackCount][1];
                if(health <= 0){
                    answer = -1;
                    break;
                }
                tryTime = 0;
                attackCount++;
            }else{
                tryTime++;
                if(tryTime == activeTime) {
                    health += recoveryPlus;
                    tryTime = 0;
                }
                health += recoverySecond;
                if(maxHealth < health) health = maxHealth;
            }
        }
        
        if(answer != -1) answer = health;

        return answer;
    }
}