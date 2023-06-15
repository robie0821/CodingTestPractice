class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int [(int)(right -left + 1)];
        
        for(long i = left; i <= right; i++) {
            int height = (int)(i / n + 1);
            int width = (int)(i % n + 1);
            answer[(int)(i - left)] = max(height, width);
        }
        
        return answer;
    }
    
    int max(int a, int b) {
        if (a >= b) return a;
        else return b;
    }
}