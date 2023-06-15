class Solution {
        int answer = 0;
    public int solution(int n, int[][] computers) {
        
        int[] check = new int[n];

        for(int i = 0; i < n; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                answer++;
                dfs(computers, check, i);
            }
        }
        return answer;
    }
    
    void dfs (int[][] arr, int[]check, int index) {
        for(int i = 0; i < check.length; i++) {
            if (arr[index][i] == 1 && check[i] == 0) {
                check[i] = 1;
                dfs(arr, check, i);
            }
        }
    }
}