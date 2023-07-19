class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = dfs(picks, minerals, 0);
        
        return answer;
    }
    
    public int dfs(int[] picks, String[] minerals, int index) {
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            return 0;
        }
        
        if (index >= minerals.length) {
            return 0;
        }
        
        int dia = 0;
        int iron = 0;
        int stone = 0;
        
        if (picks[0] != 0) {
            picks[0]--;
            for (int i = index; i < index + 5; i++) {
                if (i == minerals.length) {
                    break;
                }
                dia += 1;
            }

            dia += dfs(picks, minerals, index + 5);
            picks[0]++;
        }
        
        if (picks[1] != 0) {
            picks[1]--;
            for (int i = index; i < index + 5; i++) {
                if (i > minerals.length - 1) {
                    break;
                }
                
                if (minerals[i].equals("diamond")) {
                    iron += 5;
                } else {
                    iron += 1;
                }
            }

            iron += dfs(picks, minerals, index + 5);
            picks[1]++;
        }
        
        if (picks[2] != 0) {
            picks[2]--;
            for (int i = index; i < index + 5; i++) {
                if (i > minerals.length - 1) {
                    break;
                }
                
                switch(minerals[i]) {
                    case "diamond":
                        stone += 25;
                        break;
                        
                    case "iron":
                        stone += 5;
                        break;
                        
                    case "stone":
                        stone += 1;
                        break;
                }
            }

            stone += dfs(picks, minerals, index + 5);
            picks[2]++;
        }
        
        return min(dia, min(iron, stone));
        
    }
    
    public int min (int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) return b;
        else return a;
    }
}