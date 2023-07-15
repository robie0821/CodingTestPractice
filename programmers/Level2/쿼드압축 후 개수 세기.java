class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    
    void quad(int[][] arr, int row, int col, int size) {
        
        if (check(arr, row, col, size)) {
            if (arr[row][col] == 0) {
                answer[0]++;
            } else if (arr[row][col] == 1) {
                answer[1]++;
            }
        } else {
            quad(arr, row, col, size / 2);
            quad(arr, row + size / 2, col, size / 2);
            quad(arr, row, col + size / 2, size / 2);
            quad(arr, row + size / 2, col + size / 2, size / 2);
        }
    }
    
    boolean check(int[][] arr, int row, int col, int size) {
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[row][col] != arr[row + i][col + j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}