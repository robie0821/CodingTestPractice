import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        k--;
        int[] answer = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        long fact = 1;
        
        for (int i = 1; i <= n; i++) {
            fact *= i;
            arr.add(i);
        }
        
        
        int index= 0;
        while (n > 0) {
            fact /= n--;
            answer[index++] = arr.remove((int)(k / fact));
            k %= fact;
        }
        
        return answer;
    }
}