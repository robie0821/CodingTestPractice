class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        
        while (true) {
            int nzero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) =='0') {
                    zero++;
                } else {
                    nzero++;
                }
            }
            count++;
            if(nzero == 1) {
                break;
            } 
            s = Integer.toBinaryString(nzero);
        }
        
        
        int[] answer = {count, zero};
        return answer;
    }
}