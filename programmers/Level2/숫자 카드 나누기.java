import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        return Math.max(val(arrayB, maxDiv(arrayA)), val(arrayA, maxDiv(arrayB)));
    }
    
    public int maxDiv(int[] arr) {
        int result = 1;
        loop: for (int i = arr[0]; i > 1; i--) {
            for (int t = 0; t < arr.length; t++) {
                if (arr[t] % i != 0) {
                    continue loop;
                }
            }
            result = i;
            break;
        }
        return result;
    }
    
    public int val(int[] arr, int num) {
        loop: for (int i = num; i > 1; i--) {
            if (num % i != 0) continue loop;
            for (int t = 0; t < arr.length; t++) {
                if (arr[t] % i == 0) {
                    continue loop;
                }
            }
            return i;
        }
        return 0;
    }
}