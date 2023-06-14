class Solution {
    public long solution(int n) {
        long x = 1;
        long y = 0;
        
        for (int i = 0; i < n; i++) {
            long temp = x;
            x = (x+ y) % 1234567;
            y = temp % 1234567;
        }
        return x;
    }
}