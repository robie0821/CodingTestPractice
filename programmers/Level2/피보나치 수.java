class Solution {
    public int solution(int n) {

        int f1 = 0;
        int f2 = 1;
        
        for(int i = 0; i < n; i++) {
            int temp = f2 % 1234567;
            f2 = (f1 % 1234567 + f2 % 1234567) % 1234567;
            f1 = temp;
        }
        
        int answer = f1;
        return answer;
    }
}