class Solution {
    int MAX = 9999999;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int [N][N];
        int[] dist = new int[N];
        boolean[] visit = new boolean[N];
        visit[0] = true;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = MAX;
                }
            }
        }
        
        for (int[] temp : road) {
            if (map[temp[0]-1][temp[1]-1] > temp[2]) {
                map[temp[0]-1][temp[1]-1] = temp[2];
                map[temp[1]-1][temp[0]-1] = temp[2];
            }
        }
        
        for (int i = 1; i < N; i++) {
            dist[i] = map[0][i];
        }
        
        for (int t = 0; t < N - 1; t++) {
            
            int index = 0;
            int min = MAX;
            
            for (int i = 1; i < N; i++) {
                if (!visit[i] && dist[i] < min) {
                    min = dist[i];
                    index = i;
                }
            }
            
            visit[index] = true;
            
            for (int i = 1; i < N; i++) {
                if (dist[i] > dist[index] + map[index][i]) {
                    dist[i] = dist[index] + map[index][i];
                }
            }
        }
        
        for (int temp : dist) {
            if (temp <= K)
                answer++;
        }
        return answer;
    }
}