import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        if (n == 1) {
            int[] answer = {1};
            return answer;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[n][n];
       
        {
            int i = 0;
            int j = 0;
            int num = 1;
            
            while (true) {
                while (i < n) {
                    arr[i][j] = num++;
                    if (i + 1 >= n || arr[i+1][j] != 0) {
                        break;
                    }
                    i++;
                }
                j++;
                
                if (arr[i][j] != 0) {
                    break;
                }
                
                while (j < n) {
                    arr[i][j] = num++;
                    if (j + 1 >= n || arr[i][j+1] != 0) {
                        break;
                    }
                    j++;
                }
                i--; j--;
                
                if (arr[i][j] != 0) {
                    break;
                }

                while (i > 0) {
                    arr[i][j] = num++;
                    if (i - 1 < 0 || arr[i - 1][j - 1] != 0) {
                        break;
                    }
                    i--;
                    j--;
                }
                i++;
                
                if (arr[i][j] != 0) {
                    break;
                }
            }
            
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                list.add(arr[i][j]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}