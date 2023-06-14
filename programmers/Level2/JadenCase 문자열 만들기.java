class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        int check = 1;
        
        for (int i = 0; i < s.length(); i++) {
            if (check == 1 && s.charAt(i) != ' ') {
                s = s.substring(0,i) + s.substring(i,i+1).toUpperCase() + s.substring(i+1);
                check = 0;
            }
            
            if (s.charAt(i) == ' ') {
                check = 1;
            }
        }
        
        answer = s;
        
        return answer;
    }
}