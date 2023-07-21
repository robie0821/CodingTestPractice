import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        Arrays.sort(data, (a, b) ->
                if (a[col-1] == b[col-1]) {
                    return b[0] - a[0];
                } else {
                    return a[col-1] - b[col-1];
                }
            });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i][j] % (i+1);
            }
            arr.add(sum);
        }
        
        int answer = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            answer ^=  arr.get(i);
        }
        
        return answer;
    }
}