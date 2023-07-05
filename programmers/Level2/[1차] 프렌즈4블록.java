import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            boolean stop = true;
            int[][] check = new int[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] != '-' && isVal(arr, i, j)) {
                        check[i][j] = 1;
                        check[i][j + 1] = 1;
                        check[i + 1][j] = 1;
                        check[i + 1][j + 1] = 1;
                        stop = false;
                    }
                }
            }
            
            if (stop) {
                break;
            }
            
            answer += pop(arr, check);
            arr = sort(arr, m, n);
        }
        return answer;
    }
    
    public boolean isVal(char[][] arr, int i, int j) {
        if (arr[i][j] == arr[i][j + 1] &&
            arr[i][j] == arr[i + 1][j] &&
            arr[i][j] == arr[i + 1][j + 1]) {
            return true;
        }
        return false;
    }
    
    public int pop(char[][] arr, int[][] check) {
        int result = 0;
        for (int i = 0; i < check.length; i++){
            for (int j = 0; j < check[i].length; j++) {
                if (check[i][j] == 1) {
                    arr[i][j] = '-';
                    result++;
                }
            }
        }
        return result;
    }
    
    public char[][] sort(char[][] arr, int m, int n) {
        char[][] temp = new char[m][n];
        for (int j = 0; j < n; j++) {
            Queue<Character> q = new LinkedList<>();
            for (int i = m - 1; i >= 0; i--) {
                if (arr[i][j] != '-') {
                    q.offer(arr[i][j]);
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                if (!q.isEmpty()) {
                    temp[i][j] = q.poll();
                } else {
                    temp[i][j] = '-';
                }
            }
        }
        return temp;
    }
}