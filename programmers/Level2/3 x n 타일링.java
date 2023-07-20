class Solution {
    public int solution(int n) {
        int answer = 0;
        n /= 2;
        long[] cases = new long[n];
        cases[0] = 3;
        
        for (int t = 1; t < n; t++) {
            cases[t] = (cases[t-1] * 3) % 1000000007 + 2;
            
            for (int i = 0; i < t-1; i++) {
                cases[t] = (cases[t] + cases[i] * 2) % 1000000007;
            }
        }
        
        answer = (int) cases[n-1];
        return answer;
    }
}