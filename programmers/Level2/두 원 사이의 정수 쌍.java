class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long rr1 = (long) Math.pow(r1, 2);
        long rr2 = (long) Math.pow(r2, 2);
        
        for (long i = 1; i <= r2; i++) {
            long mins = rr1 - i*i;
            long maxs = rr2 - i*i;
            
            long min = (long) Math.ceil((double) Math.sqrt(mins));
            long max = (long) Math.floor((double) Math.sqrt(maxs));
            
            long temp = max - min + 1;
            
            answer += temp;
        }
        
        answer = 4 * answer;
        
        return answer;
    }
}