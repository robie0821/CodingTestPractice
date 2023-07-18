import java.util.ArrayList;

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        moving(1, 3, n);
        
        int[][] answer = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            answer[i][0] = temp / 10;
            answer[i][1] = temp % 10;
        }
        
        return answer;
    }
    
    public void moving(int i, int j, int n) {
        if (n == 1) {
            arr.add(i*10 + j);
            return;
        }
        
        int k = 6 - i - j;
        
        moving(i, k, n-1);
        arr.add(i*10 + j);
        moving(k, j, n-1);
    }
}