import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<List<Integer>> q = new LinkedList<>();
        if (x == y) {
            return 0;
        }
        
        if (y - n >= x) {
            q.offer(Arrays.asList(y - n, 1));
        }
            
        if (y % 2 == 0 && y / 2  >= x) {
            q.offer(Arrays.asList(y / 2, 1));
        }

        if (y % 3 == 0 && y / 3  >= x) {
            q.offer(Arrays.asList(y / 3, 1));
        }
        
        while (true) {
            
            if (q.size() == 0) {
                return -1;
            }
            
            List<Integer> arr = q.poll();
            
            if (arr.get(0) == x) {
                answer = arr.get(1);
                break;
            }
            
            if (arr.get(0) - n >= x) {
                q.offer(Arrays.asList(arr.get(0) - n, arr.get(1) + 1));
            }
            
            if (arr.get(0) % 2 == 0 && arr.get(0) / 2  >= x) {
                q.offer(Arrays.asList(arr.get(0) / 2, arr.get(1) + 1));
            }
            
            if (arr.get(0) % 3 == 0 && arr.get(0) / 3  >= x) {
                q.offer(Arrays.asList(arr.get(0) / 3, arr.get(1) + 1));
            }
            
        }
        
        return answer;
    }
}