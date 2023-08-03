import java.util.*;

class Solution {
    
    boolean[][] visit;
    char[][] map;
    int h;
    int w;
    
    Node start;
    Node end;
    
    int[] di = {-1,0,1,0};
    int[] dj = {0,-1,0,1};
    
    public int solution(String[] board) {
        int answer = -1;
        h = board.length;
        w = board[0].length();
        visit = new boolean[h][w];
        map = new char[h][w];
        
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new Node(i, j, 0);
                    visit[i][j] = true;
                    q.offer(start);
                } else if (map[i][j] == 'G') {
                    end = new Node(i, j, 0);
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.equals(end)) {
                answer = cur.count;
                break;
            }
            
            for (int t = 0; t < 4; t++) {
                int i = cur.i + di[t];
                int j = cur.j + dj[t];
                while (i >= 0 && j >= 0 && i < h && j < w && map[i][j] != 'D') {
                    i += di[t];
                    j += dj[t];
                }
                i -= di[t];
                j -= dj[t];
                
                if (!visit[i][j]) {
                    q.offer(new Node(i, j, cur.count+1));
                    visit[i][j] = true;
                }
            }
        }
        return answer;
    }
    
    class Node {
        int i; int j; int count;
        public Node(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
        
        public boolean equals(Node node) {
            if (this.i == node.i && this.j == node.j) {
                return true;
            }
            return false;
        }
    }
}