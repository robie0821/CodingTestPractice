import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[][] visit = new int[maps.length][maps[0].length];
        visit[0][0] = 1;
        
        Queue<node> q = new LinkedList<>();
        q.add(new node(0, 0, 0));

        while (!q.isEmpty()) {
            
            node n = q.remove();
            int i = n.i;
            int j = n.j;
            int count = n.count;
            
            if (i == maps.length - 1 && j == maps[0].length - 1) {
                return count + 1;
            }
            
            if (i < maps.length - 1 && maps[i + 1][j] == 1 && visit[i + 1][j] == 0) {
                visit[i + 1][j] = 1;
                q.add(new node(i + 1, j, count + 1));
            }
            if (j < maps[0].length - 1 && maps[i][j + 1] == 1 && visit[i][j + 1] == 0) {
                visit[i][j + 1] = 1;
                q.add(new node(i, j + 1, count + 1));
            }
            if (i > 0 && maps[i - 1][j] == 1 && visit[i - 1][j] == 0) {
                visit[i - 1][j] = 1;
                q.add(new node(i - 1, j, count + 1));
            }
            if (j > 0 && maps[i][j - 1] == 1 && visit[i][j - 1] == 0) {
                visit[i][j - 1] = 1;
                q.add(new node(i, j - 1, count + 1));
            }
        }
        return -1;
    }
    
    public class node {
        int i;
        int j;
        int count;

        public node(int i, int j, int count) {
          this.i = i;
          this.j = j;
          this.count = count;
        }
    }
}