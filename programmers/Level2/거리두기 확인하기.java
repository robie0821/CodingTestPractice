class Solution {
    
    char[][] arr;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        loop: for (int t = 0; t < 5; t++){
            arr = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = places[t][i].charAt(j);
                }
            }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] == 'P') {
                        if (!val(i, j)) {
                            answer[t] = 0;
                            continue loop;
                        }
                    }
                }
            }
            answer[t] = 1;
        }
        return answer;
    }
    
    public boolean val(int i, int j) {
        if (i > 0 && arr[i-1][j] != 'X') {
            if (arr[i-1][j] == 'P') return false;
            
            if (i > 1 && arr[i-1][j] == 'P') return false;

            if (j > 0 && arr[i-1][j-1] == 'P') return false;
            
            if (j < 4 && arr[i-1][j+1] == 'P') return false;
        }
        
        if (j > 0 && arr[i][j-1] != 'X') {
            if (arr[i][j-1] == 'P') return false;
            
            if (i > 0 && arr[i-1][j-1] == 'P') return false;
            
            if (j > 1 && arr[i][j-2] == 'P') return false;
            
            if (i < 4 && arr[i+1][j-1] == 'P') return false;
        }
        
        if (i < 4 && arr[i+1][j] != 'X') {
            if (arr[i+1][j] == 'P') return false;
            
            if (j > 0 && arr[i+1][j-1] == 'P') return false;
            
            if (i < 3 && arr[i+2][j] == 'P') return false;
            
            if (j < 4 && arr[i+1][j+1] == 'P') return false;
        }
        
        if (j < 4 && arr[i][j+1] != 'X') {
            if (arr[i][j+1] == 'P') return false;
            
            if (i > 0 && arr[i-1][j+1] == 'P') return false;
            
            if (j < 3 && arr[i][j+2] == 'P') return false;
            
            if (i < 4 && arr[i+1][j+1] == 'P') return false;
        }
        
        return true;
    }
}