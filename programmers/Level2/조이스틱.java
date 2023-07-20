class Solution {
    boolean[] visit;
    public int solution(String name) {
        int answer = 0;
        visit = new boolean[name.length()];
        visit[0] = true;
        
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += count(name.charAt(i));
            } else {
                visit[i] = true;
            }
        }
        
        answer += dfs(name, 0);
        return answer;
    }
    
    public int dfs(String name, int index) {
        int right = 0;
        int left = 0;
        
        for (int i = 1; i < name.length(); i++) {
            int temp = index + i;
            if (temp >= name.length()) {
                temp -= name.length();
            }
            
            if (!visit[temp]) {
                visit[temp] = true;
                right = i + dfs(name, temp);
                visit[temp] = false;
                break;
            }
        }
        
        for (int i = 1; i < name.length(); i++) {
            int temp = index - i;
            if (temp < 0) {
                temp += name.length();
            }
            
            if (!visit[temp]) {
                visit[temp] = true;
                left = i + dfs(name, temp);
                visit[temp] = false;
                break;
            }
        }
        
        return min(left, right);
    }
    
    public int min(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) return b;
        else return a;
    }
    
    public int count (char word) {
        if (word > 'A' && word < 'O') {
            return word - 'A';
        } else {
            return 'Z' - word + 1;
        }
    }
}