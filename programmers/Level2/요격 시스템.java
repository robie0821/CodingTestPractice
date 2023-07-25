import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int n;
    public int solution(int[][] targets) {
        int answer = 0;
        n = targets.length;
        
        Arrays.sort(targets, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        
        int missile = -1;
        for (int t = 0; t < n; t++) {
            if (targets[t][0] < missile)
                continue;
            missile = targets[t][1];
            answer++;
        }
        
        return answer;
    }
}