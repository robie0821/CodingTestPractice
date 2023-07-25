class Solution {
    
    int[] map;
    int length;
    int answer = 0;
    
    public int solution(int n) {
        map = new int[n];
        length = n;

        queen(0);
        
        return answer;
    }
    
    public void queen(int level) {
        if (level == length) {
            answer++;
            return;
        }
        
        for (int i = 0; i < length; i++) {
            map[level] = i;
            
            if (val(level)) {
                queen(level+1);
            }
        }
    }
    
    public boolean val(int level) {
        for (int t = 0; t < level; t++) {
            if (map[level] == map[t] || Math.abs(map[level] - map[t]) == Math.abs(level - t)) {
                return false;
            }
        }
        return true;
    }
}