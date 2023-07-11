class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            answer[i] = spin(arr, queries[i]);
        }
        
        return answer;
    }
    
    public int spin(int[][] arr, int[] range) {
        int i = range[0] - 1;
        int j = range[1] - 1;
        int temp = arr[i][j];
        int min = temp;
        
        while (i < range[2] - 1) {
            arr[i][j] = arr[i+1][j];
            if (arr[i][j] < min) {
                min = arr[i][j];
            }
            i++;
        }
        
        while (j < range[3] - 1) {
            arr[i][j] = arr[i][j + 1];
            if (arr[i][j] < min) {
                min = arr[i][j];
            }
            j++;
        }
        
        while (i > range[0] - 1) {
            arr[i][j] = arr[i-1][j];
            if (arr[i][j] < min) {
                min = arr[i][j];
            }
            i--;
        }
        
        while (j > range[1]) {
            arr[i][j] = arr[i][j - 1];
            if (arr[i][j] < min) {
                min = arr[i][j];
            }
            j--;
        }
        
        arr[i][j] = temp;
        
        return min;
    }
}