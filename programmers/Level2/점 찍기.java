class Solution {
    public long solution(int k, int d) {
        if (d == 0) {
            return 0;
        }
        
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            answer += (long)(Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2))) / k + 1;
        }
        
        return answer;
    }
}