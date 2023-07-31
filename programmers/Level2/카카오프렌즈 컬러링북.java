import java.util.*;

class Solution {
    boolean[][] visit;
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        
        int[] answer = new int[2];
        int count = 0;
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    count++;
                    int temp = bfs(picture, i, j, m, n);
                    max = Math.max(max, temp);
                }
            }
        }
        
        answer[0] = count;
        answer[1] = max;
        return answer;
    }
    
    public int bfs (int[][] picture, int I, int J, int m, int n) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(I, J));
        visit[I][J] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            result++;
            
            int i = node.i;
            int j = node.j;
            
            if (i > 0 && !visit[i-1][j] && picture[i-1][j] == picture[i][j]) {
                q.add(new Node(i-1,j));
                visit[i-1][j] = true;
            }
            
            if (j > 0 && !visit[i][j-1] && picture[i][j-1] == picture[i][j]) {
                q.add(new Node(i,j-1));
                visit[i][j-1] = true;
            }
            
            if (i < m-1 && !visit[i+1][j] && picture[i+1][j] == picture[i][j]) {
                q.add(new Node(i+1,j));
                visit[i+1][j] = true;
            }
            
            if (j < n-1 && !visit[i][j+1] && picture[i][j+1] == picture[i][j]) {
                q.add(new Node(i,j+1));
                visit[i][j+1] = true;
            }
        }
        return result;
    }
    
    class Node {
        int i; int j;
        public Node(int i, int j) {
            this.i = i; this.j = j;
        }
    }
}