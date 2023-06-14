class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int check = 0;

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == '(') {
                check++;
            } else {
                check--;
            }
            
            if (check < 0) {
                answer = false;
                break;
            }
        }
        
        if(check != 0) {
            answer = false;
        }

        return answer;
    }
}