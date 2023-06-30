class Solution {
    public int solution(int n) {
        int case0 = 0;
        int case1 = 1;
        
        for (int i = 0; i < n; i++) {
            int temp = case1;
            case1 = (case1 + case0)%1000000007;
            case0 = temp;
        }
        
        return case1;
    }
}