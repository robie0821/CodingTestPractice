import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    ArrayList<Meet> arr = new ArrayList<>();
    
    public String[] solution(int[][] line) {
        
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Meet meet = valMeet(line[i], line[j]);
                if (meet != null) {
                    arr.add(meet);
                }
            }
        }
        
        long xmin = Long.MAX_VALUE, xmax = Long.MIN_VALUE;
        long ymin = Long.MAX_VALUE, ymax = Long.MIN_VALUE;
        
        for (int i = 0; i < arr.size(); i++) {
            xmin = Math.min(xmin, arr.get(i).x);
            xmax = Math.max(xmax, arr.get(i).x);
            ymin = Math.min(ymin, arr.get(i).y);
            ymax = Math.max(ymax, arr.get(i).y);
        }
        
        int height = (int) (ymax - ymin) + 1;
        int width = (int) (xmax - xmin) + 1;
        
        boolean[][] star = new boolean[height][width];
        String[] answer = new String[height];
        
        for (int i = 0; i < arr.size(); i++) {
            int x = (int) (arr.get(i).x - xmin);
            int y = (int) (ymax - arr.get(i).y);
            star[y][x] = true;
        }
        
        for (int i = 0; i < height; i++) {
            String str = "";
            for (int j = 0; j < width; j++) {
                if (star[i][j]) str += "*";
                else str += ".";
            }
            answer[i] = str;
        }

        return answer;
    }
    
    public Meet valMeet(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];
        long val = A*D - B*C;
        
        if (val == 0) return null;
        
        long x = (B*F - E*D);
        long y = (E*C - A*F);
        
        if (x % val == 0 && y % val == 0) {
            Meet meet = new Meet(x/val, y/val);
            return meet;
        }
        return null;
    }
    
    class Meet {
        long x;
        long y;
        
        public Meet(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}