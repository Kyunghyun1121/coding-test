class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = new char[s.length()];
        int p = 0; int y = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P' )p++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y' )y++;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(p);
        if(p == y) answer=true;
        else answer = false;
        return answer;
    }
}