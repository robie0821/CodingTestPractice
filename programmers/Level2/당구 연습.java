class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int case1 = 0, case2 = 0, case3 = 0, case4 = 0;
            if(!(startY == balls[i][1] && balls[i][0] <= startX)) {
                case1 = (int)Math.pow((startX + balls[i][0]), 2) + (int)Math.pow((startY - balls[i][1]), 2);
            }
            
            if(!(startX == balls[i][0] && balls[i][1] <= startY)) {
                case2 = (int)Math.pow((startX - balls[i][0]), 2) + (int)Math.pow((startY + balls[i][1]), 2);
            }
            
            if(!(startY == balls[i][1] && balls[i][0] >= startX)) {
                case3 = (int)Math.pow((2 * m - startX - balls[i][0]), 2) + (int)Math.pow((startY - balls[i][1]), 2);
            }
            
            if(!(startX == balls[i][0] && balls[i][1] >= startY)) {
                case4 = (int)Math.pow((startX - balls[i][0]), 2) + (int)Math.pow((2 * n - startY - balls[i][1]), 2);
            }
            
            answer[i] = min(min(case1, case2), min(case3, case4));
        }
        return answer;
    }
    
    public int min(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        if(a > b) return b;
        else return a;
     }
}