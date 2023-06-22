import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = A.length - 1;
        
        for (int i = B.length - 1; i >= 0; i--) {
            
            for(int j = index; j >= 0; j--) {
                if (B[i] > A[j]) {
                    answer++;
                    index = j - 1;
                    break;
                }
            }
        }
        return answer;
    }
}