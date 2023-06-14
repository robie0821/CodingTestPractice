class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String bin = Integer.toBinaryString(n);
        int count = 0;
        
        for (int i = 0; i < bin.length(); i++) {
            if(bin.charAt(i) == '1') {
                count++;
            }
        }
        
        for (int i = n + 1; ; i++) {
            String str = Integer.toBinaryString(i);
            int check = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '1') {
                    check++;
                }
            }
            
            if (count == check) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}