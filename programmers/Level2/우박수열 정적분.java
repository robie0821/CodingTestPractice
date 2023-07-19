import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Double> width = new ArrayList<>();
        long num = k;
        arr.add(num);
        
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
            
            arr.add(num);
        }
        
        for (int i = 0; i < arr.size() - 1; i++) {
            width.add((arr.get(i) + arr.get(i+1)) / 2.0);
        }
        
        for (int t = 0; t < ranges.length; t++) {
            int start = ranges[t][0];
            int end = width.size() + ranges[t][1];
            
            if (start > end) {
                answer[t] = -1.0;
            } else if(start == end) {
                answer[t] = 0;
            } else {
                for (int i = start; i < end; i++) {
                    answer[t] += width.get(i);
                }
            }
        }
        
        return answer;
    }
}